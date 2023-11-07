package nl.hu.inno.humc.student.domain;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document
public class Vak {
    @Id
    private Long id;
    private String naam;
    private LocalDate beginDatum;
    private LocalDate eindDatum;
    private int studiePunten;

    private Opleiding opleiding;

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public int getStudiePunten() {
        return studiePunten;
    }
}
