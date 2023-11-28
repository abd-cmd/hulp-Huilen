package nl.hu.inno.humc.student.presentation.dto;

public class VakInschrijvingDto {

    private String studentId;
    private String vakId;

    public String getVoornaam() {
        return voornaam;
    }

    private String voornaam;

    public String getVoornaam() {
        return voornaam;
    }

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

    public VakInschrijvingDto(String studentId, String vakId, String voornaam) {
        this.studentId = studentId;
        this.vakId = vakId;
        this.voornaam = voornaam;
    }

    public VakInschrijvingDto() {
    }
}

