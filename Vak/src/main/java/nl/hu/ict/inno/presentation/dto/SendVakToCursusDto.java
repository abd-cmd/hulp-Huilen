package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SendVakToCursusDto {

    private String VakNaam;

    public SendVakToCursusDto() {
    }

    public SendVakToCursusDto(String vakNaam) {
        VakNaam = vakNaam;
    }

    public String getVakNaam() {
        return VakNaam;
    }
}
