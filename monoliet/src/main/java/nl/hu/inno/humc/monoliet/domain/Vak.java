package nl.hu.inno.humc.monoliet.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Vak {
    @Id
    @GeneratedValue
    private Long id;
    private String naam;
    private LocalDateTime beginDatum;
    private LocalDateTime eindDatum;
    private int periode;
    @Embedded
    private ToetsGegevens toetsGegevens;
    @Embedded
    private HerkansingGegevens herkansingGegevens;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opleidingId")
    private Opleiding opleiding;

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
    }

    public Vak() {

    }
    public Vak(String naam, LocalDateTime beginDatum, LocalDateTime eindDatum, int periode,
               ToetsGegevens toetsGegevens,
               HerkansingGegevens herkansingGegevens) {

        this.naam = naam;
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;
        this.periode = periode;
        this.toetsGegevens = toetsGegevens;
        this.herkansingGegevens = herkansingGegevens;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public LocalDateTime getBeginDatum() {
        return beginDatum;
    }

    public void setBeginDatum(LocalDateTime beginDatum) {
        this.beginDatum = beginDatum;
    }

    public LocalDateTime getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(LocalDateTime eindDatum) {
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

    public ToetsGegevens getToets() {
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

    public ToetsGegevens createToets(String vorm,LocalDateTime toetsDatum,int toetspunten){
        return new ToetsGegevens(vorm,toetsDatum,toetspunten);
    }

    public HerkansingGegevens createHerkansing(int herkansingsperiode,LocalDateTime herkansingDatum,int herkansingCijfer){
        return new HerkansingGegevens(herkansingsperiode,herkansingDatum,herkansingCijfer);
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
