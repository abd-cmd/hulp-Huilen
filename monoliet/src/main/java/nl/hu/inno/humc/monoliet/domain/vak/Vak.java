package nl.hu.inno.humc.monoliet.domain.vak;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import nl.hu.inno.humc.monoliet.domain.opleiding.Opleiding;


import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Vak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naam;
    private LocalDate beginDatum;
    private LocalDate eindDatum;
    private int periode;
    @Embedded
    private ToetsGegevens toetsGegevens;
    @Embedded
    private HerkansingGegevens herkansingGegevens;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opleidingId")
    @JsonIgnore
    private Opleiding opleiding;

    public Vak() {

    }
    public Vak(String naam, LocalDate beginDatum, LocalDate eindDatum, int periode,
               ToetsGegevens toetsGegevens,
               HerkansingGegevens herkansingGegevens,
               Opleiding opleiding) {

        this.naam = naam;
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;
        this.periode = periode;
        this.toetsGegevens = toetsGegevens;
        this.herkansingGegevens = herkansingGegevens;
        this.opleiding = opleiding;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
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

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public ToetsGegevens getToetsGegevens() {
        return toetsGegevens;
    }
    public void setToetsGegevens(ToetsGegevens toetsGegevens) {
        this.toetsGegevens = toetsGegevens;
    }
    public HerkansingGegevens getHerkansingGegevens() {
        return herkansingGegevens;
    }

    public void setHerkansingGegevens(HerkansingGegevens herkansingGegevens) {
        this.herkansingGegevens = herkansingGegevens;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vak vak = (Vak) o;
        return periode == vak.periode && Objects.equals(naam, vak.naam) &&
                Objects.equals(beginDatum, vak.beginDatum) &&
                Objects.equals(eindDatum, vak.eindDatum) &&
                Objects.equals(toetsGegevens, vak.toetsGegevens) &&
                Objects.equals(herkansingGegevens, vak.herkansingGegevens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, beginDatum, eindDatum, periode, toetsGegevens, herkansingGegevens);
    }
}
