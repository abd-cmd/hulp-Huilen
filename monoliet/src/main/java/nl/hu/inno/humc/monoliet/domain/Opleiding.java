package nl.hu.inno.humc.monoliet.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Opleiding {

    @Id
    @GeneratedValue
    private Long opleidingId;

    @OneToMany(mappedBy = "opleiding", cascade = CascadeType.ALL)
    private List<Vak> vakken;
    private String naam;
    private LocalDate startDatum;
    private LocalDate eindDatum;

    @OneToOne
    private OpleidingDetails opleidingDetails;

    public Opleiding(Long opleidingId, List<Vak> vakken, String naam, LocalDate startDatum, LocalDate eindDatum, OpleidingDetails opleidingDetails) {
        this.opleidingId = opleidingId;
        this.vakken = vakken;
        this.naam = naam;
        this.startDatum = startDatum;
        this.eindDatum = eindDatum;
        this.opleidingDetails = opleidingDetails;
    }

    public OpleidingDetails getOpleidingDetails() {
        return opleidingDetails;
    }

    public void setOpleidingDetails(OpleidingDetails opleidingDetails) {
        this.opleidingDetails = opleidingDetails;
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

    public List<Vak> getVakken() {
        return vakken;
    }

    public void setVakken(List<Vak> vakken) {
        this.vakken = vakken;
    }

    public void addVak(Vak vak) {
        vakken.add(vak);
        vak.setOpleiding(this);
    }

    public void removeVak(Vak vak) {
        vakken.remove(vak);
        vak.setOpleiding(null);
    }
}
