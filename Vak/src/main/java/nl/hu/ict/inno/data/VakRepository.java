package nl.hu.ict.inno.data;


import nl.hu.ict.inno.domain.Student;
import nl.hu.ict.inno.domain.vakGegevens.ToetsGegevens;
import nl.hu.ict.inno.domain.Vak;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VakRepository extends MongoRepository<Vak,String> {

    Optional<Vak> findById(String id);
}
