package nl.hu.inno.humc.monoliet.domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class HerkansingGegevens {

    private int herkansingsperiode;
    private LocalDateTime herkansingDatum;
    private int herkansingCijfer;

    public HerkansingGegevens(int herkansingsperiode, LocalDateTime herkansingDatum, int herkansingCijfer) {
        this.herkansingsperiode = herkansingsperiode;
        this.herkansingDatum = herkansingDatum;
        this.herkansingCijfer = herkansingCijfer;
    }

    public HerkansingGegevens() {

    }
    public LocalDateTime getDatum() {
        return herkansingDatum;
    }

    public void setDatum(LocalDateTime herkansingDatum) {
        this.herkansingDatum = herkansingDatum;
    }

    public int getCijfer() {
        return herkansingCijfer;
    }

    public void setCijfer(int herkansingCijfer) {
        this.herkansingCijfer = herkansingCijfer;
    }

    public int getperiode() {
        return herkansingsperiode;
    }
    public void setperiode(int herkansingsperiode) {
        this.herkansingsperiode = herkansingsperiode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HerkansingGegevens that = (HerkansingGegevens) o;
        return herkansingsperiode == that.herkansingsperiode && herkansingCijfer == that.herkansingCijfer &&
                Objects.equals(herkansingDatum, that.herkansingDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(herkansingsperiode, herkansingDatum, herkansingCijfer);
    }
}
