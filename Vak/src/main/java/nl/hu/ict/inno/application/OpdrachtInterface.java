package nl.hu.ict.inno.application;

import nl.hu.ict.inno.domain.Opdracht;
import nl.hu.ict.inno.presentation.dto.ReciveOpdrachtDto;
import nl.hu.ict.inno.presentation.dto.SendOpdrachtenToStudentDto;

import java.util.List;

public interface OpdrachtInterface {
    public  void AddOpdrachtToHerkansing(ReciveOpdrachtDto reciveOpdrachtDto);

}
