package nl.hu.inno.humc.student.presentation.dto;

public class InschrijvingDto {

    private String studentId;
    private Long opleidingId;


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Long getOpleidingId() {
        return opleidingId;
    }

    public void setOpleidingId(Long opleidingId) {
        this.opleidingId = opleidingId;
    }
}
