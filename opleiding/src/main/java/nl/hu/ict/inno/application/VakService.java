package nl.hu.ict.inno.application;

import jakarta.transaction.Transactional;
import nl.hu.ict.inno.data.VakRepository;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.domain.exceptions.VakNotFoundException;
import nl.hu.ict.inno.presentation.controller.VakRestController;
import nl.hu.ict.inno.presentation.dto.VakDto;
import nl.hu.ict.inno.presentation.message.VakRabbitProducer;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VakService {

    private final VakRepository vakRepository;

    private final VakRabbitProducer vakRabbitProducer;

    private final VakRestController vakRestController;

    public VakService(VakRepository vakRepository, VakRabbitProducer vakRabbitProducer, VakRestController vakRestController) {
        this.vakRepository = vakRepository;
        this.vakRabbitProducer = vakRabbitProducer;
        this.vakRestController = vakRestController;
    }


    public Vak getVak(String id) throws VakNotFoundException {
        return convertToEntity(vakRestController.getVakById(id))  ;
    }

    private Vak convertToEntity(VakDto vakDto) {
        Vak vak = new Vak();
        vak.setNaam(vakDto.naam());
        vak.setBeginDatum(vakDto.beginDatum());
        vak.setEindDatum(vakDto.eindDatum());
        vak.setBeschikbarePlekken(vakDto.beschikbaarPleken());
        vak.setStudiePunten(vakDto.studiePunten());
        return vak;
    }

    private void convertToDto(Vak vak, VakDto vakDto) {
        vak.setNaam(vakDto.naam());
        vak.setBeginDatum(vakDto.beginDatum());
        vak.setEindDatum(vakDto.eindDatum());
        vak.setBeschikbarePlekken(vakDto.beschikbaarPleken());
        vak.setStudiePunten(vakDto.studiePunten());
    }


}
