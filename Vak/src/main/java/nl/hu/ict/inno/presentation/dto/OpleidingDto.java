package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class OpleidingDto {

    private String opleidingId;
    private String Naam;


    public OpleidingDto(String opleidingId, String Naam) {
        this.opleidingId = opleidingId;
        this.Naam = Naam;
    }

}
