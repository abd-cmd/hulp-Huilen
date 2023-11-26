package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDto {

    private String studentId;
    private String voornaam;

    public StudentDto(String studentId, String voornaam) {
        this.studentId = studentId;
        this.voornaam = voornaam;
    }

    public StudentDto() {
    }

    public String getId() {
        return studentId;
    }

    public String getNaam() {
        return voornaam;
    }
}
