package nl.hu.ict.inno.application;

import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Student;
import nl.hu.ict.inno.presentation.dto.VakInschrijvingDto;

import java.util.List;

public interface StudentInterface {
    public void AddStudentToRepo(VakInschrijvingDto vakInschrijvingDto);
    public Student FindStudent(String student);
    public List<Student> FindAllStudents();
}
