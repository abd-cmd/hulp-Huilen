package nl.hu.inno.humc.monoliet.domain;

import jakarta.persistence.*;

@Entity
public class OpleidingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String beschrijving;
    private Type type;
    private Long punten;
    private String locatie;
    private String taal;

    public OpleidingDetails(Long id, String beschrijving, Type type, Long punten, String locatie, String taal) {
        this.id = id;
        this.beschrijving = beschrijving;
        this.type = type;
        this.punten = punten;
        this.locatie = locatie;
        this.taal = taal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
