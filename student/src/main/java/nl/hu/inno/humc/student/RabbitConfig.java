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
        return QueueBuilder.durable("new-student-queue").build();
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