package nl.hu.inno.humc.student.presentation.dto;

public class InschrijvingDto {

    private String studentId;
    private String opleidingId;


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getOpleidingId() {
        return opleidingId;
    }

    public void setOpleidingId(String opleidingId) {
        this.opleidingId = opleidingId;
    }
}
