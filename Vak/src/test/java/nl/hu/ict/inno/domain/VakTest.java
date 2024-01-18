package nl.hu.ict.inno.domain;

import nl.hu.ict.inno.domain.vakGegevens.HerkansingGegevens;
import nl.hu.ict.inno.domain.vakGegevens.IngangEisen;
import nl.hu.ict.inno.domain.vakGegevens.LoopTijd;
import nl.hu.ict.inno.domain.vakGegevens.ToetsGegevens;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VakTest {


    @Test
    void TestgetNaam() {

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens =
                new HerkansingGegevens(1,herkansingsdatum,100,new ArrayList<>());

        IngangEisen ingangEisen = new IngangEisen(5,false);

        LoopTijd loopTijd = new LoopTijd(begindatum,einddatum);

        Vak vak = new Vak("Cisq1",3,40,ingangEisen,loopTijd,
                toetsGegevens,
                herkansingGegevens,null,new ArrayList<>());

        System.out.println(vak.getNaam());

        assertEquals(vak.getNaam(),"Cisq1");
    }

    @Test
    void TestgetEindDatum() {

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);
        LocalDate opleidingEindDatum = LocalDate.of(2023, 10, 26);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens =
                new HerkansingGegevens(1,herkansingsdatum,100,new ArrayList<>());

        IngangEisen ingangEisen = new IngangEisen(5,false);

        LoopTijd loopTijd = new LoopTijd(begindatum,einddatum);

        Vak vak = new Vak("Cisq1",3,40,ingangEisen,loopTijd,
                toetsGegevens,
                herkansingGegevens,null,new ArrayList<>());
        System.out.println(vak.getNaam());

        assertEquals(vak.getLoopTijd().getEindDatum(),einddatum);
    }

    @Test
    void TestgetPeriode() {


        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens =
                new HerkansingGegevens(1,herkansingsdatum,100,new ArrayList<>());

        IngangEisen ingangEisen = new IngangEisen(5,false);

        LoopTijd loopTijd = new LoopTijd(begindatum,einddatum);

        Vak vak = new Vak("Cisq1",3,40,ingangEisen,loopTijd,
                toetsGegevens,
                herkansingGegevens,null,new ArrayList<>());

        System.out.println(vak.getNaam());

        assertEquals(vak.getPeriode(),3);
    }

    @Test
    void Testgettoetsvorm() {

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens =
                new HerkansingGegevens(1,herkansingsdatum,100,new ArrayList<>());

        IngangEisen ingangEisen = new IngangEisen(5,false);

        LoopTijd loopTijd = new LoopTijd(begindatum,einddatum);

        Vak vak = new Vak("Cisq1",3,40,ingangEisen,loopTijd,
                toetsGegevens,
                herkansingGegevens,null,new ArrayList<>());


        System.out.println(vak.getNaam());

        assertEquals(vak.getToetsGegevens().getVorm(),"open vragen");
    }

    @Test
    void Testgetherkansingsperiode() {

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens =
                new HerkansingGegevens(1,herkansingsdatum,100,new ArrayList<>());

        IngangEisen ingangEisen = new IngangEisen(5,false);

        LoopTijd loopTijd = new LoopTijd(begindatum,einddatum);

        Vak vak = new Vak("Cisq1",3,40,ingangEisen,loopTijd,
                toetsGegevens,
                herkansingGegevens,null,new ArrayList<>());

        System.out.println(vak.getNaam());

        assertEquals(vak.getHerkansingGegevens().getherkansingsperiode(),1);
    }

    @Test
    void TestgetToetsCijfer() {

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens =
                new HerkansingGegevens(1,herkansingsdatum,100,new ArrayList<>());


        IngangEisen ingangEisen = new IngangEisen(5,false);

        LoopTijd loopTijd = new LoopTijd(begindatum,einddatum);

        Vak vak = new Vak("Cisq1",3,40,ingangEisen,loopTijd,
                toetsGegevens,
                herkansingGegevens,null,new ArrayList<>());

        System.out.println(vak.getNaam());

        assertEquals(vak.getToetsGegevens().gettoetsPunten(),100);
    }

    @Test
    void TestVakAnnmakenMetToetsEnHerkansingGegevens() {

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens =
                new HerkansingGegevens(1,herkansingsdatum,100,new ArrayList<>());


        IngangEisen ingangEisen = new IngangEisen(5,false);

        LoopTijd loopTijd = new LoopTijd(begindatum,einddatum);
        Vak vak = new Vak("Cisq1",3,40,ingangEisen,loopTijd,
                toetsGegevens,
                herkansingGegevens,null,new ArrayList<>());

        System.out.println(vak.getNaam());
        assertEquals("Cisq1",vak.getNaam());
        assertEquals(ingangEisen,vak.getIngangEisen());
        assertEquals(loopTijd,vak.getLoopTijd());
        assertEquals(3,vak.getPeriode());
        assertEquals(toetsGegevens,vak.getToetsGegevens());
        assertEquals(herkansingGegevens,vak.getHerkansingGegevens());
    }

    @Test
    void TestVakAnnmakenZonderHerkansingGegevens() {

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        IngangEisen ingangEisen = new IngangEisen(5,false);

        LoopTijd loopTijd = new LoopTijd(begindatum,einddatum);

        Vak vak = new Vak("Cisq1",3,40,ingangEisen,loopTijd,
                toetsGegevens,
                null,null,new ArrayList<>());

        System.out.println(vak.getNaam());

        assertEquals("Cisq1",vak.getNaam());
        assertEquals(ingangEisen,vak.getIngangEisen());
        assertEquals(loopTijd,vak.getLoopTijd());
        assertEquals(3,vak.getPeriode());
        assertEquals(toetsGegevens,vak.getToetsGegevens());
        assertNull(vak.getHerkansingGegevens());
    }

    @Test
    void TestVakBestaatNietZonderOpleiding() {

        LocalDate begindatum = LocalDate.of(2019,03,27);
        LocalDate einddatum = LocalDate.of(2020,03,27);
        LocalDate  toetsdatum  = LocalDate.of(2023, 9, 26);
        LocalDate herkansingsdatum = LocalDate.of(2023, 10, 26);

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens =
                new HerkansingGegevens(1,herkansingsdatum,100,new ArrayList<>());


        IngangEisen ingangEisen = new IngangEisen(5,false);

        LoopTijd loopTijd = new LoopTijd(begindatum,einddatum);

        Vak vak = new Vak("Cisq1",3,40,ingangEisen,loopTijd,
                toetsGegevens,
                herkansingGegevens,null,new ArrayList<>());


    }
}