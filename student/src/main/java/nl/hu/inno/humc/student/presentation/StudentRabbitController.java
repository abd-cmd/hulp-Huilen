package nl.hu.inno.humc.student.presentation;

import nl.hu.inno.humc.student.presentation.dto.StudentDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentRabbitController {

    private final RabbitTemplate rabbitTemplate;

    public StudentRabbitController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendStudentToQueue(StudentDto student) {
        rabbitTemplate.convertAndSend("student-queue", student);
    }

}
