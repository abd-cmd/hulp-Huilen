package nl.hu.inno.humc.monoliet.presentation.dto;


import nl.hu.inno.humc.monoliet.domain.HerkansingGegevens;
import nl.hu.inno.humc.monoliet.domain.ToetsGegevens;

public class VakDto {
    public String naam;
    public String beginDatum;
    public String eindDatum;
    public int periode;
    public ToetsGegevens toetsGegevens;
    public HerkansingGegevens herkansingGegevens;
}
