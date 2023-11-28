package nl.hu.inno.humc.student.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentPuntenDto {
    private String VakId;
    private String StudentId;

    private int EC;

    public StudentPuntenDto(String vakId, String studentId, int EC) {
        VakId = vakId;
        StudentId = studentId;
        this.EC = EC;
    }

    public String getVakId() {
        return VakId;
    }

    public String getStudentId() {
        return StudentId;
    }

    public int getEC() {
        return EC;
    }
}
