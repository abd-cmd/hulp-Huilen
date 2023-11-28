package nl.hu.ict.inno.presentation.dto;

import java.time.LocalDate;

public record VakDto(
        String naam,
        int periode,
        int beschikbaarPleken,
        LocalDate beginDatum,
        LocalDate eindDatum,
        int studiePunten
) {
}
