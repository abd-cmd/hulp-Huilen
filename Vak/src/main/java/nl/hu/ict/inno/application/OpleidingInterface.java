package nl.hu.ict.inno.application;

import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Vak;

import java.util.List;

public interface OpleidingInterface {
    Opleiding AddVakToOpleiding(Vak vak, String Id);

    public void AddOpleidingToRepo(Opleiding opleiding);
    public Opleiding FindOpleiding(Opleiding opleiding);

    public Opleiding findOpleidingByNaam(String id);
    public List<Opleiding> FindAllOpleidingen();
}
