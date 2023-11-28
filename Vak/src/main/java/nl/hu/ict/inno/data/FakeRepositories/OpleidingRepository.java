package nl.hu.ict.inno.data.FakeRepositories;

import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Vak;

import java.util.List;

public interface OpleidingRepository {

    Opleiding AddVakToOpleiding(Vak vak, String opleidingId);
    void sendRemovedVakIdToOpleiding(Vak vak);
    void sendUpdatedVakToOpleiding(Vak vak);
    Opleiding findByNaam(String naam);
    Opleiding findById(String id);
    List<Opleiding> findAll();
}
