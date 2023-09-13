package nl.hu.inno.humc.monoliet.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class BSA {

    @Id
    @GeneratedValue
    private Long id;
    private int minVerplichteStudiePunten;
    private int behaaldeStudiepunten;
    private LocalDate ingangsDatum;


    protected BSA(){}
    public BSA(int minVerplichteStudiePunten, LocalDate ingangsDatum) {
        this.minVerplichteStudiePunten = minVerplichteStudiePunten;
        this.ingangsDatum = ingangsDatum;
        this.behaaldeStudiepunten = 0;
    }

    public void voegStudiePuntenToe(Integer studiePunten){
        if(studiePunten == null) throw new RuntimeException();
        if(studiePunten < 0) throw new RuntimeException();
        if(this.ingangsDatum.isBefore(LocalDate.now().minusYears(2))){
            throw new RuntimeException("Ingangsdatum is ouder dan 2 jaar, kan geen studiepunten meer toevoegen");
        }

        this.behaaldeStudiepunten += studiePunten;
    }

    public boolean getHuidigAdvies(){
        if(this.ingangsDatum.isAfter(LocalDate.now().minusYears(1))) {
            return this.behaaldeStudiepunten >= this.minVerplichteStudiePunten;
        }
        else return this.behaaldeStudiepunten == this.minVerplichteStudiePunten;
    }
}
