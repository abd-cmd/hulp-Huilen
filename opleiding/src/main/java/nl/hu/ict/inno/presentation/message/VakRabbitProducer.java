package nl.hu.ict.inno.presentation.message;

import nl.hu.ict.inno.presentation.dto.VakDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class VakRabbitProducer {
    private final RabbitTemplate rabbitTemplate;

    public VakRabbitProducer( RabbitTemplate rabbitTemplate) {

        this.rabbitTemplate = rabbitTemplate;

    }

    public void sendAddVakToQueue(VakDto vakDto) {
    }

}
