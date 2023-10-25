package nl.hu.inno.humc.student.domain;

import jakarta.persistence.*;
import nl.hu.inno.humc.student.domain.persoonsgegevens.PersoonsGegevens;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long studentId;

    @Embedded
    private PersoonsGegevens persoonsGegevens;

    @Enumerated(EnumType.STRING)
    private Vooropleiding vooropleiding;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<BSA> bsaList;

    @OneToMany
    private List<Opleiding> opleidingen;

    @OneToMany
    private List<Vak> vrijstellingen;

    protected Student(){}

    public Student(PersoonsGegevens persoonsGegevens, Vooropleiding vooropleiding){
        if(persoonsGegevens == null || vooropleiding == null){
            throw new IllegalArgumentException("Persoonsgegevens en vooropleiding mogen niet leeg zijn");
        }
        this.persoonsGegevens = persoonsGegevens;
        this.vooropleiding = vooropleiding;
        this.vrijstellingen = new ArrayList<>();
        this.bsaList = new ArrayList<>();
        this.opleidingen = new ArrayList<>();
    }

    public void schrijfInVoorOpleiding(Opleiding opleiding){
        if(opleiding == null) throw new IllegalArgumentException("Opleiding mag niet leeg zijn");
        if(this.opleidingen.contains(opleiding)) throw new IllegalArgumentException("Student is al ingeschreven voor deze opleiding");

        if(isStudentToegestaanOpOpleiding(opleiding)){

            // als er nog geen bsa is aangemaakt voor deze opleiding maak er dan een aan
            if(this.bsaList.stream().noneMatch(bsa -> bsa.getOpleiding().equals(opleiding))) {
                this.bsaList.add(new BSA(30, opleiding));
            }
            this.opleidingen.add(opleiding);
        }
    }

    private boolean isStudentToegestaanOpOpleiding(Opleiding opleiding) {
        if(this.vooropleiding == Vooropleiding.ANDERE) return false;
        if(this.vooropleiding == Vooropleiding.HAVO || vooropleiding == Vooropleiding.VWO || vooropleiding == Vooropleiding.MBO){

            // Zoek de bsa van de opleiding waar de student zich voor wil inschrijven
            BSA bsaVanOpleiding = this.bsaList.stream().filter(bsa -> bsa.getOpleiding().equals(opleiding)).findFirst().orElse(null);

            // Als de student nog geen bsa heeft voor deze opleiding, dan is de student toegestaan
            if(bsaVanOpleiding == null) {
                return true;
            }

            return bsaVanOpleiding.isBSAAdviesBehaald();

        }
        throw new RuntimeException();
    }

    public void geefStudentVrijstellingVoorVak(Vak vak){
        if(vak == null) throw new IllegalArgumentException("Vak mag niet leeg zijn");
        if(!this.opleidingen.contains(vak.getOpleiding())) throw new IllegalStateException("Student is nog niet ingeschreven voor deze opleiding");
        if(this.vrijstellingen.contains(vak)) throw new IllegalArgumentException("Student heeft al vrijstelling voor dit vak");

        this.vrijstellingen.add(vak);

        // Voeg de studiepunten van het vak toe aan het bsa van de opleiding
        Optional<BSA> bsaVanOpleiding = this.bsaList.stream().filter(bsa -> bsa.getOpleiding().equals(vak.getOpleiding())).findFirst();
        bsaVanOpleiding.ifPresent(bsa -> bsa.voegStudiePuntenToe(vak.getStudiePunten()));
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

    public List<BSA> getStudieAdviezen() {
        return bsaList;
    }

    public List<Opleiding> getOpleidingen() {
        return opleidingen;
    }

    public List<Vak> getVrijstellingen() {
        return vrijstellingen;
    }
}
