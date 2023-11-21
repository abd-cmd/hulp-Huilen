package nl.hu.ict.inno.presentation.dto;

public class StudentPuntenDto {
    private String VakId;
    private String StudentId;
    private int Punten;

    public StudentPuntenDto(String vakId, String studentId, int punten) {
        VakId = vakId;
        StudentId = studentId;
        Punten = punten;
    }

    public String getVakId() {
        return VakId;
    }

    public String getStudentId() {
        return StudentId;
    }

    public int getPunten() {
        return Punten;
    }
}
