package nl.hu.inno.humc.student;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {

    // Student queues
    @Bean
    public Queue newStudentQueue(){
        return QueueBuilder.durable("new-student-queue").build();
    }

    @Bean
    public Queue updatedStudentQueue(){
        return QueueBuilder.durable("updated-student-queue").build();
    }

    @Bean
    public Queue deletedStudentQueue(){
        return QueueBuilder.durable("deleted-student-queue").build();
    }


    // Vak queues
    @Bean
    public Queue newVakQueue(){
        return QueueBuilder.durable("Add-Vak").build();
    }

    @Bean
    public Queue updatedVakQueue(){
        return QueueBuilder.durable("Update-Vak").build();
    }

    @Bean
    public Queue deletedVakQueue(){
        return QueueBuilder.durable("Delete-Vak").build();
    }

    @Bean
    public Queue behaaldeStudiepuntenQueue(){
        return QueueBuilder.durable("sendPuntenVak").build();
    }


    // opleiding queues
    @Bean
    public Queue opleidingQueue(){
        return QueueBuilder.durable("new-opleiding-queue").build();
    }


    // Queues from jjan
    @Bean
    public Exchange jjanExchange() {
        return ExchangeBuilder.directExchange("jjan").build();
    }

    @Bean
    public Queue studentRegistratieQueue() {
        return QueueBuilder.durable("studentRegistratie").build();
    }
    @Bean
    public Binding studentRegistratieBinding() {
        return BindingBuilder.bind(studentRegistratieQueue()).to(jjanExchange()).with("studentGeregistreerd").noargs();
    }

    @Bean
    public Queue klasInschrijvingQueue() {
        return QueueBuilder.durable("klasInschrijving").build();
    }

    @Bean
    public Binding klasInschrijvingBinding() {
        return BindingBuilder.bind(klasInschrijvingQueue()).to(jjanExchange()).with("studentToegevoegdAanKlas").noargs();
    }



    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Voeg ondersteuning toe voor Java 8 datatypes zoals LocalDate

        return objectMapper;
    }
    @Bean
    MessageConverter getConverter(ObjectMapper mapper){
        return new Jackson2JsonMessageConverter(mapper);
    }
}