package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentRemoveDto {

    private String studentId;
    private String vakId;

    public StudentRemoveDto(String studentId, String vakId) {
        this.studentId = studentId;
        this.vakId = vakId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getVakId() {
        return vakId;
    }
}
