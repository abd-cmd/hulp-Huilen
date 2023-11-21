package nl.hu.inno.humc.student.presentation;

import nl.hu.inno.humc.student.application.OpleidingService;
import nl.hu.inno.humc.student.presentation.dto.OpleidingInschrijvingDto;
import nl.hu.inno.humc.student.presentation.dto.OpleidingDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;

public class OpleidingRabbitController {

    private final RabbitTemplate rabbitTemplate;
    private final MessageConverter messageConverter;
    private final OpleidingService opleidingService;

    public OpleidingRabbitController(RabbitTemplate rabbitTemplate, MessageConverter messageConverter, OpleidingService opleidingService) {
        this.rabbitTemplate = rabbitTemplate;
        this.messageConverter = messageConverter;
        this.opleidingService = opleidingService;
    }

    public void newInschrijving(OpleidingInschrijvingDto inschrijvingDto) {
        rabbitTemplate.convertAndSend("opleiding-inschrijving-queue", inschrijvingDto);
    }

    @RabbitListener(queues = "opleiding-queue")
    public void newOrUpdatedOpleidingListener(Message message){
        OpleidingDto opleidingDto = (OpleidingDto) messageConverter.fromMessage(message);
        opleidingService.verwerkOpleiding(opleidingDto);
    }
}
