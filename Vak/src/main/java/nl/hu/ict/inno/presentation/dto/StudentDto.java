package nl.hu.ict.inno.presentation.dto;

public class StudentDto {

    private String studentId;
    private String voornaam;

    public StudentDto(String studentId, String voornaam) {
        this.studentId = studentId;
        this.voornaam = voornaam;
    }

    public String getId() {
        return studentId;
    }

    public String getNaam() {
        return voornaam;
    }
}
