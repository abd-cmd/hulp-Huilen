package nl.hu.inno.humc.student.data;

import nl.hu.inno.humc.student.domain.Opleiding;
import nl.hu.inno.humc.student.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OpleidingRepository extends MongoRepository<Opleiding, String>{

}
