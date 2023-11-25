package nl.hu.ict.inno.presentation.controller.messaging;

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

    @Bean
    public Queue QueueAddStudent(){
        return QueueBuilder.durable("vak-inschrijving-queue").build();
    }

//    @Bean
//    public Binding BindingQueueAddStudent(){
//        return BindingBuilder.bind(QueueAddStudent()).to(Exchange()).with("example-key1").noargs();
//    }

    @Bean
    public Queue QueueUpdateStudent(){
        return QueueBuilder.durable("updated-student-queue").build();
    }

//    @Bean
//    public Binding BindingQueueUpdateStudent(){
//        return BindingBuilder.bind(QueueUpdateStudent()).to(Exchange()).with("example-key2").noargs();
//    }

    @Bean
    public Queue QueueRemoveStudent(){
        return QueueBuilder.durable("deleted-student-queue").build();
    }

//    @Bean
//    public Binding BindingQueueremoveStudent(){
//        return BindingBuilder.bind(QueueRemoveStudent()).to(Exchange()).with("example-key3").noargs();
//    }

    @Bean
    public Queue QueueVakMaken(){
        return QueueBuilder.durable("vak-maken-queue").build();
    }

    @Bean
    public Binding BindingQueueVakMaken(){
        return BindingBuilder.bind(QueueVakMaken()).to(Exchange()).with("Add-Vak").noargs();
    }

    @Bean
    public Queue QueueVakUpdate(){
        return QueueBuilder.durable("vak-updaten-queue").build();
    }

    @Bean
    public Binding BindingQueueVakUpdate(){
        return BindingBuilder.bind(QueueVakMaken()).to(Exchange()).with("Update-Vak").noargs();
    }

    @Bean
    public Queue QueueVakDelete(){
        return QueueBuilder.durable("vak-delete-queue").build();
    }

    @Bean
    public Binding BindingQueueVakDelete(){
        return BindingBuilder.bind(QueueVakMaken()).to(Exchange()).with("Delete-Vak").noargs();
    }

    @Bean
    public Queue QueueVakPunten(){
        return QueueBuilder.durable("vak-punten-sturen-queue").build();
    }

    @Bean
    public Binding BindingQueueVakPunten(){
        return BindingBuilder.bind(QueueVakMaken()).to(Exchange()).with("sendPuntenVak").noargs();
    }

    @Bean
    MessageConverter getConverter(){

        // Add support for LocalDate objects
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        return new Jackson2JsonMessageConverter(mapper);
    }
}
