package nl.hu.inno.humc.student.domain;

import jakarta.persistence.ManyToOne;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Document
public class BSA {

    @MongoId
    private String id;
    private int minVerplichteStudiePunten;
    private int behaaldeStudiepunten;
    private LocalDate ingangsDatum;
    private Opleiding opleiding;


    protected BSA(){}
    public BSA(int minVerplichteStudiePunten, Opleiding opleiding) {
        this.minVerplichteStudiePunten = minVerplichteStudiePunten;
        this.ingangsDatum = opleiding.getStartDatum();
        this.opleiding = opleiding;
        this.behaaldeStudiepunten = 0;
    }

    public void voegStudiePuntenToe(Integer studiePunten){
        if(studiePunten == null || studiePunten < 0) throw new IllegalArgumentException("Ongeldige studiepuntenwaarde");
        if(this.ingangsDatum.isBefore(LocalDate.now().minusYears(2))){
            throw new IllegalStateException("Ingangsdatum is ouder dan 2 jaar, kan geen studiepunten meer toevoegen");
        }

        this.behaaldeStudiepunten += studiePunten;
    }

    public boolean isBSAAdviesBehaald(){
        if(this.ingangsDatum.isAfter(LocalDate.now().minusYears(1))) {
            return this.behaaldeStudiepunten >= this.minVerplichteStudiePunten;
        }
        else return this.behaaldeStudiepunten == this.minVerplichteStudiePunten;
    }

    public int getBehaaldeStudiepunten() {
        return this.behaaldeStudiepunten;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }
}
