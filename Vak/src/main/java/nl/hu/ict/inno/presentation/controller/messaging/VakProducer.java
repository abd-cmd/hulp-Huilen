package nl.hu.ict.inno.presentation.controller.messaging;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.presentation.dto.StudentPuntenDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class VakProducer {

    private RabbitTemplate rabbitTemplate;

    public VakProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNieuweVak(Vak vak) {
        rabbitTemplate.convertAndSend("Add-Vak",vak);
    }
    public void sendUpdatedVak(Vak vak) {
        rabbitTemplate.convertAndSend("Update-Vak",vak);
    }
    public void sendDeletedVakId(String id) {
        rabbitTemplate.convertAndSend("Delete-Vak",id);
    }
    public void sendPuntenVanVak(String vakid,String studentId ,int EC) {

        StudentPuntenDto studentPuntenDto = new StudentPuntenDto(vakid,studentId,EC);

        rabbitTemplate.convertAndSend("sendPuntenVak",studentPuntenDto);
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