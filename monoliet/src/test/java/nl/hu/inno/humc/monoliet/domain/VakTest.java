package nl.hu.inno.humc.monoliet.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VakTest {

    @Test
    void getNaam() {
        LocalDateTime begindatum = LocalDateTime.parse("2019-03-27T10:15:30");
        LocalDateTime einddatum = LocalDateTime.parse("2020-03-27T10:15:30");
        LocalDateTime toetsdatum = LocalDateTime.parse("2020-04-27T10:15:30");
        LocalDateTime herkansingsdatum = LocalDateTime.parse("2020-05-27T10:15:30");

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens);

        System.out.println(vak.getNaam());

        assertEquals(vak.getNaam(),"Cisq1");
    }

    @Test
    void getEindDatum() {
        LocalDateTime begindatum = LocalDateTime.parse("2019-03-27T10:15:30");
        LocalDateTime einddatum = LocalDateTime.parse("2020-03-27T10:15:30");
        LocalDateTime toetsdatum = LocalDateTime.parse("2020-04-27T10:15:30");
        LocalDateTime herkansingsdatum = LocalDateTime.parse("2020-05-27T10:15:30");

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens);

        assertEquals(vak.getEindDatum(),einddatum);
    }

    @Test
    void getPeriode() {
        LocalDateTime begindatum = LocalDateTime.parse("2019-03-27T10:15:30");
        LocalDateTime einddatum = LocalDateTime.parse("2020-03-27T10:15:30");
        LocalDateTime toetsdatum = LocalDateTime.parse("2020-04-27T10:15:30");
        LocalDateTime herkansingsdatum = LocalDateTime.parse("2020-05-27T10:15:30");

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens);

        assertEquals(vak.getPeriode(),3);
    }

    @Test
    void gettoetsvorm() {
        LocalDateTime begindatum = LocalDateTime.parse("2019-03-27T10:15:30");
        LocalDateTime einddatum = LocalDateTime.parse("2020-03-27T10:15:30");
        LocalDateTime toetsdatum = LocalDateTime.parse("2020-04-27T10:15:30");
        LocalDateTime herkansingsdatum = LocalDateTime.parse("2020-05-27T10:15:30");

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens);

        assertEquals(vak.getToets().getVorm(),"open vragen");
    }

    @Test
    void getherkansingsperiode() {
        LocalDateTime begindatum = LocalDateTime.parse("2019-03-27T10:15:30");
        LocalDateTime einddatum = LocalDateTime.parse("2020-03-27T10:15:30");
        LocalDateTime toetsdatum = LocalDateTime.parse("2020-04-27T10:15:30");
        LocalDateTime herkansingsdatum = LocalDateTime.parse("2020-05-27T10:15:30");

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens);

        assertEquals(vak.getHerkansingGegevens().getperiode(),1);
    }

    @Test
    void getToetsCijfer() {
        LocalDateTime begindatum = LocalDateTime.parse("2019-03-27T10:15:30");
        LocalDateTime einddatum = LocalDateTime.parse("2020-03-27T10:15:30");
        LocalDateTime toetsdatum = LocalDateTime.parse("2020-04-27T10:15:30");
        LocalDateTime herkansingsdatum = LocalDateTime.parse("2020-05-27T10:15:30");

        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);

        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);

        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
                toetsGegevens,
                herkansingGegevens);

        assertEquals(vak.getToets().getPunten(),100);
    }
}