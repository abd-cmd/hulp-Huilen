package nl.hu.inno.humc.monoliet.application;

import jakarta.transaction.Transactional;
import nl.hu.inno.humc.monoliet.data.OpleidingRepository;
import nl.hu.inno.humc.monoliet.data.VakRepository;
import nl.hu.inno.humc.monoliet.domain.opleiding.Opleiding;

import nl.hu.inno.humc.monoliet.domain.vak.Vak;
import nl.hu.inno.humc.monoliet.domain.exceptions.OpleidingNotFoundException;
import nl.hu.inno.humc.monoliet.domain.exceptions.VakNotFoundException;
import nl.hu.inno.humc.monoliet.presentation.dto.OpleidingDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OpleidingService {

    private final OpleidingRepository opleidingRepository;
    private VakRepository vakRepository;

    public OpleidingService(OpleidingRepository opleidingRepository, VakRepository vakRepository) {
        this.opleidingRepository = opleidingRepository;
        this.vakRepository = vakRepository;
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
                .orElseThrow(() -> new OpleidingNotFoundException(id));
        return convertToDto(opleiding);
    }

    public Opleiding getOpleidingEntityById(Long id) {
        return opleidingRepository.findById(id)
                .orElseThrow(() -> new OpleidingNotFoundException(id));
    }


    public OpleidingDto createOpleiding(OpleidingDto opleidingDto) {
        Opleiding opleiding = convertToEntity(opleidingDto);
        Opleiding savedOpleiding = opleidingRepository.save(opleiding);
        return convertToDto(savedOpleiding);
    }

    public OpleidingDto updateOpleiding(Long id, OpleidingDto opleidingDto) {
        if (!opleidingRepository.existsById(id)) {
            throw new OpleidingNotFoundException(id);
        }
        Opleiding updatedOpleiding = convertToEntity(opleidingDto);
        updatedOpleiding.setOpleidingId(id);
        Opleiding savedOpleiding = opleidingRepository.save(updatedOpleiding);
        return convertToDto(savedOpleiding);
    }

    public void deleteOpleiding(Long id) {
        if (!opleidingRepository.existsById(id)) {
            throw new OpleidingNotFoundException(id);
        }
        opleidingRepository.deleteById(id);
    }

    public OpleidingDto addVakToOpleiding(Long opleidingId, Vak vak) {
        Opleiding opleiding = opleidingRepository.findById(opleidingId)
                .orElseThrow(() -> new OpleidingNotFoundException(opleidingId));

        opleiding.getVakken().add(vak);
        opleidingRepository.save(opleiding);

        return convertToDto(opleiding);
    }

    public Opleiding findOpleidingById(Long id) {
        Opleiding opleiding = opleidingRepository.findById(id)
                .orElseThrow(() -> new OpleidingNotFoundException(id));
        return opleiding;
    }

    public OpleidingDto removeVakFromOpleiding(Long opleidingId, Long vakId) {
        Opleiding opleiding = opleidingRepository.findById(opleidingId)
                .orElseThrow(() -> new OpleidingNotFoundException(opleidingId));

        Vak vak = vakRepository.findById(vakId)
                .orElseThrow(() -> new VakNotFoundException());

        opleiding.getVakken().remove(vak);

        return convertToDto(opleiding);
    }

    private OpleidingDto convertToDto(Opleiding opleiding) {
        return new OpleidingDto(
                opleiding.getOpleidingId(),
                opleiding.getVakken(),
                opleiding.getNaam(),
                opleiding.getStartDatum(),
                opleiding.getEindDatum(),
                opleiding.getOpleidingDetails()
        );
    }

    private Opleiding convertToEntity(OpleidingDto opleidingDto) {
        return new Opleiding(
                opleidingDto.opleidingId(),
                opleidingDto.vakken(),
                opleidingDto.naam(),
                opleidingDto.startDatum(),
                opleidingDto.eindDatum(),
                opleidingDto.opleidingDetails()
        );
    }
}
