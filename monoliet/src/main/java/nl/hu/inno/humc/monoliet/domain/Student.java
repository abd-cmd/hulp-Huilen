package nl.hu.inno.humc.monoliet.domain;

import jakarta.persistence.*;
import nl.hu.inno.humc.monoliet.domain.persoonsgegevens.PersoonsGegevens;

import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long studentId;

    @Embedded
    private PersoonsGegevens persoonsGegevens;

    @Enumerated(EnumType.STRING)
    private Vooropleiding vooropleiding;

    // TODO verander naar Object type Opleiding
    private String opleiding;

    public Student(){}

}
