package nl.hu.inno.humc.student;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {
    @Bean
    public Queue helloWorldQueue(){
        return QueueBuilder.durable("helloworld-queue").build();
    }

    @Bean
    MessageConverter getConverter(){
        return new Jackson2JsonMessageConverter();
    }
}