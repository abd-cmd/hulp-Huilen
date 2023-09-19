package nl.hu.inno.humc.monoliet.presentation;


import nl.hu.inno.humc.monoliet.domain.Vooropleiding;

import java.time.LocalDate;

public class StudentDto {
    private Long studentId;
    private String voornaam;
    private String achternaam;
    private String roepnaam;
    private LocalDate geboortedatum;
    private String email;
    private String telefoonNummer;
    private String straat;
    private String huisnummer;
    private String postcode;
    private String plaats;

    private Vooropleiding vooropleiding;




    public Long getStudentId() {
        return studentId;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getRoepnaam() {
        return roepnaam;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPlaats() {
        return plaats;
    }

    public Vooropleiding getVooropleiding() {
        return vooropleiding;
    }
}
