package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VakInschrijvingDto {

    private String vakId;

    public String getStudentId() {
        return studentId;
    }

    private String studentId;

    public String getVoornaam() {
        return voornaam;
    }

    private String voornaam;


    public VakInschrijvingDto(String vakId, String studentId, String voornaam) {
        this.vakId = vakId;
        this.studentId = studentId;
        this.voornaam = voornaam;

    }


    public VakInschrijvingDto() {
    }

    public String getVakId() {
        return vakId;
    }

}
