package nl.hu.ict.inno;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class Producer {

    private RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(SharedMessage message) {
        //TODO maak en stuur een bericht naar de queue
        rabbitTemplate.convertAndSend("vak","example-key",message);
        //In dit geval willen we juist de exchange gebruiken, dus zorg dat je niet de queue-naam gebruikt.
    }

    public void sendMessageToStudent(String message) {
        //TODO maak en stuur een bericht naar de queue
        rabbitTemplate.convertAndSend("student-hallo-queue",message);
        //In dit geval willen we juist de exchange gebruiken, dus zorg dat je niet de queue-naam gebruikt.
    }

}











































//    private RabbitTemplate rabbitTemplate;
//
//    @Value("${rabbitmq.exchange.name}")
//    private String exchange;
//
//    @Value("${rabbitmq.routing.key}")
//    private String routingKey;
//
////    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Producer.class);
//
//    public Producer(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    public void sendMessage(String message) {
////        LOGGER.info(String.format("Message sent -> %",message));
//        rabbitTemplate.convertAndSend(exchange,routingKey,message);
//    }