package nl.hu.inno.humc.student.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.student.application.exceptions.VakBestaatNietException;
import nl.hu.inno.humc.student.data.StudentRepository;
import nl.hu.inno.humc.student.domain.Opleiding;
import nl.hu.inno.humc.student.domain.Student;
import nl.hu.inno.humc.student.domain.StudentBuilder;
import nl.hu.inno.humc.student.domain.Vak;
import nl.hu.inno.humc.student.messaging.outbound.StudentProducer;
import nl.hu.inno.humc.student.presentation.dto.OpleidingInschrijvingDto;
import nl.hu.inno.humc.student.presentation.dto.StudentDto;
import nl.hu.inno.humc.student.presentation.dto.VakInschrijvingDto;
import nl.hu.inno.humc.student.presentation.exceptions.StudentBestaatNietException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepo;
    private final VakService vakService;
    private final OpleidingService opleidingService;
    private final StudentProducer studentProducer;

    private final StudentClient studentClient;

    StudentService(StudentRepository studentRepository, StudentProducer studentRabbitProducer, VakService vakService, OpleidingService opleidingService, StudentClient studentClient) {
        this.studentRepo = studentRepository;
        this.studentProducer = studentRabbitProducer;
        this.vakService = vakService;
        this.opleidingService = opleidingService;
        this.studentClient = studentClient;
    }

    public StudentDto getStudentById(String id){
        Optional<Student> student = studentRepo.findById(id);
        if (student.isEmpty()) throw new StudentBestaatNietException();
        return StudentDto.Of(student.get());
    }

    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepo.findAll();
        students.forEach((student) -> System.out.println(student.getStudentId()));
        return StudentDto.Of(students);
    }

    public StudentDto registreerStudent(StudentDto dto) {
        Student student = new StudentBuilder()
                .withNaam(dto.getVoornaam(), dto.getAchternaam(), dto.getRoepnaam())
                .withEmail(dto.getEmail())
                .withTelefoonNummer(dto.getTelefoonNummer())
                .withAdres(dto.getPlaats(), dto.getPostcode(), dto.getStraat(), dto.getHuisnummer())
                .withGeboortedatum(dto.getGeboortedatum())
                .withVooropleiding(dto.getVooropleiding())
                .build();


        // Send student to the canvas application
        // Preferably this would be done via messaging, but REST is the only option for now
        // the canvas application generates as student id and returns it to us
        String studentNummer = studentClient.registreerStudent(dto.getVoornaam(), dto.getAchternaam());
        student.geefStudentNummer(studentNummer);

        student = studentRepo.save(student);

        // Send student to queue so the other microservices can process it
        StudentDto studentDto = StudentDto.Of(student);
        studentProducer.sendNewStudentToQueue(studentDto);

        return studentDto;
    }

    public StudentDto schrijfStudentInVoorOpleiding(String studentId, String opleidingId) {

        // TODO Opleiding opvragen uit de opleiding module/service
        // TODO Opleiding microservice koppelen aan de gehele applicatie wanneer deze beschikbaar is
        //Opleiding opleiding = this.opleidingService.getOpleidingById(opleidingId);
        Opleiding opleiding = new Opleiding("398762346823", "HBO-ICT", LocalDate.now().minusYears(1), LocalDate.now().plusYears(1), 100);
        Student student = studentRepo.findById(studentId).orElseThrow(StudentBestaatNietException::new);
        // Als er meer dan 10 plekken beschikbaar zijn, schrijf de student in via messaging
        if(opleiding.getBeschikbarePlekken() > 10){
            student.schrijfInVoorOpleiding(opleiding);
            this.opleidingService.plaatsNieuweInschrijvingInQueue(new OpleidingInschrijvingDto(studentId, opleidingId));
            studentRepo.save(student);
        }
        else {
            // als er minder dan 10 plekken beschikbaar zijn in dit systeem, check dan nog even via REST of er daadwerkelijk nog plek is
        }

        StudentDto studentDto = StudentDto.Of(student);
        // Send student to queue so the other microservices can process it
        studentProducer.sendUpdatedStudentToQueue(studentDto);
        return studentDto;
    }

    public StudentDto schrijfStudentInVoorVak(VakInschrijvingDto dto) throws VakBestaatNietException {
        Student student = studentRepo.findById(dto.getStudentId()).orElseThrow(StudentBestaatNietException::new);
        Vak vak = vakService.getVakById(dto.getVakId());
        System.out.println(dto.getVakId());

        if (vak.getBeschikbarePlekken() > 10) {

            student.schrijfInVoorVak(vak);
            // Abdel toevoeging
            vakService.plaatseNieuweInschrijvingInQueue(new VakInschrijvingDto(student.getStudentId(), vak.getId(), student.getPersoonsGegevens().getNaam().getVoornaam()));
            studentRepo.save(student);
            System.out.println("Student is ingeschreven voor vak");
        }
        else {
            // als er minder dan 10 plekken beschikbaar zijn in dit systeem, check dan nog even via RPC of er daadwerkelijk nog plek is
            try {
                vakService.ManuallyUpdateVakViaRest(dto.getVakId());
                Vak updatedVak = vakService.getVakById(dto.getVakId());
                if (updatedVak.getBeschikbarePlekken() > 0) {

                    student.schrijfInVoorVak(vak);
                    vakService.plaatseNieuweInschrijvingInQueue(new VakInschrijvingDto(student.getStudentId(), vak.getId(), student.getPersoonsGegevens().getNaam().getVoornaam()));
                    studentRepo.save(student);
                    System.out.println("Student is ingeschreven voor vak");
                }
            }
            catch (Exception e){
                System.out.println("Vakken service is tijdelijk niet beschrikbaar, probeer het later nog eens");
            }

        }

        studentRepo.save(student);

        StudentDto studentDto = StudentDto.Of(student);
        // Send student to queue so the other microservices can process it
        studentProducer.sendUpdatedStudentToQueue(studentDto);
        return studentDto;
    }

    public StudentDto schrijfStudentInVoorKlas(String studentId, String klasCode) {
        Student student = studentRepo.findById(studentId).orElseThrow(StudentBestaatNietException::new);
        // Voeg aan klas toe in Canvas
        studentClient.voegStudentToeAanKlas(student.getStudentNummer(), klasCode);
        student.schrijfInVoorKlas(klasCode);
        studentRepo.save(student);

        StudentDto studentDto = StudentDto.Of(student);
        // Send student to queue so the other microservices can process it
        studentProducer.sendUpdatedStudentToQueue(studentDto);
        return studentDto;
    }

    public StudentDto studentHeeftVakBehaald(String studentId, String vakId) throws VakBestaatNietException {

        Student student = studentRepo.findById(studentId).orElseThrow(StudentBestaatNietException::new);
        Vak vak = vakService.getVakById(vakId);
        student.studentHeeftVakBehaald(vak);
        studentRepo.save(student);

        StudentDto studentDto = StudentDto.Of(student);
        // Send student to queue so the other microservices can process it
        studentProducer.sendUpdatedStudentToQueue(studentDto);
        System.out.println("Student heeft vak behaald, " + vak.getStudiePunten() + " studiepunten toegevoegd aan " + studentId );
        return studentDto;
    }
}
