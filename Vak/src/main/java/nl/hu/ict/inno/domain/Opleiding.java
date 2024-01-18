package nl.hu.ict.inno.domain;

import jakarta.persistence.Embeddable;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Opleiding {


    private String opleidingId;
    private String naam;

    public Opleiding() {
    }

    public Opleiding(String opleidingId, String naam) {
        this.opleidingId = opleidingId;
        this.naam = naam;
    }

    public String getOpleidingId() {
        return opleidingId;
    }

    public String getNaam() {
        return naam;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opleiding opleiding = (Opleiding) o;
        return Objects.equals(opleidingId, opleiding.opleidingId) && Objects.equals(naam, opleiding.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(opleidingId, naam);
    }
}
