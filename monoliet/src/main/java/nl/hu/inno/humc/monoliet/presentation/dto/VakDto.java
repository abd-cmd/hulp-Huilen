package nl.hu.inno.humc.monoliet.presentation.dto;


import nl.hu.inno.humc.monoliet.domain.vak.HerkansingGegevens;
import nl.hu.inno.humc.monoliet.domain.vak.IngangEisen;
import nl.hu.inno.humc.monoliet.domain.vak.LoopTijd;
import nl.hu.inno.humc.monoliet.domain.vak.ToetsGegevens;

import java.security.PublicKey;
import java.time.LocalDate;

public class VakDto {
    public String naam;
    public int periode;
    public IngangEisen ingangEisen;
    public LoopTijd loopTijd;
    public ToetsGegevens toetsGegevens;
    public HerkansingGegevens herkansingGegevens;
    public Long opleidingId;
}
