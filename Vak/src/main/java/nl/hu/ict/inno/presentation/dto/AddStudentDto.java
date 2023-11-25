package nl.hu.ict.inno.presentation.dto;

import nl.hu.ict.inno.domain.Student;

public class AddStudentDto {

    private String vakId;
    private Student student;

    public AddStudentDto(String vakId, Student student) {
        this.vakId = vakId;
        this.student = student;
    }

    public String getVakId() {
        return vakId;
    }

    public Student getStudent() {
        return student;
    }
}
