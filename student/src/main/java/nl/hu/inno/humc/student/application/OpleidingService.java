package nl.hu.inno.humc.student.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.student.application.exceptions.OpleidingBestaatNietException;
import nl.hu.inno.humc.student.data.OpleidingRepository;
import nl.hu.inno.humc.student.domain.Opleiding;
import nl.hu.inno.humc.student.messaging.outbound.OpleidingProducer;
import nl.hu.inno.humc.student.presentation.dto.OpleidingInschrijvingDto;
import nl.hu.inno.humc.student.presentation.dto.OpleidingDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class OpleidingService {

    private final OpleidingRepository opleidingRepo;

    private final OpleidingProducer opleidingProducer;
    public OpleidingService(OpleidingRepository opleidingRepo, OpleidingProducer opleidingRabbitProducer) {
        this.opleidingRepo = opleidingRepo;
        this.opleidingProducer = opleidingRabbitProducer;
    }

    public Opleiding getOpleidingById(String id) {
        return opleidingRepo.findById(id).orElseThrow(OpleidingBestaatNietException::new);
    }

    public void verwerkOpleiding(OpleidingDto opleidingDto) {

        Optional<Opleiding> maybeOpleiding = opleidingRepo.findById(opleidingDto.getId());

        if (maybeOpleiding.isEmpty()) {
            Opleiding opleiding = new Opleiding(
                    opleidingDto.getId(),
                    opleidingDto.getNaam(),
                    opleidingDto.getStartDatum(),
                    opleidingDto.getEindDatum(),
                    opleidingDto.getBeschikbarePlekken()
            );
            opleidingRepo.save(opleiding);
        } else {
            Opleiding opleiding = maybeOpleiding.get();
            opleiding.setNaam(opleidingDto.getNaam());
            opleiding.setStartDatum(opleidingDto.getStartDatum());
            opleiding.setEindDatum(opleidingDto.getEindDatum());
        }
    }

    public void plaatsNieuweInschrijvingInQueue(OpleidingInschrijvingDto inschrijvingDto) {
        this.opleidingProducer.newInschrijving(inschrijvingDto);
    }
}
