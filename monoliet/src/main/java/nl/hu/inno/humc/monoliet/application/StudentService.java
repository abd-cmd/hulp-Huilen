package nl.hu.inno.humc.monoliet.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.monoliet.data.StudentRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepo;

    StudentService(StudentRepository studentRepository) {
        this.studentRepo = studentRepository;
    }
}
