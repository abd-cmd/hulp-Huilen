package nl.hu.inno.humc.student;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendHelloWorld() {

        rabbitTemplate.convertAndSend("helloworld-queue", "Hello World!");
    }
}