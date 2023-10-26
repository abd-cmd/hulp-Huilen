package nl.hu.ict.inno.application.RestTemplateServices;

import nl.hu.ict.inno.data.FakeRepositories.OpleidingFakeRepository;
import nl.hu.ict.inno.domain.Opleiding;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Component
public class OpleidingRestTemplate implements OpleidingFakeRepository {

    private RestTemplate restTemplate = new RestTemplate();
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
