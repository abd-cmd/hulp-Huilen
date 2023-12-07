

package nl.hu.ict.inno.presentation.message;

import nl.hu.ict.inno.application.VakService;
import nl.hu.ict.inno.presentation.dto.VakDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
        // Jan - dit even uitgezet omdat de method niet bestaat en voor build errors zorgt
        // vakService.saveNewVak(vakDto);
    }

}
