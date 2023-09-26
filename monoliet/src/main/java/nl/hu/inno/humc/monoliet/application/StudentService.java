package nl.hu.inno.humc.monoliet.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.monoliet.data.StudentRepository;
import nl.hu.inno.humc.monoliet.domain.Opleiding;
import nl.hu.inno.humc.monoliet.domain.student.Student;
import nl.hu.inno.humc.monoliet.domain.student.StudentBuilder;
import nl.hu.inno.humc.monoliet.presentation.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepo;
    private final OpleidingService opleidingService;

    StudentService(StudentRepository studentRepository, OpleidingService opleidingService) {
        this.studentRepo = studentRepository;
        this.opleidingService = opleidingService;
    }

    public Optional<Student> getStudentById(Long id){
        return studentRepo.findById(id);
    }

    public Optional<List<Student>> getAllStudents(){
        return Optional.of(studentRepo.findAll());
    }

    public Optional<Student> registreerStudent(StudentDto dto) {
        Student student = new StudentBuilder()
                .withNaam(dto.getVoornaam(), dto.getAchternaam(), dto.getRoepnaam())
                .withEmail(dto.getEmail())
                .withTelefoonNummer(dto.getTelefoonNummer())
                .withAdres(dto.getPlaats(), dto.getPostcode(), dto.getStraat(), dto.getHuisnummer())
                .withGeboortedatum(dto.getGeboortedatum())
                .withVooropleiding(dto.getVooropleiding())
                .build();
        return Optional.of(studentRepo.save(student));
    }

    public Optional<Student> schrijfStudentInVoorOpleiding(Long studentId, Long opleidingId) {
        Optional<Student> maybeStudent = studentRepo.findById(studentId);
        Opleiding opleiding = this.opleidingService.getOpleidingEntityById(opleidingId);
        if (maybeStudent.isPresent()) {
            Student student = maybeStudent.get();
            student.schrijfInVoorOpleiding(opleiding);
            return Optional.of(studentRepo.save(student));
        }
        return Optional.empty();
    }
}
