package nl.hu.inno.humc.monoliet.data;

import nl.hu.inno.humc.monoliet.domain.Opleiding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpleidingRepository extends JpaRepository <Opleiding, Long> {
}
