package nl.hu.ict.inno.application;

import jakarta.transaction.Transactional;
import nl.hu.ict.inno.application.execptions.VakNotFoundException;
import nl.hu.ict.inno.data.OpleidingRepository;
import nl.hu.ict.inno.data.VakRepository;
import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.domain.exceptions.OpleidingNotFoundException;
import nl.hu.ict.inno.presentation.controller.VakRestController;
import nl.hu.ict.inno.presentation.dto.OpleidingDto;
import nl.hu.ict.inno.presentation.message.OpleidingRabbitProducer;
import nl.hu.ict.inno.presentation.message.VakRabbitProducer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OpleidingService {

    private final OpleidingRepository opleidingRepository;

    private final OpleidingRabbitProducer opleidingRabbitProducer;
    private final VakRepository vakRepository;

    private final VakService vakService;

    public OpleidingService(OpleidingRepository opleidingRepository, OpleidingRabbitProducer opleidingRabbitProducer, VakRepository vakRepository, VakService vakService) {
        this.opleidingRepository = opleidingRepository;
        this.opleidingRabbitProducer = opleidingRabbitProducer;
        this.vakRepository = vakRepository;
        this.vakService = vakService;
    }

    public List<OpleidingDto> getAllOpleidingen() {
        List<Opleiding> opleidingen = (List<Opleiding>) opleidingRepository.findAll();
        List<OpleidingDto> opleidingDtos = new ArrayList<>();

        for (Opleiding opleiding : opleidingen) {
            OpleidingDto dto = convertToDto(opleiding);
            opleidingDtos.add(dto);
        }

        return opleidingDtos;
    }

    public OpleidingDto getOpleidingById(String id) {
        Opleiding opleiding = opleidingRepository.findById(id)
                .orElseThrow(() -> new OpleidingNotFoundException(id));
        return convertToDto(opleiding);
    }

    public Opleiding getOpleidingEntityById(String id) {
        return opleidingRepository.findById(id)
                .orElseThrow(() -> new OpleidingNotFoundException(id));
    }


    public OpleidingDto createOpleiding(OpleidingDto opleidingDto) {
        Opleiding opleiding = convertToEntity(opleidingDto);
        Opleiding savedOpleiding = opleidingRepository.save(opleiding);

        opleidingRabbitProducer.sendNewOpleidingToQueue(opleidingDto);
        return convertToDto(savedOpleiding);
    }

    public OpleidingDto updateOpleiding(String id, OpleidingDto opleidingDto) {
        if (!opleidingRepository.existsById(id)) {
            throw new OpleidingNotFoundException(id);
        }
        Opleiding updatedOpleiding = convertToEntity(opleidingDto);
        updatedOpleiding.setOpleidingId(id);
        Opleiding savedOpleiding = opleidingRepository.save(updatedOpleiding);
        opleidingRabbitProducer.sendUpdatedOpleidingToQueue(opleidingDto);

        return convertToDto(savedOpleiding);
    }

    public void deleteOpleiding(String opleidingId) {
        if (!opleidingRepository.existsById(opleidingId)) {
            throw new OpleidingNotFoundException(opleidingId);
        }
        Opleiding opleiding = opleidingRepository.findById(opleidingId)
                .orElseThrow(() -> new OpleidingNotFoundException(opleidingId));

        OpleidingDto opleidingDto = convertToDto(opleiding);
        opleidingRabbitProducer.sendDeletedOpleidingToQueue(opleidingDto);

        opleidingRepository.deleteById(opleidingId);
    }

    public OpleidingDto addVakToOpleiding(String opleidingId, String vakId) {

        Opleiding opleiding = opleidingRepository.findById(opleidingId)
                .orElseThrow(() -> new OpleidingNotFoundException(opleidingId));

        Vak vak;
        try {
            vak = vakRepository.findById(vakId)
                    .orElseThrow(() -> new VakNotFoundException(vakId));
        } catch (VakNotFoundException e) {
            vak = vakService.getVak(vakId);
        }

        opleiding.getVakken().add(vak);
        vakRepository.save(vak);
        opleidingRepository.save(opleiding);
        OpleidingDto opleidingDto = convertToDto(opleiding);
        opleidingRabbitProducer.sendUpdatedOpleidingToQueue(opleidingDto);
        return opleidingDto;
    }

    public Opleiding findOpleidingById(String id) {
        Opleiding opleiding = opleidingRepository.findById(id)
                .orElseThrow(() -> new OpleidingNotFoundException(id));
        return opleiding;
    }

    public OpleidingDto removeVakFromOpleiding(String opleidingId, String vakId) {
        Opleiding opleiding = opleidingRepository.findById(opleidingId)
                .orElseThrow(() -> new OpleidingNotFoundException(opleidingId));

        Vak vak = vakRepository.findById(vakId)
                .orElseThrow(() -> new VakNotFoundException(vakId));

        opleiding.getVakken().remove(vak);
        OpleidingDto opleidingDto = convertToDto(opleiding);
        opleidingRabbitProducer.sendUpdatedOpleidingToQueue(opleidingDto);
        return opleidingDto;
    }

    public Vak getVakFromOpleiding(String opleidingId, String vakId) {
        Opleiding opleiding = opleidingRepository.findById(opleidingId)
                .orElseThrow(() -> new OpleidingNotFoundException(opleidingId));

        return opleiding.getVak(vakId);

    }

    public List<Vak> getVakkenFromOpleiding(String opleidingId) {

        Opleiding opleiding = opleidingRepository.findById(opleidingId)
                .orElseThrow(() -> new OpleidingNotFoundException(opleidingId));

        List<Vak> vakken = opleiding.getVakken();

        return vakken;

    }

    private OpleidingDto convertToDto(Opleiding opleiding) {
        return new OpleidingDto(
                opleiding.getOpleidingId(),
                opleiding.getVakken(),
                opleiding.getNaam(),
                opleiding.getPeriode(),
                opleiding.getInschrijfDatum(),
                opleiding.getOpleidingDetails()
        );
    }

    private Opleiding convertToEntity(OpleidingDto opleidingDto) {
        return new Opleiding(
                opleidingDto.opleidingId(),
                opleidingDto.vakken(),
                opleidingDto.naam(),
                opleidingDto.periode(),
                opleidingDto.inschrijfDatum(),
                opleidingDto.opleidingDetails()
        );
    }

}
