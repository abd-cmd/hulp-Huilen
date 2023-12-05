package nl.hu.ict.inno.application.RestTemplateServices;

import nl.hu.ict.inno.data.FakeRepositories.OpleidingRepository;
import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.presentation.dto.SendVakToOpleiding;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Primary
@Component
public class OpleidingRestTemplate implements OpleidingRepository {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Opleiding AddVakToOpleiding(Vak vak,String Id) {

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Object> request = new HttpEntity<Object> (vak,headers);
        String url = "http://localhost:8085/opleidingen/"+Id+"/vak";

        SendVakToOpleiding sendVakToOpleiding =
                new SendVakToOpleiding(vak.getId(),vak.getNaam(),vak.getLoopTijd().getBeginDatum()
                                        ,vak.getLoopTijd().getEindDatum(),vak.getIngangEisen().getEC(),
                                            vak.getOpleiding(),vak.getBeschikbaarPleken());

        ResponseEntity<Opleiding> response = restTemplate.postForEntity(url, sendVakToOpleiding, Opleiding.class);

        return response.getBody();
    }

    @Override
    public void sendUpdatedVakToOpleiding(Vak vak) {
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Object> request = new HttpEntity<Object> (vak,headers);
        String url = "http://localhost:8085/opleidingen/"+vak.getOpleiding().getOpleidingId()+"/vak";
        restTemplate.put(url, vak, Opleiding.class);
    }

    @Override
    public void sendRemovedVakIdToOpleiding(Vak vak) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<Object> (vak,headers);
        String url = "http://localhost:8085/opleidingen/"+vak.getOpleiding().getOpleidingId()+"/vak";

         restTemplate.delete(url, request, Opleiding.class);
    }

    @Override
    public Opleiding findByNaam(String naam) {
        ResponseEntity<Opleiding> response = restTemplate.
                getForEntity("http://localhost:8085/opleidingen/"+naam,Opleiding.class);

        return response.getBody();
    }


    @Override
    public Opleiding findById(String id) {
        ResponseEntity<Opleiding> response = restTemplate.
                getForEntity("http://localhost:8085/opleidingen/"+id,Opleiding.class);

        return response.getBody();
    }

    @Override
    public List<Opleiding> findAll() {
        ResponseEntity<Opleiding[]> response = restTemplate.
                getForEntity("http://localhost:8085/opleidingen",Opleiding[].class);

        return List.of(response.getBody());
    }
}
