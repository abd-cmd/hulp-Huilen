package nl.hu.ict.inno.data;


import nl.hu.ict.inno.domain.ToetsGegevens;
import nl.hu.ict.inno.domain.Vak;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VakRepository extends JpaRepository<Vak,Long> {
    Optional<Vak> findById(Long id);

    List<Vak> findVakByToetsGegevens( ToetsGegevens toetsGegevens);
    List<Vak> findVakByToetsGegevens_Vorm( String vorm);

    Vak findByNaam(String naam);
    List<Vak> findByPeriode(int periode);
}
