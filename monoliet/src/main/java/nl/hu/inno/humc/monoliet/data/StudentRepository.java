package nl.hu.inno.humc.monoliet.data;

import nl.hu.inno.humc.monoliet.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
