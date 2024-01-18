package nl.hu.inno.humc.student.messaging.inbound;

import nl.hu.inno.humc.student.application.OpleidingService;
import nl.hu.inno.humc.student.presentation.dto.OpleidingDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OpleidingRabbitListener {

    private final OpleidingService opleidingService;
    public OpleidingRabbitListener(OpleidingService opleidingService) {
        this.opleidingService = opleidingService;
    }

    @RabbitListener(queues = "new-opleiding-queue")
    public void newOrUpdatedOpleidingListener(OpleidingDto opleidingDto) {
        try {
            opleidingService.verwerkOpleiding(opleidingDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
