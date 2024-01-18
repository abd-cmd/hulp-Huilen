package nl.hu.ict.inno.data;

import nl.hu.ict.inno.domain.Student;
import nl.hu.ict.inno.domain.Vak;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String> {
}
