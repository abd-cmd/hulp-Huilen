package nl.hu.inno.humc.student.domain;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Opleiding {

    @Id
    @GeneratedValue
    private Long opleidingId;
    private String naam;
    private LocalDate startDatum;
    private LocalDate eindDatum;
    public Opleiding() {
    }

    public Opleiding(Long opleidingId, String naam, LocalDate startDatum, LocalDate eindDatum) {
        this.opleidingId = opleidingId;
        this.naam = naam;
        this.startDatum = startDatum;
        this.eindDatum = eindDatum;
    }


    public Long getOpleidingId() {
        return opleidingId;
    }

    public void setOpleidingId(Long opleidingId) {
        this.opleidingId = opleidingId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public LocalDate getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(LocalDate startDatum) {
        this.startDatum = startDatum;
    }

    public LocalDate getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(LocalDate eindDatum) {
        this.eindDatum = eindDatum;
    }

}
