package nl.hu.ict.inno.data;

import nl.hu.ict.inno.domain.Vak;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VakRepository extends CrudRepository<Vak, String>  {
    Optional<Vak> findById(String s);
}
