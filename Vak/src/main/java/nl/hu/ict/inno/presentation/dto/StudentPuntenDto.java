package nl.hu.ict.inno.presentation.dto;

public class StudentPuntenDto {
    private String VakId;
    private String StudentId;
    private int EC;

    public StudentPuntenDto(String vakId, String studentId, int EC) {
        VakId = vakId;
        StudentId = studentId;
        this.EC = EC;
    }

    public String getVakId() {
        return VakId;
    }

    public String getStudentId() {
        return StudentId;
    }

    public int getEC() {
        return EC;
    }
}
