package nl.hu.ict.inno.application.RestTemplateServices;

import nl.hu.ict.inno.domain.Opdracht;
import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.presentation.dto.SendVakToOpdracht;
import nl.hu.ict.inno.presentation.dto.SendVakToOpleiding;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Primary
@Component
public class OpdrachtRest implements  OpdrachtRestInterface{

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Opdracht SendVakToOpdracht(Vak vak) {

        SendVakToOpdracht sendVakToOpdracht = new SendVakToOpdracht(vak.getId());

        String url = "http://localhost:8085/opdracht/vak/";
        try {
            ResponseEntity<Opdracht> response = restTemplate.postForEntity(url, sendVakToOpdracht, Opdracht.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            // HTTP 4xx status code (client error) - The other application is reachable, but there's an issue with the request
            // Handle accordingly, e.g., log the error or throw a custom exception
            // ...
            throw new RuntimeException("Error communicating with the other application", e);
        } catch (HttpServerErrorException e) {
            // HTTP 5xx status code (server error) - The other application is reachable, but there's an issue on their side
            // Handle accordingly, e.g., log the error or throw a custom exception
            // ...
            throw new RuntimeException("Error on the other application's side", e);
        } catch (ResourceAccessException e) {
            // ResourceAccessException is thrown when the other application is not reachable
            // Handle accordingly, e.g., log the error or throw a custom exception
            // ...
            throw new RuntimeException("The other application is offline or not reachable", e);
        }
    }
}
