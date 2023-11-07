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
    public Opleiding AddVakToOpleiding(Long id,Vak vak) {

        Object data = new Object();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<Object> (vak,headers);
        String url = "http://localhost:8080/opleidingen/"+id+"/vak";

        ResponseEntity<Opleiding> response = restTemplate.postForEntity(url, request, Opleiding.class);


        return response.getBody();
    }

    @Override
    public Opleiding findById(Long id) {
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
