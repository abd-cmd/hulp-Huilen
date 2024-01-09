package nl.hu.inno.humc.student.presentation;

import nl.hu.inno.humc.student.presentation.dto.VakDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VakController {
    private final RestTemplate restTemplate;

    public VakController() {
        this.restTemplate = new RestTemplate();
    }

    public VakDto getVakById(String id) {
        return restTemplate.getForObject("http://localhost:8082/Vakken/getById/" + id, VakDto.class);
    }

}
