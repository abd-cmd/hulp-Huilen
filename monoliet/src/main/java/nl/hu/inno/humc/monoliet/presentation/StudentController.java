package nl.hu.inno.humc.monoliet.presentation;

import nl.hu.inno.humc.monoliet.application.StudentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }
}
