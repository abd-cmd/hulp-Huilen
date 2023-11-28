package nl.hu.ict.inno;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue newOpleidingQueue(){
        return QueueBuilder.durable("new-opleiding-queue").build();
    }

    @Bean
    public Queue updatedOpleidingQueue(){
        return QueueBuilder.durable("updated-opleiding-queue").build();
    }

    @Bean
    public Queue deletedOpleidingQueue(){
        return QueueBuilder.durable("deleted-opleiding-queue").build();
    }
    @Bean
    public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}