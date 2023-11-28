package nl.hu.inno.humc.student.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.student.application.exceptions.VakBestaatNietException;
import nl.hu.inno.humc.student.data.VakRepository;
import nl.hu.inno.humc.student.domain.Opleiding;
import nl.hu.inno.humc.student.domain.Vak;
import nl.hu.inno.humc.student.presentation.VakRabbitProducer;
import nl.hu.inno.humc.student.presentation.VakRestController;
import nl.hu.inno.humc.student.presentation.dto.VakDto;
import nl.hu.inno.humc.student.presentation.dto.VakInschrijvingDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class VakService {

    private final VakRepository vakRepo;
    private final OpleidingService opleidingService;
    private final VakRabbitProducer vakRabbitProducer;
    private final VakRestController vakRestController;

    public VakService(VakRepository vakRepo, OpleidingService opleidingService, VakRabbitProducer vakRabbitProducer, VakRestController vakRestController) {
        this.vakRepo = vakRepo;
        this.opleidingService = opleidingService;
        this.vakRabbitProducer = vakRabbitProducer;
        this.vakRestController = vakRestController;
    }

    public Vak getVakById(String id) throws VakBestaatNietException {
        return vakRepo.findById(id).orElseThrow(VakBestaatNietException::new);
    }

    public void saveNewVak(VakDto vakDto) {

        //Opleiding opleiding = opleidingService.getOpleidingById(vakDto.getOpleidingDto().getId());

        Vak vak = new Vak(
                vakDto.getId(),
                vakDto.getNaam(),
                vakDto.getBeginDatum(),
                vakDto.getEindDatum(),
                vakDto.getStudiePunten(),
                //opleiding
                null,
                vakDto.getBeschikbarePlekken()
        );
        vakRepo.save(vak);
    }


    public void updateVak(VakDto vakDto) throws VakBestaatNietException {

        //Opleiding opleiding = opleidingService.getOpleidingById(vakDto.getOpleidingDto().getId());
        // Todo als opleiding (nog) niet bestaat, via REST checken of er nieuwe opleidingen zijn

        Vak vak = getVakById(vakDto.getId());

        vak.setNaam(vakDto.getNaam());
        vak.setBeginDatum(vakDto.getBeginDatum());
        vak.setEindDatum(vakDto.getEindDatum());
        //vak.setOpleiding(opleiding);
        vak.setStudiePunten(vakDto.getStudiePunten());
        vak.setBeschikbarePlekken(vakDto.getBeschikbarePlekken());
        vakRepo.save(vak);
    }

    public void deleteVak(VakDto vakDto){

        Vak vak = vakRepo.findById(vakDto.getId()).orElseThrow();


        vakRepo.delete(vak);
    }

    public void plaatseNieuweInschrijvingInQueue(VakInschrijvingDto dto) {
        System.out.println(dto.getVoornaam());
        this.vakRabbitProducer.sendInschrijvingToQueue(dto);
    }

    public void ManuallyUpdateVakViaRest(String id) throws VakBestaatNietException {
        updateVak(vakRestController.getVakById(id));
    }
}
