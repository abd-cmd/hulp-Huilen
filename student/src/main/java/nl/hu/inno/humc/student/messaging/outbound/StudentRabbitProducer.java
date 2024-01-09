package nl.hu.inno.humc.student.messaging.outbound;

import nl.hu.inno.humc.student.presentation.dto.StudentDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
