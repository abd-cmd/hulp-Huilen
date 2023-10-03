package nl.hu.inno.humc.monoliet.presentation.dto;

import nl.hu.inno.humc.monoliet.domain.opleiding.OpleidingDetails;
import nl.hu.inno.humc.monoliet.domain.vak.Vak;

import java.time.LocalDate;
import java.util.List;

public record OpleidingDto(
        Long opleidingId,
        List<Vak> vakken,
        String naam,
        LocalDate startDatum,
        LocalDate eindDatum,

        OpleidingDetails opleidingDetails
) {

}

