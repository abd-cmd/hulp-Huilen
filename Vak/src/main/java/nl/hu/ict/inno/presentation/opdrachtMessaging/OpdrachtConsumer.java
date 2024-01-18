package nl.hu.ict.inno.presentation.opdrachtMessaging;

import nl.hu.ict.inno.application.OpdrachtInterface;
import nl.hu.ict.inno.application.VakService;
import nl.hu.ict.inno.presentation.dto.ReciveOpdrachtDto;
import nl.hu.ict.inno.presentation.dto.VakInschrijvingDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OpdrachtConsumer {

    private OpdrachtInterface opdrachtInterface;

    public OpdrachtConsumer(OpdrachtInterface opdrachtInterface) {
        this.opdrachtInterface = opdrachtInterface;
    }

    @RabbitListener(queues={"recive-opdracht-queue"})
    public void OpdrachtToAdd(ReciveOpdrachtDto reciveOpdrachtDto){
        opdrachtInterface.AddOpdrachtToHerkansing(reciveOpdrachtDto);
    }

}
