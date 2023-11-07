package nl.hu.inno.humc.student.data;

import nl.hu.inno.humc.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
