package nl.hu.inno.humc.student.messaging.inbound;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.inno.humc.student.application.StudentService;
import nl.hu.inno.humc.student.application.exceptions.VakBestaatNietException;
import nl.hu.inno.humc.student.presentation.dto.StudentFromJjanDto;
import nl.hu.inno.humc.student.presentation.dto.VakBehaaldDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.Console;

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

    @RabbitListener(queues = "studentRegistratie")
    public void studentGeregistreerdListener(String studentMessage) throws JsonProcessingException {

        StudentFromJjanDto student = new ObjectMapper().readValue(
                studentMessage,
                StudentFromJjanDto.class);

        System.out.println(student.getStudentNummer());
    }
}
