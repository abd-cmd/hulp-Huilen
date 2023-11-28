package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentUpdateDto {

    private String studentId;
    private String voornaam;

    private String vakId;

    public StudentUpdateDto(String studentId, String voornaam, String vakId) {
        this.studentId = studentId;
        this.voornaam = voornaam;
        this.vakId = vakId;
    }

    public StudentUpdateDto() {
    }

    public String getStudentId() {
        return studentId;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getVakId() {
        return vakId;
    }
}
