package nl.hu.inno.humc.monoliet.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.monoliet.data.StudentRepository;
import nl.hu.inno.humc.monoliet.domain.student.Student;
import nl.hu.inno.humc.monoliet.domain.student.persoonsgegevens.*;
import nl.hu.inno.humc.monoliet.presentation.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepo;

    StudentService(StudentRepository studentRepository) {
        this.studentRepo = studentRepository;
    }

    public Optional<Student> getStudentById(Long id){
        return studentRepo.findById(id);
    }

    public Optional<List<Student>> getAllStudents(){
        return Optional.of(studentRepo.findAll());
    }

    public Optional<Student> registreerStudent(StudentDto dto) {
        // TODO Dit verbeteren
        Naam naam = new Naam(dto.getVoornaam(), dto.getAchternaam(), dto.getRoepnaam());
        Email email = new Email(dto.getEmail());
        TelefoonNummer telefoonNummer = new TelefoonNummer(dto.getTelefoonNummer());
        Adres adres = new Adres(dto.getPlaats(), dto.getPostcode(), dto.getStraat(), dto.getHuisnummer());
        PersoonsGegevens persoonsGegevens = new PersoonsGegevens(naam, dto.getGeboortedatum(), adres, email, telefoonNummer );
        Student student = new Student(persoonsGegevens, dto.getVooropleiding());
        return Optional.of(studentRepo.save(student));
    }

    public Optional<Student> schrijfStudentInVoorOpleiding(Long studentId, Long opleidingId) {
        Optional<Student> maybeStudent = studentRepo.findById(studentId);
        if (maybeStudent.isPresent()) {
            Student student = maybeStudent.get();
            student.schrijfInVoorOpleiding("ICT"); // TODO opleidingId gebruiken
            return Optional.of(studentRepo.save(student));
        }
        return Optional.empty();
    }
}
