package nl.hu.inno.humc.student.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.student.application.exceptions.VakBestaatNietException;
import nl.hu.inno.humc.student.data.StudentRepository;
import nl.hu.inno.humc.student.domain.Opleiding;
import nl.hu.inno.humc.student.domain.Student;
import nl.hu.inno.humc.student.domain.StudentBuilder;
import nl.hu.inno.humc.student.domain.Vak;
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

    StudentService(StudentRepository studentRepository, VakService vakService) {
        this.studentRepo = studentRepository;
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
        return StudentDto.Of(student);
    }

    public StudentDto schrijfStudentInVoorOpleiding(String studentId, Long opleidingId) {
        Optional<Student> maybeStudent = studentRepo.findById(studentId);
        // TODO Opleiding opvragen uit de opleiding module/service
        // Opleiding opleiding = this.opleidingService.getOpleidingEntityById(opleidingId);
        if (maybeStudent.isPresent()) {
            Student student = maybeStudent.get();
            student.schrijfInVoorOpleiding(Opleiding.getAlleOpleidingen().get(0));
            studentRepo.save(student);
            return StudentDto.Of(student);
        }
          throw new StudentBestaatNietException();
    }

    public StudentDto vraagVrijstellingAan(String studentId, String vakId) throws VakBestaatNietException {

        Student student = studentRepo.findById(studentId).orElseThrow(StudentBestaatNietException::new);
        Vak vak = vakService.getVakById(vakId).orElseThrow(VakBestaatNietException::new);
        student.geefStudentVrijstellingVoorVak(vak);
        studentRepo.save(student);
        return StudentDto.Of(student);
    }
}
