package nl.hu.ict.inno;

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
    public Queue Queue(){
        return QueueBuilder.durable("vak-hallo-queue").build();
    }

    @Bean
    public Binding Binding(){
        return BindingBuilder.bind(Queue()).to(Exchange()).with("example-key").noargs();
    }

    @Bean
    MessageConverter getConverter(){
        return new Jackson2JsonMessageConverter();
    }
}































//
//    @Value("${rabbitmq.qeueu.name}")
//    private String qeueu;
//
//    @Value("${rabbitmq.exchange.name}")
//    private String exchange;
//
//    @Value("${rabbitmq.routing.key}")
//    private String routingKey;
//
//    @Bean
//    public Queue queue(){
//        return new Queue(qeueu);
//    }
//
//    @Bean
//    public TopicExchange exchange(){
//        return new TopicExchange(exchange);
//    }
//
//    @Bean
//    public Binding binding(){
//        return BindingBuilder
//                .bind(queue())
//                .to(exchange())
//                .with(routingKey);
//    }