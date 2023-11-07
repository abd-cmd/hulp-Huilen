package nl.hu.inno.humc.student.presentation;

import nl.hu.inno.humc.student.application.StudentService;
import nl.hu.inno.humc.student.domain.Student;
import nl.hu.inno.humc.student.presentation.dto.InschrijvingDto;
import nl.hu.inno.humc.student.presentation.dto.StudentDto;
import nl.hu.inno.humc.student.presentation.dto.VrijstellingDto;
import nl.hu.inno.humc.student.presentation.exceptions.StudentBestaatNietException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<StudentDto> getStudent(@PathVariable String studentId) {
        try {
            StudentDto student = studentService.getStudentById(studentId);
            return new ResponseEntity<>(student, HttpStatus.OK);

        } catch (StudentBestaatNietException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        try {
            StudentDto createdStudent = studentService.registreerStudent(studentDto);
            return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/opleiding")
    public ResponseEntity<StudentDto> schrijfInVoorOpleiding(@RequestBody @Validated InschrijvingDto dto){
        try {


            StudentDto student = studentService.schrijfStudentInVoorOpleiding(dto.getStudentId(), dto.getOpleidingId());

            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (StudentBestaatNietException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/vrijstelling")
    public ResponseEntity<StudentDto> vraagVrijstellingAan(@RequestBody @Validated VrijstellingDto dto){
        try {
            StudentDto student = studentService.vraagVrijstellingAan(dto.getStudentId(), dto.getVakId());
            return new ResponseEntity<>(student, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}


