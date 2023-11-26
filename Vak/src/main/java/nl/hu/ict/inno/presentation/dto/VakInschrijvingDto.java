package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VakInschrijvingDto {

    private String vakId;
    @JsonProperty("studentDto")
    private StudentDto studentDto;


    public VakInschrijvingDto(StudentDto studentDto,String vakId) {
        this.vakId = vakId;
        this.studentDto = studentDto;
    }


    public VakInschrijvingDto() {
    }

    public String getVakId() {
        return vakId;
    }

    public StudentDto getStudentDto() {
        return studentDto;
    }
}
