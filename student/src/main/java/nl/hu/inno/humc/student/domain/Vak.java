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

    private Opleiding opleiding;
    private int beschikbarePlekken;

    public Vak(
            String id, // Hier word ID meegegeven omdat deze word verkregen vanuit een andere service
            String naam,
            LocalDate beginDatum,
            LocalDate eindDatum,
            int studiePunten,
            Opleiding opleiding,
            int beschikbarePlekken
    ) {
        this.id = id;
        this.naam = naam;
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;
        this.studiePunten = studiePunten;
        this.opleiding = opleiding;
        this.beschikbarePlekken = beschikbarePlekken;
    }


    public Opleiding getOpleiding() {
        return opleiding;
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

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
    }

    public void setBeschikbarePlekken(int beschikbarePlekken) {
        this.beschikbarePlekken = beschikbarePlekken;
    }
}
