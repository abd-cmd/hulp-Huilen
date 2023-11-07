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

    private static List<Vak> alleVakken = new ArrayList<>();

    public Vak(
            String naam,
            LocalDate beginDatum,
            LocalDate eindDatum,
            int studiePunten,
            Opleiding opleiding
    ) {
        this.naam = naam;
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;
        this.studiePunten = studiePunten;
        this.opleiding = opleiding;

        alleVakken.add(this);
    }


    public Opleiding getOpleiding() {
        return opleiding;
    }

    public int getStudiePunten() {
        return studiePunten;
    }

    public static List<Vak> getAlleVakken() {
        return alleVakken;
    }
}
