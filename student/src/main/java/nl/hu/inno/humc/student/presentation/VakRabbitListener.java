package nl.hu.inno.humc.student.presentation;

import nl.hu.inno.humc.student.application.VakService;
import nl.hu.inno.humc.student.application.exceptions.VakBestaatNietException;
import nl.hu.inno.humc.student.domain.Vak;
import nl.hu.inno.humc.student.presentation.dto.VakDto;
import nl.hu.inno.humc.student.presentation.dto.VakInschrijvingDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class VakRabbitListener {

    private final MessageConverter messageConverter;
    private final VakService vakService;

    public VakRabbitListener(MessageConverter messageConverter, VakService vakService) {
        this.messageConverter = messageConverter;
        this.vakService = vakService;

    }

    @RabbitListener(queues = "Add-Vak")
    public void newVakListener(VakDto vakDto){

        vakService.saveNewVak(vakDto);
        System.out.println("Vak toegevoegd");
    }

    @RabbitListener(queues = "Update-Vak")
    public void UpdatedVakListener(VakDto vakDto) throws VakBestaatNietException {
        vakService.updateVak(vakDto);
        System.out.println("Vak geupdate");
    }

    @RabbitListener(queues = "Delete-Vak")
    public void DeletedVakListener(VakDto vakDto) throws VakBestaatNietException {
        vakService.deleteVak(vakDto);
        System.out.println("Vak verwijderd");
    }
}
