package nl.hu.inno.humc.student.presentation;

import nl.hu.inno.humc.student.application.StudentService;
import nl.hu.inno.humc.student.application.exceptions.VakBestaatNietException;
import nl.hu.inno.humc.student.presentation.dto.StudentDto;
import nl.hu.inno.humc.student.presentation.dto.VakInschrijvingDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class StudentRabbitProducer {

    private final RabbitTemplate rabbitTemplate;

    public StudentRabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNewStudentToQueue(StudentDto student) {
        rabbitTemplate.convertAndSend("new-student-queue", student);
    }

    public void sendUpdatedStudentToQueue(StudentDto student) {
        rabbitTemplate.convertAndSend("updated-student-queue", student);
    }

    public void sendDeletedStudentToQueue(StudentDto student) {
        rabbitTemplate.convertAndSend("deleted-student-queue", student);
    }


}
