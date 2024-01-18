package nl.hu.ict.inno.domain.vakGegevens;

import jakarta.persistence.Embeddable;
import nl.hu.ict.inno.domain.Opdracht;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HerkansingGegevens {

    private int herkansingsperiode;
    private LocalDate herkansingDatum;
    private int herkansingPunten;

    private List<Opdracht> opdrachtList = new ArrayList<>();

    public HerkansingGegevens(int herkansingsperiode, LocalDate herkansingDatum, int herkansingPunten,
                              List<Opdracht> opdrachtList) {
        this.herkansingsperiode = herkansingsperiode;
        this.herkansingDatum = herkansingDatum;
        this.herkansingPunten = herkansingPunten;
        this.opdrachtList = opdrachtList;
    }

    public List<Opdracht> getOpdrachtList() {
        return opdrachtList;
    }

    public void AddOpdrachtToHerkansingList(Opdracht opdracht) {
        opdrachtList.add(opdracht);
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
