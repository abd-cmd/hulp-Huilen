package nl.hu.ict.inno.application.RestTemplateServices;

import nl.hu.ict.inno.data.FakeRepositories.OpleidingRepository;
import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Vak;
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
    public Opleiding AddVakToOpleiding(Vak vak,String OpeleidingId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<Object> (vak,headers);
        String url = "http://localhost:8080/opleidingen/"+OpeleidingId+"/vak";

        ResponseEntity<Opleiding> response = restTemplate.postForEntity(url, request, Opleiding.class);

        return response.getBody();
    }

    @Override
    public void sendUpdatedVakToOpleiding(Vak vak) {
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Object> request = new HttpEntity<Object> (vak,headers);
        String url = "http://localhost:8080/opleidingen/"+vak.getOpleiding().getOpleidingId()+"/vak";
        restTemplate.put(url, vak, Opleiding.class);
    }

    @Override
    public void sendRemovedVakIdToOpleiding(Vak vak) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<Object> (vak,headers);
        String url = "http://localhost:8080/opleidingen/"+vak.getOpleiding().getOpleidingId()+"/vak";

         restTemplate.delete(url, request, Opleiding.class);
    }

    @Override
    public Opleiding findByNaam(String naam) {
        ResponseEntity<Opleiding> response = restTemplate.
                getForEntity("http://localhost:8080/opleidingen/"+naam,Opleiding.class);

        return response.getBody();
    }


    @Override
    public Opleiding findById(String id) {
        ResponseEntity<Opleiding> response = restTemplate.
                getForEntity("http://localhost:8080/opleidingen/"+id,Opleiding.class);

        return response.getBody();
    }

    @Override
    public List<Opleiding> findAll() {
        ResponseEntity<Opleiding[]> response = restTemplate.
                getForEntity("http://localhost:8080/opleidingen",Opleiding[].class);

        return List.of(response.getBody());
    }
}
