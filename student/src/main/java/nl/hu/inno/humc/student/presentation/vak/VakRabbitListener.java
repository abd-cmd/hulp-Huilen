package nl.hu.inno.humc.student.presentation.vak;

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
        try {
            vakService.saveNewVak(vakDto);
            System.out.println("Vak toegevoegd");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @RabbitListener(queues = "Update-Vak")
    public void UpdatedVakListener(VakDto vakDto) throws VakBestaatNietException {
        try {
            vakService.updateVak(vakDto);
            System.out.println("Vak geupdate");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @RabbitListener(queues = "Delete-Vak")
    public void DeletedVakListener(String id) throws VakBestaatNietException {
        try{
            vakService.deleteVak(id);
            System.out.println("Vak verwijderd");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
