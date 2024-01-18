package nl.hu.ict.inno.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Exchange Exchange(){
        return ExchangeBuilder.directExchange("vak").build();
    }
////
    @Bean
    public Queue QueueAddStudent(){
        return QueueBuilder.durable("vak-inschrijving-queue").build();
    }
/////
    @Bean
    public Queue QueueVakSturen(){
        return QueueBuilder.durable("vak-maken-queue").build();
    }

    @Bean
    public Binding BindingQueueVakMaken(){
        return BindingBuilder.bind(QueueVakSturen()).to(Exchange()).with("Add-Vak").noargs();
    }

    @Bean
    public Queue QueueVakPunten(){
        return QueueBuilder.durable("sendPuntenVak").build();
    }

    @Bean
    public Queue QueueVakOpdrachten(){
        return QueueBuilder.durable("sendOpdrachtenVak").build();
    }

//////

    @Bean
    public Queue SendVakToCursus(){
        return QueueBuilder.durable("send-Vak-Cursus").build();
    }

    @Bean
    public Binding BindingQueueCursus() {
        return BindingBuilder.bind(SendVakToCursus()).to(Exchange()).with("Cursus-Vak").noargs();
    }

///////
    @Bean
    public Queue SendVakToOpdracht(){
        return QueueBuilder.durable("send-Vak-queue").build();
    }

    @Bean
    public Queue reciveOpdracht(){
        return QueueBuilder.durable("recive-opdracht-queue").build();
    }

    @Bean
    public Binding BindingQueueOpdracht() {
        return BindingBuilder.bind(SendVakToOpdracht()).to(Exchange()).with("Opdracht-Vak").noargs();
    }

    @Bean
    MessageConverter getConverter(){

        // Add support for LocalDate objects
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        return new Jackson2JsonMessageConverter(mapper);
    }
}
