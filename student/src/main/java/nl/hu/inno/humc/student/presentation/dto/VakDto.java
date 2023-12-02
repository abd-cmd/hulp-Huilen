package nl.hu.inno.humc.student.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VakDto {
    private String id;
    private String naam;
    private LocalDate beginDatum;
    private LocalDate eindDatum;

    @JsonProperty("toetsGegevens")
    private ToetsGegevensDto toetsGegevens;
    private OpleidingDto opleiding;

    @JsonProperty("beschikbaarPleken")
    private int beschikbarePlekken;



    public String getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public LocalDate getBeginDatum() {
        return beginDatum;
    }

    public LocalDate getEindDatum() {
        return eindDatum;
    }

    public int getStudiePunten() {
        return toetsGegevens.getStudiepunten();
    }

    public OpleidingDto getOpleidingDto() {
        return opleiding;
    }

    public int getBeschikbarePlekken() {
        return beschikbarePlekken;
    }


}
