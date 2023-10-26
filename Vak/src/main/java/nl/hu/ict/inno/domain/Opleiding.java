package nl.hu.ict.inno.domain;

import java.util.Objects;

public class Opleiding {

    private Long id;
    private String naam;

    public Opleiding() {
    }

    public Opleiding(Long id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opleiding opleiding = (Opleiding) o;
        return Objects.equals(id, opleiding.id) && Objects.equals(naam, opleiding.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naam);
    }
}
