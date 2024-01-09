package nl.hu.inno.humc.student.application;

import nl.hu.inno.humc.student.presentation.dto.NaamDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StudentRestClient implements StudentClient{

    private final RestTemplate restTemplate;

    public StudentRestClient() {
        this.restTemplate = new RestTemplate();
    }

    public void registreerStudent(String voornaam, String achternaam) {
        restTemplate.postForEntity("http://localhost:8090/student", new NaamDto(voornaam, achternaam), NaamDto.class);
    }
}
