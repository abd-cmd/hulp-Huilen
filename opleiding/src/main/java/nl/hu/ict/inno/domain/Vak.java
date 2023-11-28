package nl.hu.ict.inno.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class Vak {
    @Id
    private String id;
    private String naam;
    private LocalDate beginDatum;
    private LocalDate eindDatum;
    private int studiePunten;

    private Opleiding opleiding;
    private int beschikbarePlekken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
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

    public int getStudiePunten() {
        return studiePunten;
    }

    public void setStudiePunten(int studiePunten) {
        this.studiePunten = studiePunten;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
    }

    public int getBeschikbarePlekken() {
        return beschikbarePlekken;
    }

    public void setBeschikbarePlekken(int beschikbarePlekken) {
        this.beschikbarePlekken = beschikbarePlekken;
    }
}
