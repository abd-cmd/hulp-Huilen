package nl.hu.inno.humc.monoliet.domain.persoonsgegevens;

import nl.hu.inno.humc.monoliet.domain.exceptions.InvalidTelefoonNummerException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelefoonNummer {
    private String telefoonNummer;

    public TelefoonNummer(String telefoonNummer){
        if(telefoonNummer.isBlank()) {
            throw new IllegalArgumentException("Telefoonnummer mag niet leeg zijn");
        }
        if(!isTelefoonNummerValide(telefoonNummer)) {
            throw new InvalidTelefoonNummerException("Ongeldig telefoonnummer: " + telefoonNummer);
        }

        this.telefoonNummer = telefoonNummer;
    }

    private boolean isTelefoonNummerValide(String telefoonNummer){
        Pattern regex = Pattern.compile("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$");
        Matcher matcher = regex.matcher(telefoonNummer);
        return matcher.matches();
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefoonNummer that = (TelefoonNummer) o;
        return Objects.equals(telefoonNummer, that.telefoonNummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefoonNummer);
    }
}
