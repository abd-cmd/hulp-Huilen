package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.hu.ict.inno.domain.Student;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VakInschrijvingDto {

    private String vakId;
    @JsonProperty("studentDto")
    private Student student;

    public VakInschrijvingDto(String vakId, Student student) {
        this.vakId = vakId;
        this.student = student;
    }

    public VakInschrijvingDto() {
    }

    public String getVakId() {
        return vakId;
    }

    public Student getStudent() {
        return student;
    }
}
