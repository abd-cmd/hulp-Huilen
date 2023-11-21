package nl.hu.ict.inno.presentation.dto;

public class StudentPuntenDto {
    private String VakId;
    private String StudentId;

    public StudentPuntenDto(String vakId, String studentId) {
        VakId = vakId;
        StudentId = studentId;
    }

    public String getVakId() {
        return VakId;
    }

    public String getStudentId() {
        return StudentId;
    }
}
