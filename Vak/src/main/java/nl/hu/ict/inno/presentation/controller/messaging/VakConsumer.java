package nl.hu.ict.inno.presentation.controller.messaging;

import nl.hu.ict.inno.application.VakService;
import nl.hu.ict.inno.presentation.dto.StudentDto;
import nl.hu.ict.inno.presentation.dto.VakInschrijvingDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

@Component
public class VakConsumer {

    private VakService vakService;

    public VakConsumer(VakService vakService) {
        this.vakService = vakService;
    }

    @RabbitListener(queues={"vak-inschrijving-queue"})
    public void StudentToAdd(VakInschrijvingDto vakInschrijvingDto){
        System.out.println("vak inschrijving");
        System.out.println(vakInschrijvingDto.getStudentId());
        System.out.println(vakInschrijvingDto.getVoornaam());
        vakService.addStudent(vakInschrijvingDto);
    }
    @RabbitListener(queues={"updated-student-queue"})
    public void StudentToUpdate(StudentDto studentDto){
//        vakService.updateStudent(studentId,naam,id);
    }
    @RabbitListener(queues={"deleted-student-queue"})
    public void StudentToRemove(StudentDto studentDto){
//        vakService.removeStudent(studentId,id);
    }
}
