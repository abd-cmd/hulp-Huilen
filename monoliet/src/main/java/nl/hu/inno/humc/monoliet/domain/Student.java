package nl.hu.inno.humc.monoliet.domain;

import jakarta.persistence.*;
import nl.hu.inno.humc.monoliet.domain.persoonsgegevens.PersoonsGegevens;

import java.time.LocalDate;


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

    // TODO verander naar Object type Opleiding
    private String opleiding;

    protected Student(){}

    public Student(PersoonsGegevens persoonsGegevens, Vooropleiding vooropleiding){
        if(persoonsGegevens == null || vooropleiding == null){
            throw new RuntimeException();
        }

        this.persoonsGegevens = persoonsGegevens;
        this.vooropleiding = vooropleiding;
    }

    public void schrijfInVoorOpleiding(String opleiding){

        if(isStudentToegestaan()){
            if(this.studieAdvies == null){
                this.studieAdvies = new BSA(30, LocalDate.now()); // TODO attributen afleiden van Opleiding object, wanneer deze bestaat.
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

            return this.studieAdvies.getHuidigAdvies();

        }
        throw new RuntimeException();
    }






}
