package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.hu.ict.inno.domain.InschrijfDatum;
import nl.hu.ict.inno.domain.OpleidingDetails;
import nl.hu.ict.inno.domain.Periode;
import nl.hu.ict.inno.domain.Vak;

import java.time.LocalDate;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record OpleidingDto(
        String opleidingId,
        List<Vak> vakken,
        String naam,
        Periode periode,
        InschrijfDatum inschrijfDatum,
        OpleidingDetails opleidingDetails
) {

}

