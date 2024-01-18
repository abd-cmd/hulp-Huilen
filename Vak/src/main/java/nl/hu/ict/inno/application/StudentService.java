package nl.hu.ict.inno.application;

import jakarta.transaction.Transactional;
import nl.hu.ict.inno.data.StudentRepository;
import nl.hu.ict.inno.data.VakRepository;
import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Student;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.domain.exceptions.StudentNotFoundException;
import nl.hu.ict.inno.domain.exceptions.VakNotFoundException;
import nl.hu.ict.inno.presentation.controller.VakController;
import nl.hu.ict.inno.presentation.dto.VakInschrijvingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentService implements StudentInterface{

    private StudentRepository studentRepository;
    private VakRepository vakRepository;

    public StudentService(StudentRepository studentRepository, VakRepository vakRepository) {
        this.studentRepository = studentRepository;
        this.vakRepository = vakRepository;
    }

    @Override
    public void AddStudentToRepo(VakInschrijvingDto vakInschrijvingDto) {
        Vak vak = this.vakRepository.findById(vakInschrijvingDto.getVakId()).orElseThrow(() -> new VakNotFoundException());

        Student student = new Student(vakInschrijvingDto.getStudentId(),
                vakInschrijvingDto.getVoornaam(),vakInschrijvingDto.getAchternaam());

        if (vak != null) {
            vak.AddStudent(student);
            studentRepository.save(student);
            vakRepository.save(vak);
        }
    }

    @Override
    public Student FindStudent(String id) {
        Student FindStudent = this.studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException(id));

        return FindStudent;
    }

    @Override
    public List<Student> FindAllStudents() {
        return null;
    }
}
