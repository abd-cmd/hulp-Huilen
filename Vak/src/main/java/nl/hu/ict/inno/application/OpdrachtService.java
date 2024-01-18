package nl.hu.ict.inno.application;

import jakarta.transaction.Transactional;
import nl.hu.ict.inno.data.OpdrachtRepository;
import nl.hu.ict.inno.domain.Opdracht;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.presentation.dto.ReciveOpdrachtDto;
import nl.hu.ict.inno.presentation.dto.SendOpdrachtenToStudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OpdrachtService implements OpdrachtInterface{

    private VakInterface vakInterface;
    private OpdrachtRepository opdrachtRepository;

    public OpdrachtService( VakInterface vakInterface, OpdrachtRepository opdrachtRepository) {

        this.vakInterface = vakInterface;
        this.opdrachtRepository = opdrachtRepository;
    }

    @Override
    public void AddOpdrachtToHerkansing(ReciveOpdrachtDto reciveOpdrachtDto) {

        Vak findVak = vakInterface.findById(reciveOpdrachtDto.getVakId());

        Opdracht opdracht = new Opdracht(reciveOpdrachtDto.getVakId(),String.valueOf(reciveOpdrachtDto.getId()),
                reciveOpdrachtDto.getInleverdatum(),
                reciveOpdrachtDto.getBeschrijving(), reciveOpdrachtDto.getTeBehalenPunten());

        if(findVak.getHerkansingGegevens().getherkansingPunten() != opdracht.getTeBehalenPunten()) {
            opdracht.setTeBehalenPunten(findVak.getHerkansingGegevens().getherkansingPunten());

            opdrachtRepository.save(opdracht);
        }else {
            opdrachtRepository.save(opdracht);
        }
    }


}
