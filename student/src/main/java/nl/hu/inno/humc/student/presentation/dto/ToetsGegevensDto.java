package nl.hu.inno.humc.student.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ToetsGegevensDto {
    @JsonProperty("toetsPunten")
    private int studiepunten;

    public int getStudiepunten() {
        return studiepunten;
    }
}
