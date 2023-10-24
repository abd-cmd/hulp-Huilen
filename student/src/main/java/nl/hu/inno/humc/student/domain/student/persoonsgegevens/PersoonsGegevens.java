package nl.hu.inno.humc.student.domain.student.persoonsgegevens;

import jakarta.persistence.Embedded;

import java.time.LocalDate;
import java.util.Objects;

public class PersoonsGegevens {

    @Embedded
    private Naam naam;
    private LocalDate geboortedatum;

    @Embedded
    private Adres adres;

    @Embedded
    private Email email;
    @Embedded
    private TelefoonNummer telefoonNummer;

    protected PersoonsGegevens(){}

    public PersoonsGegevens(Naam naam, LocalDate geboortedatum, Adres adres, Email email, TelefoonNummer telefoonNummer){
        if(naam == null || geboortedatum == null || adres == null || email == null || telefoonNummer == null){
            throw new IllegalArgumentException("Alle velden moeten ingevuld zijn");
        }
        this.naam = naam;
        this.geboortedatum = geboortedatum;
        this.adres = adres;
        this.email = email;
        this.telefoonNummer = telefoonNummer;
    }

    public Naam getNaam() {
        return naam;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public Adres getAdres() {
        return adres;
    }

    public Email getEmail() {
        return email;
    }

    public TelefoonNummer getTelefoonNummer() {
        return telefoonNummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersoonsGegevens that = (PersoonsGegevens) o;
        return Objects.equals(naam, that.naam) && Objects.equals(geboortedatum, that.geboortedatum) && Objects.equals(adres, that.adres) && Objects.equals(email, that.email) && Objects.equals(telefoonNummer, that.telefoonNummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, geboortedatum, adres, email, telefoonNummer);
    }
}
