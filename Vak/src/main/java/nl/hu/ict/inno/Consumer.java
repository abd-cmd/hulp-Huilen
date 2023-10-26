package nl.hu.ict.inno;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues={"vak-hallo-queue"})
    public void acceptBla(SharedMessage msg){
        System.out.println(msg);
    }
}
