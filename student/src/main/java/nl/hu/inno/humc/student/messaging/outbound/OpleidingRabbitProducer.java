package nl.hu.inno.humc.student.messaging.outbound;

import nl.hu.inno.humc.student.presentation.dto.OpleidingInschrijvingDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class OpleidingRabbitProducer implements OpleidingProducer{

    private final RabbitTemplate rabbitTemplate;

    public OpleidingRabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void newInschrijving(OpleidingInschrijvingDto inschrijvingDto) {
        rabbitTemplate.convertAndSend("opleiding-inschrijving-queue", inschrijvingDto);
    }
}
