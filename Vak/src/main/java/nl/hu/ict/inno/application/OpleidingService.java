package nl.hu.ict.inno.application;

import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Vak;

import java.util.List;

public class OpleidingService implements OpleidingInterface{

    @Override
    public Opleiding AddVakToOpleiding(Vak vak, String Id) {
        return null;
    }

    @Override
    public void AddOpleidingToRepo(Opleiding opleiding) {

    }

    @Override
    public Opleiding FindOpleiding(Opleiding opleiding) {
        return null;
    }

    @Override
    public Opleiding findOpleidingByNaam(String id) {
        return null;
    }

    @Override
    public List<Opleiding> FindAllOpleidingen() {
        return null;
    }
}
