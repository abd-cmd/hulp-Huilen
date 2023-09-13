package nl.hu.inno.humc.monoliet.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BSA {

    @Id
    @GeneratedValue
    private Long id;
    private int minVerplichteStudiePunten;
    private int behaaldeStudiepunten;


    protected BSA(){}
    public BSA(int minVerplichteStudiePunten) {
        this.minVerplichteStudiePunten = minVerplichteStudiePunten;
        this.behaaldeStudiepunten = 0;
    }

    public void voegStudiePuntenToe(Integer studiePunten){
        if(studiePunten == null) throw new RuntimeException();
        if(studiePunten < 0) throw new RuntimeException("");

        this.behaaldeStudiepunten += studiePunten;
    }

    public boolean getHuidigAdvies(){
        return this.behaaldeStudiepunten >= this.minVerplichteStudiePunten;
    }
}
