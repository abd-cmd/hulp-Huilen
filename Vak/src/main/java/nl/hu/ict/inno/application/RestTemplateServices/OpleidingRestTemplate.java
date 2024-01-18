package nl.hu.ict.inno.application.RestTemplateServices;

import nl.hu.ict.inno.application.OpleidingInterface;
import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.presentation.dto.SendVakToOpleiding;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Primary
@Component
public class OpleidingRestTemplate implements OpleidingInterface {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Opleiding AddVakToOpleiding(Vak vak, String Id) {
        String url = "http://localhost:8085/opleidingen/"+Id+"/vak";

        SendVakToOpleiding sendVakToOpleiding =
                new SendVakToOpleiding(vak.getId(),vak.getNaam(),vak.getLoopTijd().getBeginDatum()
                                        ,vak.getLoopTijd().getEindDatum(),vak.getIngangEisen().getEC(),
                                            vak.getOpleiding(),vak.getBeschikbaarPleken());

        ResponseEntity<Opleiding> response = restTemplate.postForEntity(url, sendVakToOpleiding, Opleiding.class);

        return response.getBody();
    }

    public Opleiding findById(String id) {
        ResponseEntity<Opleiding> response = restTemplate.
                getForEntity("http://localhost:8085/opleidingen/"+id,Opleiding.class);

        return response.getBody();
    }

    public List<Opleiding> findAll() {
        ResponseEntity<Opleiding[]> response = restTemplate.
                getForEntity("http://localhost:8085/opleidingen",Opleiding[].class);

        return List.of(response.getBody());
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
