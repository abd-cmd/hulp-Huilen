package nl.hu.ict.inno.domain;

import jakarta.persistence.*;

public class OpleidingDetails {

    private String beschrijving;
    private Type type;
    private Long punten;
    private String locatie;
    private String taal;

    public OpleidingDetails(String beschrijving, Type type, Long punten, String locatie, String taal) {
        this.beschrijving = beschrijving;
        this.type = type;
        this.punten = punten;
        this.locatie = locatie;
        this.taal = taal;
    }


    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getPunten() {
        return punten;
    }

    public void setPunten(Long punten) {
        this.punten = punten;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getTaal() {
        return taal;
    }

    public void setTaal(String taal) {
        this.taal = taal;
    }
}
