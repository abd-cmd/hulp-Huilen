package nl.hu.inno.humc.monoliet;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import nl.hu.inno.humc.monoliet.application.OpleidingService;
import nl.hu.inno.humc.monoliet.data.OpleidingRepository;
import nl.hu.inno.humc.monoliet.domain.Opleiding;
import nl.hu.inno.humc.monoliet.domain.OpleidingDetails;
import nl.hu.inno.humc.monoliet.domain.Type;
import nl.hu.inno.humc.monoliet.domain.Vak;
import nl.hu.inno.humc.monoliet.presentation.dto.OpleidingDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@SpringBootTest
public class OpleidingServiceTest {

    @InjectMocks
    private OpleidingService opleidingService;

    @Mock
    private OpleidingRepository opleidingRepository;

    private OpleidingDto testOpleidingDto;
    private Opleiding testOpleiding;

//    init/setup voor de tests
    @BeforeEach
    public void setUp() {
        OpleidingDetails details = new OpleidingDetails(
                1L,
                "Lorem ipsum",
                Type.BACHELOR,
                60L,
                "Kabul",
                "Dari"
        );

        List<Vak> vakken = Arrays.asList(
                new Vak()
        );

        testOpleidingDto = new OpleidingDto(
                1L,
                vakken,
                "Nukes",
                LocalDate.now(),
                LocalDate.now().plusYears(1),
                details
        );
        testOpleiding = new Opleiding(
                1L,
                vakken,
                "Nukes",
                LocalDate.now(),
                LocalDate.now().plusYears(1),
                details);
    }


    @Test
    public void testCreateOpleiding() {
        when(opleidingRepository.save(any(Opleiding.class))).thenReturn(testOpleiding);

        OpleidingDto result = opleidingService.createOpleiding(testOpleidingDto);

        assertNotNull(result);
        assertEquals(testOpleidingDto, result);
    }
    @Test
    public void testGetAllOpleidingen() {
        when(opleidingRepository.findAll()).thenReturn(Collections.singletonList(testOpleiding));

        List<OpleidingDto> result = opleidingService.getAllOpleidingen();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testOpleidingDto, result.get(0));
    }

    @Test
    public void testGetOpleidingById() {
        when(opleidingRepository.findById(1L)).thenReturn(Optional.of(testOpleiding));

        OpleidingDto result = opleidingService.getOpleidingById(1L);

        assertNotNull(result);
        assertEquals(testOpleidingDto, result);
    }

    @Test
    public void testUpdateOpleiding() {
        when(opleidingRepository.findById(1L)).thenReturn(Optional.of(testOpleiding));
        when(opleidingRepository.save(any(Opleiding.class))).thenReturn(testOpleiding);

        OpleidingDto updatedDto = new OpleidingDto(
                1L,
                null,
                "Nukes",
                LocalDate.now(),
                LocalDate.now().plusYears(1),
                null
        );
        OpleidingDto result = opleidingService.updateOpleiding(1L, updatedDto);

        assertNotNull(result);
        assertEquals(updatedDto, result);
    }

    @Test
    public void testDeleteOpleiding() {
        when(opleidingRepository.findById(1L)).thenReturn(Optional.of(testOpleiding));

        opleidingService.deleteOpleiding(1L);

        verify(opleidingRepository, times(1)).delete(testOpleiding);
    }
}
