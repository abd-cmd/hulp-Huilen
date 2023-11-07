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
    public Opleiding AddVakToOpleiding(Long id, Vak vak) {
        return null;
    }

    @Override
    public Opleiding findById(Long id) {
        return null;
    }

    @Override
    public List<Opleiding> findAll() {
        return this.fakeData;
    }
}
