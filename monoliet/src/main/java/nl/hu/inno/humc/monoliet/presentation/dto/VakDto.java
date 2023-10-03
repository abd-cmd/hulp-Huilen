package nl.hu.inno.humc.monoliet.presentation.dto;


import nl.hu.inno.humc.monoliet.domain.vak.HerkansingGegevens;
import nl.hu.inno.humc.monoliet.domain.vak.ToetsGegevens;

import java.time.LocalDate;

public class VakDto {
    public String naam;
    public LocalDate beginDatum;
    public LocalDate eindDatum;
    public int periode;
    public ToetsGegevens toetsGegevens;
    public HerkansingGegevens herkansingGegevens;

    public Long opleidingId;
}
