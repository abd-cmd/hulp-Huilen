package nl.hu.inno.humc.student.presentation.dto;

public class VakInschrijvingDto {

    private String studentId;
    private String vakId;
    
    public String getStudentId() {
        return studentId;
    }

    public String getVakId() {
        return vakId;
    }

    public VakInschrijvingDto(String studentId, String vakId) {
        this.studentId = studentId;
        this.vakId = vakId;
    }
}

