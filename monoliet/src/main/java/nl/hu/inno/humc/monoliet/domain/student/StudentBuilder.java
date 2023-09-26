package nl.hu.inno.humc.monoliet.domain.student;

import nl.hu.inno.humc.monoliet.domain.student.persoonsgegevens.*;

import java.time.LocalDate;

public class StudentBuilder {
    private Naam naam;
    private Email email;
    private TelefoonNummer telefoonNummer;
    private Adres adres;
    private LocalDate geboortedatum;
    private Vooropleiding vooropleiding;

    public StudentBuilder withNaam(String voornaam, String achternaam, String roepnaam) {
        this.naam = new Naam(voornaam, achternaam, roepnaam);
        return this;
    }

    public StudentBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public StudentBuilder withTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = new TelefoonNummer(telefoonNummer);
        return this;
    }

    public StudentBuilder withAdres(String plaats, String postcode, String straat, String huisnummer) {
        this.adres = new Adres(plaats, postcode, straat, huisnummer);
        return this;
    }

    public StudentBuilder withGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
        return this;
    }

    public StudentBuilder withVooropleiding(Vooropleiding vooropleiding) {
        this.vooropleiding = vooropleiding;
        return this;
    }

    public Student build() {
        PersoonsGegevens persoonsGegevens = new PersoonsGegevens(naam, geboortedatum, adres, email, telefoonNummer);
        return new Student(persoonsGegevens, vooropleiding);
    }
}

