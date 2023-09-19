package nl.hu.inno.humc.monoliet.domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class ToetsGegevens {

    private String vorm;
    private LocalDateTime toetsDatum;
    private int toetsPunten;

    public ToetsGegevens(String vorm, LocalDateTime toetsDatum, int toetsPunten) {
        this.vorm = vorm;
        this.toetsDatum = toetsDatum;
        this.toetsPunten = toetsPunten;
    }

    public ToetsGegevens() {

    }

    public String getVorm() {
        return vorm;
    }

    public void setVorm(String toets) {
        this.vorm = vorm;
    }

    public LocalDateTime getDatum() {
        return toetsDatum;
    }

    public void setDatum(LocalDateTime toetsDatum) {
        this.toetsDatum = toetsDatum;
    }

    public int getPunten() {
        return toetsPunten;
    }

    public void setPunten(int toetsCijfer) {
        this.toetsPunten = toetsCijfer;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToetsGegevens that = (ToetsGegevens) o;
        return toetsPunten == that.toetsPunten && Objects.equals(vorm, that.vorm) && Objects.equals(toetsDatum, that.toetsDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vorm, toetsDatum, toetsPunten);
    }
}
