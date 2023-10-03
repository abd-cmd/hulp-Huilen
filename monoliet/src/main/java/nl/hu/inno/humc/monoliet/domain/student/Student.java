package nl.hu.inno.humc.monoliet.domain.student;

import jakarta.persistence.*;
import nl.hu.inno.humc.monoliet.domain.opleiding.Opleiding;
import nl.hu.inno.humc.monoliet.domain.student.persoonsgegevens.PersoonsGegevens;


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
    private BSA studieAdvies;

    @OneToOne
    private Opleiding opleiding;

    protected Student(){}

    public Student(PersoonsGegevens persoonsGegevens, Vooropleiding vooropleiding){
        if(persoonsGegevens == null || vooropleiding == null){
            throw new IllegalArgumentException("Persoonsgegevens en vooropleiding mogen niet leeg zijn");
        }

        this.persoonsGegevens = persoonsGegevens;
        this.vooropleiding = vooropleiding;
    }

    public void schrijfInVoorOpleiding(Opleiding opleiding){

        if(isStudentToegestaan()){
            if(this.studieAdvies == null){
                this.studieAdvies = new BSA(30, opleiding.getStartDatum()); // TODO attributen afleiden van Opleiding object, wanneer deze bestaat.
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
}
