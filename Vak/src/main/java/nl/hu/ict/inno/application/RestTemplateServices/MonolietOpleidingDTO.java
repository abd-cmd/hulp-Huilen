package nl.hu.ict.inno.application.RestTemplateServices;

import nl.hu.ict.inno.domain.Opleiding;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record MonolietOpleidingDTO(
        Long opleidingId,
        String naam,
        LocalDate startDatum,
        LocalDate eindDatum
) {
    public Opleiding toOpleiding(){
        return new Opleiding(opleidingId, naam);
    }
}
