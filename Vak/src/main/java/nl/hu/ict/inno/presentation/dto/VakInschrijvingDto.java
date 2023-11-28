package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VakInschrijvingDto {

    private String vakId;

    private String studentId;

    private String voornaam;


    public VakInschrijvingDto(String studentId, String vakId,String voornaam) {
        this.vakId = vakId;
        this.studentId = studentId;
        this.voornaam = voornaam;

    }


    public VakInschrijvingDto() {
    }

    public String getVakId() {
        return vakId;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getStudentId() {
        return studentId;
    }
}
