package nl.hu.inno.humc.monoliet.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Opleiding {

    @Id
    @GeneratedValue
    private Long opleidingId;

//    todo beheren van vakken
//    @OneToMany(mappedBy = "opleiding", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Vak> vakken;
    private String naam;
    private String beschrijving;
    private Type type;
    private Long punten;
    private String locatie;
    private String taal;
    private LocalDate startDatum;
    private LocalDate eindDatum;

    protected Opleiding() {}

    public Opleiding(Long opleidingId, String naam, String beschrijving, Type type, Long punten, String locatie, String taal, LocalDate startDatum, LocalDate eindDatum) {
        this.opleidingId = opleidingId;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.type = type;
        this.punten = punten;
        this.locatie = locatie;
        this.taal = taal;
        this.startDatum = startDatum;
        this.eindDatum = eindDatum;
    }

    public Long getOpleidingId() {
        return opleidingId;
    }

    public void setOpleidingId(Long opleidingId) {
        this.opleidingId = opleidingId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getPunten() {
        return punten;
    }

    public void setPunten(Long punten) {
        this.punten = punten;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getTaal() {
        return taal;
    }

    public void setTaal(String taal) {
        this.taal = taal;
    }

    public LocalDate getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(LocalDate startDatum) {
        this.startDatum = startDatum;
    }

    public LocalDate getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(LocalDate eindDatum) {
        this.eindDatum = eindDatum;
    }
}
