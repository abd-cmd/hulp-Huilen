package nl.hu.inno.humc.student.presentation;

import nl.hu.inno.humc.student.application.OpleidingService;
import nl.hu.inno.humc.student.presentation.dto.OpleidingInschrijvingDto;
import nl.hu.inno.humc.student.presentation.dto.OpleidingDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class OpleidingRabbitController {

    private final MessageConverter messageConverter;
    private final OpleidingService opleidingService;

    public OpleidingRabbitController(MessageConverter messageConverter, OpleidingService opleidingService) {
        this.messageConverter = messageConverter;
        this.opleidingService = opleidingService;
    }

    @RabbitListener(queues = "opleiding-queue")
    public void newOrUpdatedOpleidingListener(Message message){
        OpleidingDto opleidingDto = (OpleidingDto) messageConverter.fromMessage(message);
        opleidingService.verwerkOpleiding(opleidingDto);
    }

}
