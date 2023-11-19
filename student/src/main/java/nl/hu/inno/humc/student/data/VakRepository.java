package nl.hu.inno.humc.student.data;

import nl.hu.inno.humc.student.domain.Student;
import nl.hu.inno.humc.student.domain.Vak;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VakRepository extends MongoRepository<Vak, String> {
}
