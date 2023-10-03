package nl.hu.inno.humc.monoliet.data;

import nl.hu.inno.humc.monoliet.domain.vak.ToetsGegevens;
import nl.hu.inno.humc.monoliet.domain.vak.Vak;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VakRepository extends JpaRepository<Vak,Long> {
    Optional<Vak> findById(Long id);

    List<Vak> findVakByToetsGegevens( ToetsGegevens toetsGegevens);
    List<Vak> findVakByToetsGegevens_Vorm( String vorm);

    List<Vak> findVakByOpleiding_OpleidingId(Long id);

    Vak findByNaam(String naam);
    List<Vak> findByPeriode(int periode);
}
