package nl.hu.inno.humc.student.presentation;

import nl.hu.inno.humc.student.application.VakService;
import nl.hu.inno.humc.student.presentation.dto.VakDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class VakController {

    private final MessageConverter messageConverter;
    private final VakService vakService;

    public VakController(MessageConverter messageConverter, VakService vakService) {
        this.messageConverter = messageConverter;
        this.vakService = vakService;
    }

    @RabbitListener(queues = "vak-queue")
    public void newOrUpdatedVakListener(Message message){
        VakDto vakDto = (VakDto) messageConverter.fromMessage(message);
        vakService.verwerkVak(vakDto);
    }
}
