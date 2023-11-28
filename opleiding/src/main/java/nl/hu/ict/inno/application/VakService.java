package nl.hu.ict.inno.application;

import jakarta.transaction.Transactional;
import nl.hu.ict.inno.data.VakRepository;
import nl.hu.ict.inno.presentation.controller.VakRestController;
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





}
