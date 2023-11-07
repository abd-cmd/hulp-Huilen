package nl.hu.ict.inno.data.FakeRepositories;

import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Vak;

import java.util.List;

public interface OpleidingRepository {

    Opleiding AddVakToOpleiding(Long id, Vak vak);
    Opleiding findById(Long id);
    List<Opleiding> findAll();
}
