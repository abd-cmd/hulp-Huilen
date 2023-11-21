package nl.hu.inno.humc.student.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.student.application.exceptions.VakBestaatNietException;
import nl.hu.inno.humc.student.data.VakRepository;
import nl.hu.inno.humc.student.domain.Opleiding;
import nl.hu.inno.humc.student.domain.Vak;
import nl.hu.inno.humc.student.presentation.dto.VakDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class VakService {

    private final VakRepository vakRepo;
    private final OpleidingService opleidingService;

    public VakService(VakRepository vakRepo, OpleidingService opleidingService) {
        this.vakRepo = vakRepo;
        this.opleidingService = opleidingService;
    }

    public Optional<Vak> getVakById(String id) {
        return vakRepo.findById(id);
    }

    public void saveNewVak(VakDto vakDto) {

        Opleiding opleiding = opleidingService.getOpleidingById(vakDto.getOpleidingDto().getId());

        Vak vak = new Vak(
                vakDto.getId(),
                vakDto.getNaam(),
                vakDto.getBeginDatum(),
                vakDto.getEindDatum(),
                vakDto.getStudiePunten(),
                opleiding,
                vakDto.getBeschikbarePlekken()
        );
        vakRepo.save(vak);
    }


    public void updateVak(VakDto vakDto) throws VakBestaatNietException {

        Opleiding opleiding = opleidingService.getOpleidingById(vakDto.getOpleidingDto().getId());
        // Todo als opleiding (nog) niet bestaat, via REST checken of er nieuwe opleidingen zijn

        Optional<Vak> maybeVak = vakRepo.findById(vakDto.getId());

        if (maybeVak.isEmpty()) throw new VakBestaatNietException();

        Vak vak = maybeVak.get();
        vak.setNaam(vakDto.getNaam());
        vak.setBeginDatum(vakDto.getBeginDatum());
        vak.setEindDatum(vakDto.getEindDatum());
        vak.setOpleiding(opleiding);
        vakRepo.save(vak);
    }

    public void deleteVak(VakDto vakDto){

        Vak vak = vakRepo.findById(vakDto.getId()).orElseThrow();


        vakRepo.delete(vak);
    }
}
