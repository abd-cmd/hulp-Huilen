package nl.hu.inno.humc.student.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Vak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naam;
    private LocalDate beginDatum;
    private LocalDate eindDatum;
    private int studiePunten;
    @OneToOne
    private Opleiding opleiding;

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public int getStudiePunten() {
        return studiePunten;
    }
}
