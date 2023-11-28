package nl.hu.ict.inno.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class InschrijfDatum {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate datum;
}
