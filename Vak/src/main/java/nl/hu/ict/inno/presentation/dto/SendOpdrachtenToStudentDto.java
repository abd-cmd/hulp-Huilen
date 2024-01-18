package nl.hu.ict.inno.presentation.dto;

import nl.hu.ict.inno.domain.Opdracht;

import java.util.ArrayList;
import java.util.List;

public class SendOpdrachtenToStudentDto {

    private String vakId;

    private String studentId;

    private List<Opdracht> opdrachts = new ArrayList<>();

    public SendOpdrachtenToStudentDto(String vakId, String studentId, List<Opdracht> opdrachts) {
        this.vakId = vakId;
        this.studentId = studentId;
        this.opdrachts = opdrachts;
    }


}
