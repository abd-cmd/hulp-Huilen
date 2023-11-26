package nl.hu.ict.inno.presentation.controller.messaging;

import nl.hu.ict.inno.application.VakService;
import nl.hu.ict.inno.presentation.dto.VakInschrijvingDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private VakService vakService;

    public Consumer(VakService vakService) {
        this.vakService = vakService;
    }

    @RabbitListener(queues={"vak-inschrijving-queue"})
    public void StudentToAdd(VakInschrijvingDto vakInschrijvingDto){
        vakService.addStudent(vakInschrijvingDto);
    }
    @RabbitListener(queues={"updated-student-queue"})
    public void StudentToUpdate(String studentId,String naam , String id){
        vakService.updateStudent(studentId,naam,id);
    }
    @RabbitListener(queues={"deleted-student-queue"})
    public void StudentToRemove(String studentId,String id){
        vakService.removeStudent(studentId,id);
    }
}
