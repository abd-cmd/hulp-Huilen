package nl.hu.ict.inno.presentation.dto;

import nl.hu.ict.inno.domain.InschrijfDatum;
import nl.hu.ict.inno.domain.OpleidingDetails;
import nl.hu.ict.inno.domain.Periode;
import nl.hu.ict.inno.domain.Vak;

import java.time.LocalDate;
import java.util.List;

public record OpleidingDto(
        String opleidingId,
        List<Vak> vakken,
        String naam,
        Periode periode,
        InschrijfDatum inschrijfDatum,
        OpleidingDetails opleidingDetails
) {

}

