package nl.hu.inno.humc.monoliet.domain;

import nl.hu.inno.humc.monoliet.domain.opleiding.Opleiding;
import nl.hu.inno.humc.monoliet.domain.vak.HerkansingGegevens;
import nl.hu.inno.humc.monoliet.domain.vak.ToetsGegevens;
import nl.hu.inno.humc.monoliet.domain.vak.Vak;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VakTest {


    @Test
    void TestgetNaam() {
        LocalDate opleidingStartDatum = LocalDate.of(2023, 10, 26);

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);
        LocalDate opleidingEindDatum = LocalDate.of(2023, 10, 26);

        List<Vak> vakList = new ArrayList<>();

        Opleiding opleiding = new Opleiding(1L,vakList,"SD",opleidingStartDatum,opleidingEindDatum,null);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens,opleiding);

        System.out.println(vak.getNaam());

        assertEquals(vak.getNaam(),"Cisq1");
    }

    @Test
    void TestgetEindDatum() {
        LocalDate opleidingStartDatum = LocalDate.of(2023, 10, 26);

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);
        LocalDate opleidingEindDatum = LocalDate.of(2023, 10, 26);

        List<Vak> vakList = new ArrayList<>();

        Opleiding opleiding = new Opleiding(1L,vakList,"SD",opleidingStartDatum,opleidingEindDatum,null);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens,opleiding);

        System.out.println(vak.getNaam());

        assertEquals(vak.getEindDatum(),einddatum);
    }

    @Test
    void TestgetPeriode() {
        LocalDate opleidingStartDatum = LocalDate.of(2023, 10, 26);

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);
        LocalDate opleidingEindDatum = LocalDate.of(2023, 10, 26);

        List<Vak> vakList = new ArrayList<>();

        Opleiding opleiding = new Opleiding(1L,vakList,"SD",opleidingStartDatum,opleidingEindDatum,null);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens,opleiding);

        System.out.println(vak.getNaam());

        assertEquals(vak.getPeriode(),3);
    }

    @Test
    void Testgettoetsvorm() {
        LocalDate opleidingStartDatum = LocalDate.of(2023, 10, 26);

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);
        LocalDate opleidingEindDatum = LocalDate.of(2023, 10, 26);

        List<Vak> vakList = new ArrayList<>();

        Opleiding opleiding = new Opleiding(1L,vakList,"SD",opleidingStartDatum,opleidingEindDatum,null);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens,opleiding);

        System.out.println(vak.getNaam());

        assertEquals(vak.getToetsGegevens().getVorm(),"open vragen");
    }

    @Test
    void Testgetherkansingsperiode() {
        LocalDate opleidingStartDatum = LocalDate.of(2023, 10, 26);

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);
        LocalDate opleidingEindDatum = LocalDate.of(2023, 10, 26);

        List<Vak> vakList = new ArrayList<>();

        Opleiding opleiding = new Opleiding(1L,vakList,"SD",opleidingStartDatum,opleidingEindDatum,null);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens,opleiding);

        System.out.println(vak.getNaam());

        assertEquals(vak.getHerkansingGegevens().getherkansingsperiode(),1);
    }

    @Test
    void TestgetToetsCijfer() {
        LocalDate opleidingStartDatum = LocalDate.of(2023, 10, 26);

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);
        LocalDate opleidingEindDatum = LocalDate.of(2023, 10, 26);

        List<Vak> vakList = new ArrayList<>();

        Opleiding opleiding = new Opleiding(1L,vakList,"SD",opleidingStartDatum,opleidingEindDatum,null);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens,opleiding);

        System.out.println(vak.getNaam());

        assertEquals(vak.getToetsGegevens().gettoetsPunten(),100);
    }

    @Test
    void TestVakAnnmakenMetToetsEnHerkansingGegevens() {
        LocalDate opleidingStartDatum = LocalDate.of(2023, 10, 26);

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);
        LocalDate opleidingEindDatum = LocalDate.of(2023, 10, 26);

        List<Vak> vakList = new ArrayList<>();

        Opleiding opleiding = new Opleiding(1L,vakList,"SD",opleidingStartDatum,opleidingEindDatum,null);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens,opleiding);

        System.out.println(vak.getNaam());
        assertEquals("Cisq1",vak.getNaam());
        assertEquals(LocalDate.of(2019,03,27),vak.getBeginDatum());
        assertEquals(LocalDate.of(2020,03,27),vak.getEindDatum());
        assertEquals(3,vak.getPeriode());
        assertEquals(toetsGegevens,vak.getToetsGegevens());
        assertEquals(herkansingGegevens,vak.getHerkansingGegevens());

    }

    @Test
    void TestVakAnnmakenZonderHerkansingGegevens() {
        LocalDate opleidingStartDatum = LocalDate.of(2023, 10, 26);

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);
        LocalDate opleidingEindDatum = LocalDate.of(2023, 10, 26);

        List<Vak> vakList = new ArrayList<>();

        Opleiding opleiding = new Opleiding(1L,vakList,"SD",opleidingStartDatum,opleidingEindDatum,null);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens,opleiding);

        System.out.println(vak.getNaam());

        assertEquals("Cisq1",vak.getNaam());
        assertEquals(LocalDate.of(2019,03,27),vak.getBeginDatum());
        assertEquals(LocalDate.of(2020,03,27),vak.getEindDatum());
        assertEquals(3,vak.getPeriode());
        assertEquals(toetsGegevens,vak.getToetsGegevens());
        assertNull(vak.getHerkansingGegevens());

    }
}