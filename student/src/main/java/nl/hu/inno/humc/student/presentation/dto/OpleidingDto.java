package nl.hu.inno.humc.student.presentation.dto;

import java.time.LocalDate;

public class OpleidingDto {
    private String id;
    private String naam;
    private LocalDate startDatum;
    private LocalDate eindDatum;
    private int beschikbarePlekken;

    public String getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public LocalDate getStartDatum() {
        return startDatum;
    }

    public LocalDate getEindDatum() {
        return eindDatum;
    }

    public int getBeschikbarePlekken() {
        return beschikbarePlekken;
    }
}
