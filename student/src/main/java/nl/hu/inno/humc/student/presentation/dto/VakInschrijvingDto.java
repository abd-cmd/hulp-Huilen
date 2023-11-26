package nl.hu.inno.humc.student.presentation.dto;

public class VakInschrijvingDto {

    private String studentId;
    private String vakId;
    private StudentDto studentDto;
    
    public String getStudentId() {
        return studentId;
    }

    public String getVakId() {
        return vakId;
    }

    public StudentDto getStudentDto() {
        return studentDto;
    }

    public VakInschrijvingDto(String studentId, String vakId) {
        this.studentId = studentId;
        this.vakId = vakId;
    }

    public VakInschrijvingDto(StudentDto studentDto, String vakId) {
        this.studentDto = studentDto;
        this.vakId = vakId;
    }

    public VakInschrijvingDto() {
    }
}

