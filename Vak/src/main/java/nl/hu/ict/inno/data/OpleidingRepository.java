package nl.hu.ict.inno.data;

import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Vak;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OpleidingRepository extends MongoRepository<Opleiding,String> {

}
