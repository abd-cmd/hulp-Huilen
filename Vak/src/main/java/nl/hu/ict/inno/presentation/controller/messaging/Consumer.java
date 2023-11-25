package nl.hu.ict.inno.presentation.controller.messaging;

import nl.hu.ict.inno.application.VakService;
import nl.hu.ict.inno.domain.Student;
import nl.hu.ict.inno.presentation.dto.AddStudentDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private VakService vakService;

    public Consumer(VakService vakService) {
        this.vakService = vakService;
    }

    @RabbitListener(queues={"vak-inschrijving-queue"})
    public void StudentToAdd(Student student,String Vakid){

        AddStudentDto addStudentDto = new AddStudentDto(Vakid,student);

        vakService.addStudent(addStudentDto);
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
