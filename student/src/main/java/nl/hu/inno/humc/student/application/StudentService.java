package nl.hu.inno.humc.student.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.student.application.exceptions.VakBestaatNietException;
import nl.hu.inno.humc.student.data.StudentRepository;
import nl.hu.inno.humc.student.domain.Opleiding;
import nl.hu.inno.humc.student.domain.Student;
import nl.hu.inno.humc.student.domain.StudentBuilder;
import nl.hu.inno.humc.student.domain.Vak;
import nl.hu.inno.humc.student.presentation.StudentRabbitController;
import nl.hu.inno.humc.student.presentation.dto.StudentDto;
import nl.hu.inno.humc.student.presentation.dto.VakDto;
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

    private final StudentRabbitController studentRabbitController;

    StudentService(StudentRepository studentRepository, StudentRabbitController studentRabbitController, VakService vakService) {
        this.studentRepo = studentRepository;
        this.studentRabbitController = studentRabbitController;
        this.vakService = vakService;

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
        student = studentRepo.save(student);
        StudentDto studentDto = StudentDto.Of(student);
        // Send student to queue so the other microservices can process it
        studentRabbitController.sendStudentToQueue(studentDto);
        return studentDto;
    }

    public StudentDto schrijfStudentInVoorOpleiding(String studentId, Long opleidingId) {

        // TODO Opleiding opvragen uit de opleiding module/service
        // Opleiding opleiding = this.opleidingService.getOpleidingEntityById(opleidingId);
        Student student = studentRepo.findById(studentId).orElseThrow(StudentBestaatNietException::new);
        student.schrijfInVoorOpleiding(Opleiding.getAlleOpleidingen().get(0));
        studentRepo.save(student);

        StudentDto studentDto = StudentDto.Of(student);
        // Send student to queue so the other microservices can process it
        studentRabbitController.sendStudentToQueue(studentDto);
        return studentDto;

    }

    public StudentDto vraagVrijstellingAan(String studentId, String vakId) throws VakBestaatNietException {

        Student student = studentRepo.findById(studentId).orElseThrow(StudentBestaatNietException::new);
        Vak vak = vakService.getVakById(vakId).orElseThrow(VakBestaatNietException::new);
        student.geefStudentVrijstellingVoorVak(vak);
        studentRepo.save(student);

        StudentDto studentDto = StudentDto.Of(student);
        // Send student to queue so the other microservices can process it
        studentRabbitController.sendStudentToQueue(studentDto);
        return studentDto;
    }
}
