package nl.hu.inno.humc.student.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.student.data.StudentRepository;
import nl.hu.inno.humc.student.domain.Student;
import nl.hu.inno.humc.student.domain.StudentBuilder;
import nl.hu.inno.humc.student.presentation.dto.StudentDto;
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

    public Optional<Student> getStudentById(Long id){
        return studentRepo.findById(id);
    }

    public Optional<List<Student>> getAllStudents(){
        return Optional.of(studentRepo.findAll());
    }

    public Optional<Student> registreerStudent(StudentDto dto) {
        Student student = new StudentBuilder()
                .withNaam(dto.getVoornaam(), dto.getAchternaam(), dto.getRoepnaam())
                .withEmail(dto.getEmail())
                .withTelefoonNummer(dto.getTelefoonNummer())
                .withAdres(dto.getPlaats(), dto.getPostcode(), dto.getStraat(), dto.getHuisnummer())
                .withGeboortedatum(dto.getGeboortedatum())
                .withVooropleiding(dto.getVooropleiding())
                .build();
        return Optional.of(studentRepo.save(student));
    }

    public Optional<Student> schrijfStudentInVoorOpleiding(Long studentId, Long opleidingId) {
        Optional<Student> maybeStudent = studentRepo.findById(studentId);
        // TODO Opleiding opvragen uit de opleiding module/service
        // Opleiding opleiding = this.opleidingService.getOpleidingEntityById(opleidingId);
        if (maybeStudent.isPresent()) {
            Student student = maybeStudent.get();
            //student.schrijfInVoorOpleiding(opleiding);
            return Optional.of(studentRepo.save(student));
        }
        return Optional.empty();
    }

    public Optional<Student> vraagVrijstellingAan(Long studentId, Long vakId) {
        Optional<Student> maybeStudent = studentRepo.findById(studentId);

        // TODO Vak opvragen uit de vak module/service
        // Vak maybeVak = vakService.findById(vakId);

//        if (maybeStudent.isPresent() && maybeVak != null) {
//            Student student = maybeStudent.get();
//            student.geefStudentVrijstellingVoorVak(maybeVak);
//            return Optional.of(studentRepo.save(student));
//        }
        return Optional.empty();
    }
}
