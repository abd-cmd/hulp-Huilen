package nl.hu.inno.humc.student.presentation.student;

import nl.hu.inno.humc.student.application.StudentService;
import nl.hu.inno.humc.student.application.exceptions.VakBestaatNietException;
import nl.hu.inno.humc.student.presentation.dto.VakBehaaldDto;
import nl.hu.inno.humc.student.presentation.dto.VakInschrijvingDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class StudentRabbitListener {


    private final StudentService studentService;

    public StudentRabbitListener(StudentService studentService) {

        this.studentService = studentService;
    }

    @RabbitListener(queues = "sendPuntenVak")
    public void behaaldeStudiepuntenListener(VakBehaaldDto vakBehaaldDto) throws VakBestaatNietException {
        try {
            this.studentService.studentHeeftVakBehaald(vakBehaaldDto.getStudentId(), vakBehaaldDto.getVakId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
