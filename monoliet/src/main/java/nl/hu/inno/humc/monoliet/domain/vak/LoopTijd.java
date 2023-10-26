package nl.hu.inno.humc.monoliet.domain.vak;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class LoopTijd {

    private LocalDate beginDatum;
    private LocalDate eindDatum;

    public LoopTijd(LocalDate beginDatum, LocalDate eindDatum) {
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;

        this.ValidateVakDatums(beginDatum,eindDatum);
    }

    public LoopTijd() {

    }

    public LocalDate getBeginDatum() {
        return beginDatum;
    }

    public void setBeginDatum(LocalDate beginDatum) {
        this.beginDatum = beginDatum;
    }

    public LocalDate getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(LocalDate eindDatum) {
        this.eindDatum = eindDatum;
    }

    public boolean ValidateVakDatums(LocalDate firstDatum,LocalDate secondDatum){
        if(firstDatum.isAfter(secondDatum)){
            return false;
        }else if(secondDatum.isBefore(firstDatum)){
            return false;
        }else if(firstDatum.equals(secondDatum)){
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoopTijd loopTijd = (LoopTijd) o;
        return Objects.equals(beginDatum, loopTijd.beginDatum) && Objects.equals(eindDatum, loopTijd.eindDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beginDatum, eindDatum);
    }
}
