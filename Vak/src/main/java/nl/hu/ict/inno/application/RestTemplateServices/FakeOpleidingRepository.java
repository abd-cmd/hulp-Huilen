package nl.hu.ict.inno.application.RestTemplateServices;

import nl.hu.ict.inno.data.FakeRepositories.OpleidingRepository;
import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Vak;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class FakeOpleidingRepository implements OpleidingRepository {

   private List<Opleiding> fakeData =  new ArrayList<>();
    public FakeOpleidingRepository(){
        this.fakeData.add(new Opleiding(42l, "ICT"));
    }
    @Override
    public Opleiding AddVakToOpleiding(Vak id, String vak) {
        return null;
    }

    @Override
    public void sendRemovedVakIdToOpleiding(Vak vak) {

    }

    @Override
    public void sendUpdatedVakToOpleiding(Vak vak) {

    }

    @Override
    public Opleiding findByNaam(String naam) {
        return null;
    }

    @Override
    public Opleiding findById(String id) {
        return null;
    }

    @Override
    public List<Opleiding> findAll() {
        return this.fakeData;
    }
}
