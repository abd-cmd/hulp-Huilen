package nl.hu.inno.humc.student.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.student.application.exceptions.VakBestaatNietException;
import nl.hu.inno.humc.student.data.VakRepository;
import nl.hu.inno.humc.student.domain.Opleiding;
import nl.hu.inno.humc.student.domain.Vak;
import nl.hu.inno.humc.student.messaging.outbound.VakProducer;
import nl.hu.inno.humc.student.presentation.VakController;
import nl.hu.inno.humc.student.presentation.dto.VakDto;
import nl.hu.inno.humc.student.presentation.dto.VakInschrijvingDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
public class VakService {

    private final VakRepository vakRepo;
    private final OpleidingService opleidingService;
    private final VakProducer vakProducer;
    private final VakController vakController;

    public VakService(VakRepository vakRepo, OpleidingService opleidingService, VakProducer vakProducer, VakController vakRestController) {
        this.vakRepo = vakRepo;
        this.opleidingService = opleidingService;
        this.vakProducer = vakProducer;
        this.vakController = vakRestController;
    }

    public Vak getVakById(String id) throws VakBestaatNietException {
        return vakRepo.findById(id).orElseThrow(VakBestaatNietException::new);
    }

    public void saveNewVak(VakDto vakDto) {

        // TODO Opleiding microservice koppelen aan de gehele applicatie wanneer deze beschikbaar is

        //Opleiding opleiding = opleidingService.getOpleidingById(vakDto.getOpleidingDto().getId());

        Vak vak = new Vak(
                vakDto.getId(),
                vakDto.getNaam(),
                vakDto.getBeginDatum(),
                vakDto.getEindDatum(),
                vakDto.getStudiePunten(),
                //vakDto.getOpleidingDto(),
                new Opleiding("398762346823", "HBO-ICT", LocalDate.now().minusYears(1), LocalDate.now().plusYears(1), 100),
                vakDto.getBeschikbarePlekken()
        );
        vakRepo.save(vak);
    }


    public void updateVak(VakDto vakDto) throws VakBestaatNietException {

        //Opleiding opleiding = opleidingService.getOpleidingById(vakDto.getOpleidingDto().getId());
        // Todo als opleiding (nog) niet bestaat, via REST checken of er nieuwe opleidingen zijn

        Vak vak = getVakById(vakDto.getId());

        if (!vakDto.getNaam().isEmpty()) vak.setNaam(vakDto.getNaam());
        if (vakDto.getBeginDatum() != null) vak.setBeginDatum(vakDto.getBeginDatum());
        if (vakDto.getEindDatum() != null) vak.setEindDatum(vakDto.getEindDatum());
        //vak.setOpleiding(opleiding);
        if (vakDto.getStudiePunten() >= 0) vak.setStudiePunten(vakDto.getStudiePunten());
        if (vakDto.getStudiePunten() >= 0) vak.setBeschikbarePlekken(vakDto.getBeschikbarePlekken());
        vakRepo.save(vak);
    }

    public void deleteVak(String id){

        Vak vak = vakRepo.findById(id).orElseThrow();


        vakRepo.delete(vak);
    }

    public void plaatseNieuweInschrijvingInQueue(VakInschrijvingDto dto) {
        System.out.println(dto.getVoornaam());
        this.vakProducer.sendInschrijvingToQueue(dto);
    }

    public void ManuallyUpdateVakViaRest(String id) throws VakBestaatNietException {
        updateVak(vakController.getVakById(id));
    }
}
