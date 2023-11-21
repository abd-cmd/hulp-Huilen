package nl.hu.inno.humc.student.presentation.dto;

import java.time.LocalDate;

public class VakDto {
    private String id;
    private String naam;
    private LocalDate beginDatum;
    private LocalDate eindDatum;
    private int studiePunten;

    private OpleidingDto opleiding;
    private int beschikbarePlekken;



    public String getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public LocalDate getBeginDatum() {
        return beginDatum;
    }

    public LocalDate getEindDatum() {
        return eindDatum;
    }

    public int getStudiePunten() {
        return studiePunten;
    }

    public OpleidingDto getOpleidingDto() {
        return opleiding;
    }

    public int getBeschikbarePlekken() {
        return beschikbarePlekken;
    }
}
