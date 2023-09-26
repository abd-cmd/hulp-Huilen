package nl.hu.inno.humc.monoliet.application;

import nl.hu.inno.humc.monoliet.data.VakRepository;
import nl.hu.inno.humc.monoliet.domain.HerkansingGegevens;
import nl.hu.inno.humc.monoliet.domain.ToetsGegevens;
import nl.hu.inno.humc.monoliet.domain.Vak;
import nl.hu.inno.humc.monoliet.domain.exceptions.VakNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class VakServiceIntegrationTest {

//
//    @MockBean
//    private VakRepository vakRepository;
//
//
//    @Autowired
//    private VakService vakService;
//
//    @Test
//    @DisplayName("checken of service class het vak kan opslaan")
//    void VakOpslaanInDatabase() throws VakNotFoundException {
//
//        LocalDateTime begindatum = LocalDateTime.parse("2019-03-27T10:15:30");
//        LocalDateTime einddatum = LocalDateTime.parse("2020-03-27T10:15:30");
//        LocalDateTime toetsdatum = LocalDateTime.parse("2020-04-27T10:15:30");
//        LocalDateTime herkansingsdatum = LocalDateTime.parse("2020-05-27T10:15:30");
//
//        ToetsGegevens toetsGegevens = new ToetsGegevens("open vragen",toetsdatum,100);
//
//        HerkansingGegevens herkansingGegevens = new HerkansingGegevens(1,herkansingsdatum,100);
//
//        Vak vak = new Vak("Cisq1",begindatum,einddatum,3,
//                toetsGegevens, herkansingGegevens);
//
//        Vak savedVak = vakService.saveVak(vak.getNaam(),vak.getBeginDatum(),vak.getEindDatum(),vak.getPeriode()
//                                            ,vak.getToetsGegevens(),vak.getHerkansingGegevens());
//
//        when(vakRepository.findById(1L)).thenReturn(Optional.ofNullable(savedVak));
//
//        assertEquals(1L,vak.getId());
//
//    }
}