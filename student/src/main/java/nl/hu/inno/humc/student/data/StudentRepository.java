package nl.hu.inno.humc.student.data;

import nl.hu.inno.humc.student.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
