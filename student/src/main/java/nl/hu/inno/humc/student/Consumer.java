package nl.hu.inno.humc.student;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "student-hallo-queue")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

    @RabbitListener(queues = "vak-hallo-queue")
    public void receiveMessageFromVak(String message) {
        System.out.println("Received <" + message + ">");
    }
}
