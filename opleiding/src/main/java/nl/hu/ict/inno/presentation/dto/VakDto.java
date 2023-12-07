package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VakDto(
        String id,
        String naam,
        int periode,
        int beschikbaarPleken,
        LocalDate beginDatum,
        LocalDate eindDatum,
        int studiePunten
) {
}
