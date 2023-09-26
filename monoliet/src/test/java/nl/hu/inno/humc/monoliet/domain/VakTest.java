package nl.hu.inno.humc.monoliet.domain;

import nl.hu.inno.humc.monoliet.data.VakRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VakTest {


    @Test
    void TestgetNaam() {
        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);


        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens);

        System.out.println(vak.getNaam());

        assertEquals(vak.getNaam(),"Cisq1");
    }

    @Test
    void TestgetEindDatum() {
        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);


        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens);

        assertEquals(vak.getEindDatum(),einddatum);
    }

    @Test
    void TestgetPeriode() {
        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);


        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens);

        assertEquals(vak.getPeriode(),3);
    }

    @Test
    void Testgettoetsvorm() {
        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);


        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens);

        assertEquals(vak.getToetsGegevens().getVorm(),"open vragen");
    }

    @Test
    void Testgetherkansingsperiode() {
        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);


        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens);

        assertEquals(vak.getHerkansingGegevens().getherkansingsperiode(),1);
    }

    @Test
    void TestgetToetsCijfer() {
        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens);

        assertEquals(vak.getToetsGegevens().gettoetsPunten(),100);
    }

    @Test
    void TestVakAnnmakenMetToetsEnHerkansingGegevens() {
        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);


        ToetsGegevens toetsGegevens = new ToetsGegevens("open_vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,toetsGegevens,herkansingGegevens);

        assertEquals("Cisq1",vak.getNaam());
        assertEquals(LocalDate.of(2019,03,27),vak.getBeginDatum());
        assertEquals(LocalDate.of(2020,03,27),vak.getEindDatum());
        assertEquals(3,vak.getPeriode());
        assertEquals(toetsGegevens,vak.getToetsGegevens());
        assertEquals(herkansingGegevens,vak.getHerkansingGegevens());

    }

    @Test
    void TestVakAnnmakenZonderHerkansingGegevens() {
        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open_vragen",toetsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,toetsGegevens,null);

        assertEquals("Cisq1",vak.getNaam());
        assertEquals(LocalDate.of(2019,03,27),vak.getBeginDatum());
        assertEquals(LocalDate.of(2020,03,27),vak.getEindDatum());
        assertEquals(3,vak.getPeriode());
        assertEquals(toetsGegevens,vak.getToetsGegevens());
        assertNull(vak.getHerkansingGegevens());

    }
}