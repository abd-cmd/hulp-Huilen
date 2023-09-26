package nl.hu.inno.humc.monoliet.domain.student;

import jakarta.persistence.*;
import nl.hu.inno.humc.monoliet.domain.Opleiding;
import nl.hu.inno.humc.monoliet.domain.Vak;
import nl.hu.inno.humc.monoliet.domain.student.persoonsgegevens.PersoonsGegevens;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long studentId;

    @Embedded
    private PersoonsGegevens persoonsGegevens;

    @Enumerated(EnumType.STRING)
    private Vooropleiding vooropleiding;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private BSA studieAdvies;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Opleiding opleiding;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Vak> vrijstellingen;

    protected Student(){}

    public Student(PersoonsGegevens persoonsGegevens, Vooropleiding vooropleiding){
        if(persoonsGegevens == null || vooropleiding == null){
            throw new IllegalArgumentException("Persoonsgegevens en vooropleiding mogen niet leeg zijn");
        }
        this.persoonsGegevens = persoonsGegevens;
        this.vooropleiding = vooropleiding;
        this.vrijstellingen = new ArrayList<>();
    }

    public void schrijfInVoorOpleiding(Opleiding opleiding){

        if(isStudentToegestaan()){
            if(this.studieAdvies == null){
                this.studieAdvies = new BSA(30, opleiding.getStartDatum());
            }
            this.opleiding = opleiding;
        }
    }

    private boolean isStudentToegestaan() {
        if(this.vooropleiding == Vooropleiding.ANDERE) return false;
        if(this.vooropleiding == Vooropleiding.HAVO || vooropleiding == Vooropleiding.VWO || vooropleiding == Vooropleiding.MBO){

            // Als bsa null is is deze nog nooit aangemaakt
            if(this.studieAdvies == null){
                return true;
            }

            return this.studieAdvies.isBSAAdviesBehaald();

        }
        throw new RuntimeException();
    }

    public void geefStudentVrijstellingVoorVak(Vak vak){
        if(this.opleiding == null) throw new IllegalStateException("Student is nog niet ingeschreven voor een opleiding");
        if(vak == null) throw new IllegalArgumentException("Vak mag niet leeg zijn");
        if(this.vrijstellingen.contains(vak)) throw new IllegalArgumentException("Student heeft al vrijstelling voor dit vak");

        this.vrijstellingen.add(vak);
        this.studieAdvies.voegStudiePuntenToe(vak.getToets().getPunten());
    }

    public void setVooropleiding(Vooropleiding vooropleiding) {
        this.vooropleiding = vooropleiding;
    }

    public void setPesoonsGegevens(PersoonsGegevens persoonsGegevens) {
        this.persoonsGegevens = persoonsGegevens;
    }

    public Long getStudentId() {
        return studentId;
    }

    public PersoonsGegevens getPersoonsGegevens() {
        return persoonsGegevens;
    }

    public Vooropleiding getVooropleiding() {
        return vooropleiding;
    }

    public BSA getStudieAdvies() {
        return studieAdvies;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public List<Vak> getVrijstellingen() {
        return vrijstellingen;
    }
}
