package nl.hu.inno.humc.student.domain;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Document
public class Opleiding {

    @MongoId
    private String opleidingId;
    private String naam;
    private LocalDate startDatum;
    private LocalDate eindDatum;

    private static List<Opleiding> alleOpleidingen = new ArrayList<>();
    public Opleiding() {
    }

    public Opleiding(String naam, LocalDate startDatum, LocalDate eindDatum) {
        this.naam = naam;
        this.startDatum = startDatum;
        this.eindDatum = eindDatum;

        alleOpleidingen.add(this);
    }


    public String getOpleidingId() {
        return opleidingId;
    }

    public void setOpleidingId(String opleidingId) {
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

    public static List<Opleiding> getAlleOpleidingen() {
        return alleOpleidingen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opleiding opleiding = (Opleiding) o;
        return Objects.equals(opleidingId, opleiding.opleidingId) && Objects.equals(naam, opleiding.naam) && Objects.equals(startDatum, opleiding.startDatum) && Objects.equals(eindDatum, opleiding.eindDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(opleidingId, naam, startDatum, eindDatum);
    }
}
