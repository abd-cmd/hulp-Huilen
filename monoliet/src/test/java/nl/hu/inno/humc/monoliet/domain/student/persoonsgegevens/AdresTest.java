package nl.hu.inno.humc.monoliet.domain.student.persoonsgegevens;

import nl.hu.inno.humc.monoliet.domain.student.exceptions.InvalidPostcodeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdresTest {

    @Test
    public void testConstructorMetValideGegevens() {
        Adres adres = new Adres("Amsterdam", "1234AB", "Keizersgracht", "123");
        assertNotNull(adres);
    }

    @Test
    public void testConstructorMetLegeWaarde() {
        assertThrows(IllegalArgumentException.class, () -> new Adres(" ", "1234AB", "Keizersgracht", "123"));
    }

    @Test
    public void testPostcodeRegex() {
        // Postcode begint met een 0
        assertThrows(InvalidPostcodeException.class, () -> new Adres("Amsterdam", "0234", "Keizersgracht", "123"));
        // Postcode met spaties
        assertThrows(InvalidPostcodeException.class, () -> new Adres("Amsterdam", " 12 3 4 A b", "Keizersgracht", "123"));
        // Postcode met ongeldige characters
        assertThrows(InvalidPostcodeException.class, () -> new Adres("Amsterdam", "12&4 $#", "Keizersgracht", "123"));
    }

}