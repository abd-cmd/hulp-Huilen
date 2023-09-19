package nl.hu.inno.humc.monoliet.presentation;

import nl.hu.inno.humc.monoliet.application.StudentService;
import nl.hu.inno.humc.monoliet.domain.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

//    @GetMapping("/{studentId}")
//    public ResponseEntity<StudentDto> getStudent(@PathVariable Long studentId) {
//        StudentDto studentDto = studentService.getStudentById(studentId);
//        if (studentDto != null) {
//            return new ResponseEntity<>(studentDto, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping
    public @ResponseBody ResponseEntity<Student> createStudent(@RequestBody StudentDto studentDto) {
        Student createdStudent = studentService.registreerStudent(studentDto);
        if (createdStudent != null) {
            return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @PutMapping("/{studentId}")
//    public ResponseEntity<Void> updateStudent(@PathVariable Long studentId, @RequestBody StudentDto studentDto) {
//        boolean updated = studentService.updateStudent(studentId, studentDto);
//        if (updated) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}


