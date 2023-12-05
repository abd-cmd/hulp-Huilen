package nl.hu.ict.inno.presentation.dto;

import nl.hu.ict.inno.domain.Vak;

public record VakOpleidingDto(
        String opleidingId,
        Vak vak
) {
    @Override
    public String opleidingId() {
        return opleidingId;
    }

    @Override
    public Vak vak() {
        return vak;
    }
}
