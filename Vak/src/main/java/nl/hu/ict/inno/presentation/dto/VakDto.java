package nl.hu.ict.inno.presentation.dto;


import nl.hu.ict.inno.domain.vakGegevens.HerkansingGegevens;
import nl.hu.ict.inno.domain.vakGegevens.IngangEisen;
import nl.hu.ict.inno.domain.vakGegevens.LoopTijd;
import nl.hu.ict.inno.domain.vakGegevens.ToetsGegevens;

public class VakDto {

    public String naam;
    public int periode;
    public int beschikbaarPleken;
    public IngangEisen ingangEisen;
    public LoopTijd loopTijd;
    public ToetsGegevens toetsGegevens;
    public HerkansingGegevens herkansingGegevens;
    public Long opleidingId;
}
