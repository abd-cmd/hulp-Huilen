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
        return QueueBuilder.durable("add-student-queue").build();
    }

    @Bean
    public Binding BindingQueueAddStudent(){
        return BindingBuilder.bind(QueueAddStudent()).to(Exchange()).with("example-key1").noargs();
    }

    @Bean
    public Queue QueueUpdateStudent(){
        return QueueBuilder.durable("update-student-queue").build();
    }

    @Bean
    public Binding BindingQueueUpdateStudent(){
        return BindingBuilder.bind(QueueUpdateStudent()).to(Exchange()).with("example-key2").noargs();
    }

    @Bean
    public Queue QueueRemoveStudent(){
        return QueueBuilder.durable("remove-student-queue").build();
    }

    @Bean
    public Binding BindingQueueremoveStudent(){
        return BindingBuilder.bind(QueueRemoveStudent()).to(Exchange()).with("example-key3").noargs();
    }

    @Bean
    public Queue QueueVakMaken(){
        return QueueBuilder.durable("vak-maken").build();
    }

    @Bean
    public Binding BindingQueueVakMaken(){
        return BindingBuilder.bind(QueueVakMaken()).to(Exchange()).with("example-key4").noargs();
    }

    @Bean
    public Queue QueueVakUpdate(){
        return QueueBuilder.durable("vak-updaten").build();
    }

    @Bean
    public Binding BindingQueueVakUpdate(){
        return BindingBuilder.bind(QueueVakMaken()).to(Exchange()).with("example-key5").noargs();
    }

    @Bean
    public Queue QueueVakDelete(){
        return QueueBuilder.durable("vak-delete").build();
    }

    @Bean
    public Binding BindingQueueVakDelete(){
        return BindingBuilder.bind(QueueVakMaken()).to(Exchange()).with("example-key6").noargs();
    }

    @Bean
    public Queue QueueVakPunten(){
        return QueueBuilder.durable("vak-punten-sturen").build();
    }

    @Bean
    public Binding BindingQueueVakPunten(){
        return BindingBuilder.bind(QueueVakMaken()).to(Exchange()).with("example-key7").noargs();
    }

    @Bean
    MessageConverter getConverter(){

        // Add support for LocalDate objects
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        return new Jackson2JsonMessageConverter(mapper);
    }
}
