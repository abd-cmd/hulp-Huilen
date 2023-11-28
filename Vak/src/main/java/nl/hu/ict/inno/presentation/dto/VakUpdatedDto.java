package nl.hu.ict.inno.presentation.dto;

import nl.hu.ict.inno.domain.Opleiding;

import java.time.LocalDate;

public class VakUpdatedDto {
    private String id;
    private String naam;
    private LocalDate beginDatum;
    private LocalDate eindDatum;
    private int studiePunten;

    private Opleiding opleiding;
    private int beschikbarePlekken;

    public VakUpdatedDto(String id, String naam, LocalDate beginDatum,
                         LocalDate eindDatum, int studiePunten, Opleiding opleiding, int beschikbarePlekken) {
        this.id = id;
        this.naam = naam;
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;
        this.studiePunten = studiePunten;
        this.opleiding = opleiding;
        this.beschikbarePlekken = beschikbarePlekken;
    }

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

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public int getBeschikbarePlekken() {
        return beschikbarePlekken;
    }
}
