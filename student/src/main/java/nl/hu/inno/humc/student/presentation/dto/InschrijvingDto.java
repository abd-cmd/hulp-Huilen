package nl.hu.inno.humc.student.presentation.dto;

public class InschrijvingDto {

    private Long studentId;
    private Long opleidingId;


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getOpleidingId() {
        return opleidingId;
    }

    public void setOpleidingId(Long opleidingId) {
        this.opleidingId = opleidingId;
    }
}
