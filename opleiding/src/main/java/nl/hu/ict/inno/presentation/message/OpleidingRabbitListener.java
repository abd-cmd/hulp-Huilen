package nl.hu.ict.inno.presentation.message;

import nl.hu.ict.inno.application.OpleidingService;
import nl.hu.ict.inno.presentation.dto.VakOpleidingDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class OpleidingRabbitListener {

    private final MessageConverter messageConverter;
    private final OpleidingService opleidingService;

    public OpleidingRabbitListener(MessageConverter messageConverter, OpleidingService opleidingService) {
        this.messageConverter = messageConverter;
        this.opleidingService = opleidingService;
    }

//    @RabbitListener(queues = "Add-Vak")
//    public void voegVakListener(Message message){
//        VakOpleidingDto vakOpleidingDto = (VakOpleidingDto) messageConverter.fromMessage(message);
//        this.opleidingService.addVakToOpleiding(vakOpleidingDto.opleidingId(), vakOpleidingDto.vakId());
//    }
}
