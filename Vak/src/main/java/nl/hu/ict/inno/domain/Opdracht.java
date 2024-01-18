package nl.hu.ict.inno.domain;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Document
public class Opdracht {
    @Id
    private String id;
    private String vakId;
    private LocalDate inleverdatum;
    private String beschrijving;
    private int teBehalenPunten;


    public Opdracht(String id, String vakId, LocalDate inleverdatum, String beschrijving, int teBehalenPunten) {
        this.id = id;
        this.vakId = vakId;
        this.inleverdatum = inleverdatum;
        this.beschrijving = beschrijving;
        this.teBehalenPunten = teBehalenPunten;
    }

    public Opdracht() {
    }

    public String getVakId() {
        return vakId;
    }

    public void setTeBehalenPunten(int teBehalenPunten) {
        this.teBehalenPunten = teBehalenPunten;
    }

    public LocalDate getInleverdatum() {
        return inleverdatum;
    }

    public String getBeschrijving() {
        return beschrijving;
    }


    public int getTeBehalenPunten() {
        return teBehalenPunten;
    }

    public String getId() {
        return id;
    }
}
