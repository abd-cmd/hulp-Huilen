package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentPuntenDto {
    public String VakId;
    public String StudentId;

    public StudentPuntenDto(String vakId, String studentId) {
        VakId = vakId;
        StudentId = studentId;
    }

    public StudentPuntenDto() {
    }

    public String getVakId() {
        return VakId;
    }

    public String getStudentId() {
        return StudentId;
    }

}
