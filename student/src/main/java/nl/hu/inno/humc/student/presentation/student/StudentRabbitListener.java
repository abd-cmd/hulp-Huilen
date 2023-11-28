package nl.hu.inno.humc.student.presentation.student;

import nl.hu.inno.humc.student.application.StudentService;
import nl.hu.inno.humc.student.application.exceptions.VakBestaatNietException;
import nl.hu.inno.humc.student.presentation.dto.VakBehaaldDto;
import nl.hu.inno.humc.student.presentation.dto.VakInschrijvingDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;

public class StudentRabbitListener {

    private final MessageConverter messageConverter;
    private final StudentService studentService;

    public StudentRabbitListener(MessageConverter messageConverter, StudentService studentService) {
        this.messageConverter = messageConverter;
        this.studentService = studentService;
    }

    @RabbitListener(queues = "sendPuntenVak")
    public void behaaldeStudiepuntenListener(VakBehaaldDto vakBehaaldDto) throws VakBestaatNietException {
        System.out.println("hello");
        this.studentService.studentHeeftVakBehaald(vakBehaaldDto.getStudentId(), vakBehaaldDto.getVakId());
    }
}
