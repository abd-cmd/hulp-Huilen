package nl.hu.ict.inno.data.FakeRepositories;

import nl.hu.ict.inno.domain.Student;
import nl.hu.ict.inno.domain.Vak;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentFakeRepository {

    List<Vak> AddStudentToVak(Student student);
    Student findById(Long id);
    List<Student> findAll();
}
