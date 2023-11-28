package nl.hu.inno.humc.student.presentation.opleiding;

import nl.hu.inno.humc.student.application.OpleidingService;
import nl.hu.inno.humc.student.presentation.dto.OpleidingDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class OpleidingRabbitListener {

    private final OpleidingService opleidingService;

    public OpleidingRabbitListener(OpleidingService opleidingService) {
        this.opleidingService = opleidingService;
    }

    @RabbitListener(queues = "new-opleiding-queue")
    public void newOrUpdatedOpleidingListener(OpleidingDto opleidingDto){
        opleidingService.verwerkOpleiding(opleidingDto);
    }

}
