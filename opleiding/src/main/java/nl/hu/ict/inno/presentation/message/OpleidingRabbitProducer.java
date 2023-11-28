package nl.hu.ict.inno.presentation.message;

import nl.hu.ict.inno.presentation.dto.OpleidingDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class OpleidingRabbitProducer {

    private final RabbitTemplate rabbitTemplate;

    public OpleidingRabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNewOpleidingToQueue(OpleidingDto opleiding) {
        rabbitTemplate.convertAndSend("new-opleiding-queue", opleiding);
    }

    public void sendUpdatedOpleidingToQueue(OpleidingDto opleiding) {
        rabbitTemplate.convertAndSend("updated-opleiding-queue", opleiding);
    }

    public void sendDeletedOpleidingToQueue(OpleidingDto opleiding) {
        rabbitTemplate.convertAndSend("deleted-opleiding-queue", opleiding);
    }
}