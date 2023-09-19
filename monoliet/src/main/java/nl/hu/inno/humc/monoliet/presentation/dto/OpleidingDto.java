package nl.hu.inno.humc.monoliet.presentation.dto;

import nl.hu.inno.humc.monoliet.domain.Type;

import java.time.LocalDate;

public record OpleidingDto(
        Long opleidingId,
        String naam,
        String beschrijving,
        Type type,
        Long punten,
        String locatie,
        String taal,
        LocalDate startDatum,
        LocalDate eindDatum
) {}
