package nl.hu.inno.humc.student.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VakBehaaldDto {
    private String studentId;

    private String vakId;

    public String getStudentId() {
        return studentId;
    }

    public String getVakId() {
        return vakId;
    }
}
