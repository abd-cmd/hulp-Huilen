package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.time.LocalDate;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReciveOpdrachtDto {

    @Id
    private Long id;

    private String vakId;
    private LocalDate inleverdatum;
    private String beschrijving;
    private int teBehalenPunten;

    public ReciveOpdrachtDto(Long id, String vakId, LocalDate inleverdatum, String beschrijving, int teBehalenPunten) {
        this.id = id;
        this.vakId = vakId;
        this.inleverdatum = inleverdatum;
        this.beschrijving = beschrijving;
        this.teBehalenPunten = teBehalenPunten;
    }

    public ReciveOpdrachtDto() {
    }

    public Long getId() {
        return id;
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

    public String getVakId() {
        return vakId;
    }
}
