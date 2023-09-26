package nl.hu.inno.humc.monoliet.domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class HerkansingGegevens {

    private int herkansingsperiode;
    private LocalDate herkansingDatum;
    private int herkansingPunten;

    public HerkansingGegevens(int herkansingsperiode, LocalDate herkansingDatum, int herkansingPunten) {
        this.herkansingsperiode = herkansingsperiode;
        this.herkansingDatum = herkansingDatum;
        this.herkansingPunten = herkansingPunten;
    }

    public HerkansingGegevens() {

    }
    public LocalDate getherkansingDatum() {
        return herkansingDatum;
    }

    public void setherkansingDatum(LocalDate herkansingDatum) {
        this.herkansingDatum = herkansingDatum;
    }

    public int getherkansingPunten() {
        return herkansingPunten;
    }

    public void setherkansingPunten(int herkansingPunten) {
        this.herkansingPunten = herkansingPunten;
    }

    public int getherkansingsperiode() {
        return herkansingsperiode;
    }
    public void setherkansingsperiode(int herkansingsperiode) {
        this.herkansingsperiode = herkansingsperiode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HerkansingGegevens that = (HerkansingGegevens) o;
        return herkansingsperiode == that.herkansingsperiode && herkansingPunten == that.herkansingPunten &&
                Objects.equals(herkansingDatum, that.herkansingDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(herkansingsperiode, herkansingDatum, herkansingPunten);
    }
}
