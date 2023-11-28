package nl.hu.inno.humc.student.presentation.vak;

import nl.hu.inno.humc.student.presentation.dto.VakDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VakRestController {
    private final RestTemplate restTemplate;

    public VakRestController() {
        this.restTemplate = new RestTemplate();
    }

    public VakDto getVakById(String id) {
        return restTemplate.getForObject("http://localhost:8082/Vakken/getById/" + id, VakDto.class);
    }

}
