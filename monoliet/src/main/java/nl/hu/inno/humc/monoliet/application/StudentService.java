package nl.hu.inno.humc.monoliet.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.monoliet.data.StudentRepository;
import nl.hu.inno.humc.monoliet.domain.Student;
import nl.hu.inno.humc.monoliet.domain.Vooropleiding;
import nl.hu.inno.humc.monoliet.domain.persoonsgegevens.*;
import nl.hu.inno.humc.monoliet.presentation.StudentDto;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepo;

    StudentService(StudentRepository studentRepository) {
        this.studentRepo = studentRepository;
    }

    public Student registreerStudent(StudentDto dto) {
        Naam naam = new Naam(dto.getVoornaam(), dto.getAchternaam(), dto.getRoepnaam());
        Email email = new Email(dto.getEmail());
        TelefoonNummer telefoonNummer = new TelefoonNummer(dto.getTelefoonNummer());
        Adres adres = new Adres(dto.getPlaats(), dto.getPostcode(), dto.getStraat(), dto.getHuisnummer());
        PersoonsGegevens persoonsGegevens = new PersoonsGegevens(naam, dto.getGeboortedatum(), adres, email, telefoonNummer );
        Student student = new Student(persoonsGegevens, dto.getVooropleiding());
        return studentRepo.save(student);
    }

    public void schrijfStudentInVoorOpleiding(Long studentId, Long opleidingId) {
        Student student = studentRepo.findById(studentId).orElse(null);
        if (student != null) {
            student.schrijfInVoorOpleiding("ICT"); // TODO opleidingId gebruiken
            studentRepo.save(student);
        }
    }

    public Student updateStudent(Long studentId, PersoonsGegevens persoonsGegevens, Vooropleiding vooropleiding) {
        Student student = studentRepo.findById(studentId).orElse(null);
        if (student != null) {
            student.setPesoonsGegevens(persoonsGegevens);
            student.setVooropleiding(vooropleiding);
            return studentRepo.save(student);
        }
        return null; // Student niet gevonden
    }



}
