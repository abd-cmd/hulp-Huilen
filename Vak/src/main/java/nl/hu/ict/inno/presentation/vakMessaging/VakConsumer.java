package nl.hu.ict.inno.presentation.vakMessaging;

import nl.hu.ict.inno.application.VakService;
import nl.hu.ict.inno.presentation.dto.VakInschrijvingDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

@Component
public class VakConsumer {

    private VakService vakService;

    public VakConsumer(VakService vakService) {
        this.vakService = vakService;
    }

    @RabbitListener(queues={"vak-inschrijving-queue"})
    public void StudentToAdd(VakInschrijvingDto vakInschrijvingDto){
        vakService.addStudent(vakInschrijvingDto);
    }

}
