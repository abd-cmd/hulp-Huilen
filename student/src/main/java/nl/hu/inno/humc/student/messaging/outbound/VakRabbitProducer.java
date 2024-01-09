package nl.hu.inno.humc.student.messaging.outbound;

import nl.hu.inno.humc.student.presentation.dto.VakInschrijvingDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class VakRabbitProducer {

    private final RabbitTemplate rabbitTemplate;

    public VakRabbitProducer( RabbitTemplate rabbitTemplate) {

        this.rabbitTemplate = rabbitTemplate;

    }

    public void sendInschrijvingToQueue(VakInschrijvingDto vakInschrijvingDto) {
        rabbitTemplate.convertAndSend("vak-inschrijving-queue", vakInschrijvingDto);
    }
}
