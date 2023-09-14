package nl.hu.inno.humc.monoliet.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.monoliet.data.StudentRepository;
import nl.hu.inno.humc.monoliet.domain.Student;
import nl.hu.inno.humc.monoliet.domain.Vooropleiding;
import nl.hu.inno.humc.monoliet.domain.persoonsgegevens.PersoonsGegevens;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepo;

    StudentService(StudentRepository studentRepository) {
        this.studentRepo = studentRepository;
    }

    public Student registreerStudent(PersoonsGegevens persoonsGegevens, Vooropleiding vooropleiding) {
        Student student = new Student(persoonsGegevens, vooropleiding);
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
