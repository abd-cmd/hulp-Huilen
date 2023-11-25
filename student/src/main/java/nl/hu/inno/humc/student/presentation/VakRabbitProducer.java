package nl.hu.inno.humc.student.presentation;

import nl.hu.inno.humc.student.application.VakService;
import nl.hu.inno.humc.student.application.exceptions.VakBestaatNietException;
import nl.hu.inno.humc.student.presentation.dto.VakDto;
import nl.hu.inno.humc.student.presentation.dto.VakInschrijvingDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
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
