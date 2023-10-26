package nl.hu.ict.inno.presentation.dto;


import nl.hu.ict.inno.domain.HerkansingGegevens;
import nl.hu.ict.inno.domain.IngangEisen;
import nl.hu.ict.inno.domain.LoopTijd;
import nl.hu.ict.inno.domain.ToetsGegevens;

public class VakDto {
    public String naam;
    public int periode;
    public IngangEisen ingangEisen;
    public LoopTijd loopTijd;
    public ToetsGegevens toetsGegevens;
    public HerkansingGegevens herkansingGegevens;
    public Long opleidingId;
    public Long studentId;

}
