package nl.hu.inno.humc.student.domain.persoonsgegevens;

import java.util.Objects;

public class Naam {
    private String voornaam;
    private String achternaam;
    private String roepnaam;

    protected Naam(){}
    public Naam(String voornaam, String achternaam, String roepnaam){
        if (voornaam.isBlank() || achternaam.isBlank()) {
            throw new IllegalArgumentException("Voornaam en achternaam mogen niet leeg zijn");
        }
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.roepnaam = roepnaam;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Naam naam = (Naam) o;
        return Objects.equals(voornaam, naam.voornaam) && Objects.equals(achternaam, naam.achternaam) && Objects.equals(roepnaam, naam.roepnaam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voornaam, achternaam, roepnaam);
    }
}
