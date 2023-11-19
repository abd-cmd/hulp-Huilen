package nl.hu.inno.humc.student;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {
    @Bean
    public Queue studentQueue(){
        return QueueBuilder.durable("student-queue").build();
    }

    @Bean
    public Queue vakQueue(){
        return QueueBuilder.durable("vak-queue").build();
    }

    @Bean
    public Queue opleidingQueue(){
        return QueueBuilder.durable("opleiding-queue").build();
    }

    @Bean
    MessageConverter getConverter(){

        // Add support for LocalDate objects
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        return new Jackson2JsonMessageConverter(mapper);
    }
}