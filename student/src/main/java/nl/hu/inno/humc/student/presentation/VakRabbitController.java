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
public class VakRabbitController {

    private final MessageConverter messageConverter;
    private final VakService vakService;

    private final RabbitTemplate rabbitTemplate;

    public VakRabbitController(MessageConverter messageConverter, VakService vakService, RabbitTemplate rabbitTemplate) {
        this.messageConverter = messageConverter;
        this.rabbitTemplate = rabbitTemplate;
        this.vakService = vakService;

    }

    @RabbitListener(queues = "Add-Vak")
    public void newVakListener(Message message){
        VakDto vakDto = (VakDto) messageConverter.fromMessage(message);
        vakService.saveNewVak(vakDto);
    }

    @RabbitListener(queues = "Update-Vak")
    public void UpdatedVakListener(Message message) throws VakBestaatNietException {
        VakDto vakDto = (VakDto) messageConverter.fromMessage(message);
        vakService.updateVak(vakDto);
    }

    @RabbitListener(queues = "Delete-Vak")
    public void DeletedVakListener(Message message){
        VakDto vakDto = (VakDto) messageConverter.fromMessage(message);
        vakService.deleteVak(vakDto);
    }

    public void sendInschrijvingToQueue(VakInschrijvingDto vakInschrijvingDto) {
        rabbitTemplate.convertAndSend("vak-inschrijving-queue", vakInschrijvingDto);
    }
}
