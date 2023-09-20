package nl.hu.inno.humc.monoliet.domain.student;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BSATest {
    @Test
    public void testVoegStudiePuntenToeMetGeldigeWaarde() {
        LocalDate ingangsDatum = LocalDate.now().minusYears(1); // Ingangsdatum is 1 jaar geleden
        BSA bsa = new BSA(30, ingangsDatum);

        bsa.voegStudiePuntenToe(10);
        assertEquals(10, bsa.getBehaaldeStudiepunten());
    }

    @Test
    public void testVoegStudiePuntenToeMetOngeldigeWaarde() {
        LocalDate ingangsDatum = LocalDate.now().minusYears(1); // Ingangsdatum is 1 jaar geleden
        BSA bsa = new BSA(30, ingangsDatum);

        assertThrows(IllegalArgumentException.class, () -> bsa.voegStudiePuntenToe(-5));
    }

    @Test
    public void testVoegStudiePuntenToeBijTeOudeIngangsdatum() {
        BSA bsa = new BSA(30, LocalDate.now().minusYears(3)); // Ingangsdatum is 3 jaar geleden

        // Moet Exception gooien omdat je na 2 jaar geen punten meer mag toevoegen
        assertThrows(IllegalStateException.class, () -> bsa.voegStudiePuntenToe(10));
    }

    @Test
    public void testIsBSAAdviesBehaald_IngangsDatumBinnenJaar_TekortStudiepunten() {
        LocalDate ingangsDatum = LocalDate.now().minusYears(1); // Ingangsdatum is 1 jaar geleden
        BSA bsa = new BSA(30, ingangsDatum);

        assertFalse(bsa.isBSAAdviesBehaald());
    }

    @Test
    public void testIsBSAAdviesBehaald_IngangsDatumBinnenJaar_VoldoendeStudiepunten() {
        LocalDate ingangsDatum = LocalDate.now().minusYears(1); // Ingangsdatum is 1 jaar geleden
        BSA bsa = new BSA(30, ingangsDatum);

        bsa.voegStudiePuntenToe(30); // Genoeg studiepunten om aan het vereiste te voldoen

        assertTrue(bsa.isBSAAdviesBehaald());
    }
}