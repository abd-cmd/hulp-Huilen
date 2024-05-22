package nl.hu.ict.inno.data;

import nl.hu.ict.inno.domain.Opdracht;
import nl.hu.ict.inno.domain.Vak;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OpdrachtRepository extends MongoRepository<Opdracht,String> {
    List<Opdracht> findAllByVakId(String VakId);
}
//test