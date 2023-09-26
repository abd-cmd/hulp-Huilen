package nl.hu.inno.humc.monoliet.domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class ToetsGegevens {

    private String vorm;
    private LocalDate toetsDatum;
    private int toetsPunten;

    public ToetsGegevens(String vorm, LocalDate toetsDatum, int toetsPunten) {
        this.vorm = vorm;
        this.toetsDatum = toetsDatum;
        this.toetsPunten = toetsPunten;

    }

    public ToetsGegevens() {

    }

    public String getVorm() {
        return vorm;
    }

    public void setVorm(String vorm) {
        this.vorm = vorm;
    }

    public LocalDate gettoetsDatum() {
        return toetsDatum;
    }

    public void settoetsDatum(LocalDate toetsDatum) {
        this.toetsDatum = toetsDatum;
    }

    public int gettoetsPunten() {
        return toetsPunten;
    }

    public void settoetsPunten(int toetsCijfer) {
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
