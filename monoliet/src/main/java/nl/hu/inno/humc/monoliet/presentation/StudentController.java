package nl.hu.inno.humc.monoliet.presentation;

import nl.hu.inno.humc.monoliet.application.StudentService;
import nl.hu.inno.humc.monoliet.domain.student.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
        Optional<Student> student = studentService.getStudentById(studentId);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        Optional<List<Student>> students = studentService.getAllStudents();
        if (students.isPresent()) {
            return new ResponseEntity<>(students.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Student> createStudent(@RequestBody StudentDto studentDto) {
        Optional<Student> createdStudent = studentService.registreerStudent(studentDto);
        if (createdStudent.isPresent()) {
            return new ResponseEntity<>(createdStudent.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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


