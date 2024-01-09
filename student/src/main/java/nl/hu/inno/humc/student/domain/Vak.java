package nl.hu.inno.humc.student.domain;

import jakarta.persistence.*;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Vak {
    @MongoId
    private String id;
    private String naam;
    private LocalDate beginDatum;
    private LocalDate eindDatum;
    private int studiePunten;

    private String opleidingId;
    private int beschikbarePlekken;

    public Vak(
            String id, // Hier word ID meegegeven omdat deze word verkregen vanuit een andere service
            String naam,
            LocalDate beginDatum,
            LocalDate eindDatum,
            int studiePunten,
            String opleidingId,
            int beschikbarePlekken
    ) {
        this.id = id;
        this.naam = naam;
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;
        this.studiePunten = studiePunten;
        this.opleidingId = opleidingId;
        this.beschikbarePlekken = beschikbarePlekken;
    }


    public String getOpleiding() {
        return opleidingId;
    }

    public int getStudiePunten() {
        return studiePunten;
    }

    public String getId() {
        return this.id;
    }

    public int getBeschikbarePlekken() {
        return beschikbarePlekken;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeginDatum(LocalDate beginDatum) {
        this.beginDatum = beginDatum;
    }

    public void setEindDatum(LocalDate eindDatum) {
        this.eindDatum = eindDatum;
    }

    public void setStudiePunten(int studiePunten) {
        this.studiePunten = studiePunten;
    }

    public void setOpleiding(String opleidingId) {
        this.opleidingId = opleidingId;
    }

    public void setBeschikbarePlekken(int beschikbarePlekken) {
        this.beschikbarePlekken = beschikbarePlekken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vak vak = (Vak) o;
        return studiePunten == vak.studiePunten && beschikbarePlekken == vak.beschikbarePlekken && Objects.equals(id, vak.id) && Objects.equals(naam, vak.naam) && Objects.equals(beginDatum, vak.beginDatum) && Objects.equals(eindDatum, vak.eindDatum) && Objects.equals(opleidingId, vak.opleidingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naam, beginDatum, eindDatum, studiePunten, opleidingId, beschikbarePlekken);
    }
}
