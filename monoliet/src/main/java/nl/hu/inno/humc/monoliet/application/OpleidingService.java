package nl.hu.inno.humc.monoliet.application;

import nl.hu.inno.humc.monoliet.data.OpleidingRepository;
import nl.hu.inno.humc.monoliet.domain.Opleiding;

import nl.hu.inno.humc.monoliet.domain.exceptions.OpleidingNietGevondenException;
import nl.hu.inno.humc.monoliet.presentation.dto.OpleidingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OpleidingService {

    private final OpleidingRepository opleidingRepository;

    public OpleidingService(OpleidingRepository opleidingRepository) {
        this.opleidingRepository = opleidingRepository;
    }

    public List<OpleidingDto> getAllOpleidingen() {
        List<Opleiding> opleidingen = opleidingRepository.findAll();
        List<OpleidingDto> opleidingDtos = new ArrayList<>();

        for (Opleiding opleiding : opleidingen) {
            OpleidingDto dto = convertToDto(opleiding);
            opleidingDtos.add(dto);
        }

        return opleidingDtos;
    }

    public OpleidingDto getOpleidingById(Long id) {
        Opleiding opleiding = opleidingRepository.findById(id)
                .orElseThrow(() -> new OpleidingNietGevondenException(id));
        return convertToDto(opleiding);
    }


    public OpleidingDto createOpleiding(OpleidingDto opleidingDto) {
        Opleiding opleiding = convertToEntity(opleidingDto);
        Opleiding savedOpleiding = opleidingRepository.save(opleiding);
        return convertToDto(savedOpleiding);
    }

    public OpleidingDto updateOpleiding(Long id, OpleidingDto opleidingDto) {
        if (!opleidingRepository.existsById(id)) {
            throw new OpleidingNietGevondenException(id);
        }
        Opleiding updatedOpleiding = convertToEntity(opleidingDto);
        updatedOpleiding.setOpleidingId(id);
        Opleiding savedOpleiding = opleidingRepository.save(updatedOpleiding);
        return convertToDto(savedOpleiding);
    }

    public void deleteOpleiding(Long id) {
        if (!opleidingRepository.existsById(id)) {
            throw new OpleidingNietGevondenException(id);
        }
        opleidingRepository.deleteById(id);
    }


    private OpleidingDto convertToDto(Opleiding opleiding) {
        return new OpleidingDto(
                opleiding.getOpleidingId(),
                opleiding.getNaam(),
                opleiding.getBeschrijving(),
                opleiding.getType(),
                opleiding.getPunten(),
                opleiding.getLocatie(),
                opleiding.getTaal(),
                opleiding.getStartDatum(),
                opleiding.getEindDatum()
        );
    }

    private Opleiding convertToEntity(OpleidingDto opleidingDto) {
        return new Opleiding(
                opleidingDto.opleidingId(),
                opleidingDto.naam(),
                opleidingDto.beschrijving(),
                opleidingDto.type(),
                opleidingDto.punten(),
                opleidingDto.locatie(),
                opleidingDto.taal(),
                opleidingDto.startDatum(),
                opleidingDto.eindDatum()
        );
    }
}
