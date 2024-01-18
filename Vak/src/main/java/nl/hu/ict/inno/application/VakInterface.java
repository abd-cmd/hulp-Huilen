package nl.hu.ict.inno.application;

import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.presentation.dto.VakDto;

import java.util.List;

public interface VakInterface {

    public Vak AddVak(VakDto vakDto);
    public Vak findById(String id);

    public void studentHeeftPuntenBehaald(String vakid, String studentId);
    public void studentHeeftGeenPuntenBehaald(String vakid, String studentId);
    public List<Opleiding> getOpleidingen();
}
