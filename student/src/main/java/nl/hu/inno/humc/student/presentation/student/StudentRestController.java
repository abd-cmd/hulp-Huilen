package nl.hu.inno.humc.student.presentation.student;

import nl.hu.inno.humc.student.application.StudentService;
import nl.hu.inno.humc.student.presentation.dto.OpleidingInschrijvingDto;
import nl.hu.inno.humc.student.presentation.dto.StudentDto;
import nl.hu.inno.humc.student.presentation.dto.VakInschrijvingDto;
import nl.hu.inno.humc.student.presentation.dto.VakBehaaldDto;
import nl.hu.inno.humc.student.presentation.exceptions.StudentBestaatNietException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    private final StudentService studentService;

    StudentRestController(StudentService studentService){
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
    public ResponseEntity<StudentDto> schrijfInVoorOpleiding(@RequestBody @Validated OpleidingInschrijvingDto dto){
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

    @PatchMapping("/vak")
    public ResponseEntity<StudentDto> schrijfInVoorVak(@RequestBody @Validated VakInschrijvingDto dto){
        try {
            StudentDto student = studentService.schrijfStudentInVoorVak(dto);

            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (StudentBestaatNietException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/vrijstelling")
    public ResponseEntity<StudentDto> vakIsBehaald(@RequestBody @Validated VakBehaaldDto dto){
        try {
            StudentDto student = studentService.studentHeeftVakBehaald(dto.getStudentId(), dto.getVakId());
            return new ResponseEntity<>(student, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}


