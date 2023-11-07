package nl.hu.inno.humc.student.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.student.data.StudentRepository;
import nl.hu.inno.humc.student.domain.Student;
import nl.hu.inno.humc.student.domain.StudentBuilder;
import nl.hu.inno.humc.student.presentation.dto.StudentDto;
import nl.hu.inno.humc.student.presentation.exceptions.StudentBestaatNietException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepo;

    StudentService(StudentRepository studentRepository) {
        this.studentRepo = studentRepository;
    }

    public StudentDto getStudentById(String id){
        Optional<Student> student = studentRepo.findById(id);
        if (student.isEmpty()) throw new StudentBestaatNietException();
        return StudentDto.Of(student.get());
    }

    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepo.findAll();
        students.forEach((student) -> System.out.println(student.getStudentId()));
        return StudentDto.Of(students);
    }

    public StudentDto registreerStudent(StudentDto dto) {
        Student student = new StudentBuilder()
                .withNaam(dto.getVoornaam(), dto.getAchternaam(), dto.getRoepnaam())
                .withEmail(dto.getEmail())
                .withTelefoonNummer(dto.getTelefoonNummer())
                .withAdres(dto.getPlaats(), dto.getPostcode(), dto.getStraat(), dto.getHuisnummer())
                .withGeboortedatum(dto.getGeboortedatum())
                .withVooropleiding(dto.getVooropleiding())
                .build();
        student = studentRepo.save(student);
        return StudentDto.Of(student);
    }

    public StudentDto schrijfStudentInVoorOpleiding(String studentId, Long opleidingId) {
        Optional<Student> maybeStudent = studentRepo.findById(studentId);
        // TODO Opleiding opvragen uit de opleiding module/service
        // Opleiding opleiding = this.opleidingService.getOpleidingEntityById(opleidingId);
        if (maybeStudent.isPresent()) {
            Student student = maybeStudent.get();
            //student.schrijfInVoorOpleiding(opleiding);
            studentRepo.save(student);
            return StudentDto.Of(student);
        }
          throw new StudentBestaatNietException();
    }

    public StudentDto vraagVrijstellingAan(String studentId, Long vakId) {
        Optional<Student> maybeStudent = studentRepo.findById(studentId);

        // TODO Vak opvragen uit de vak module/service
        // Vak maybeVak = vakService.findById(vakId);

//        if (maybeStudent.isPresent() && maybeVak != null) {
//            Student student = maybeStudent.get();
//            student.geefStudentVrijstellingVoorVak(maybeVak);
//            return Optional.of(studentRepo.save(student));
//        }
        throw new StudentBestaatNietException();
    }
}
