package nl.hu.ict.inno.presentation.vakMessaging;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.presentation.dto.SendOpdrachtenToStudentDto;
import nl.hu.ict.inno.presentation.dto.SendVakToCursusDto;
import nl.hu.ict.inno.presentation.dto.SendVakToOpdracht;
import nl.hu.ict.inno.presentation.dto.StudentPuntenDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class VakProducer {

    private RabbitTemplate rabbitTemplate;

    public VakProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNieuweVak(Vak vak) {
        rabbitTemplate.convertAndSend("Add-Vak",vak);
    }

    public void sendPuntenVanVak(StudentPuntenDto studentPuntenDto) {
        rabbitTemplate.convertAndSend("sendPuntenVak",studentPuntenDto);
    }
    public void sendOpdrachtenVanVak(SendOpdrachtenToStudentDto sendOpdrachtenToStudentDto) {
        rabbitTemplate.convertAndSend("sendOpdrachtenVak",sendOpdrachtenToStudentDto);
    }

    public void sendVakToOpdracht(Vak vak) {
        SendVakToOpdracht sendVakToOpdracht = new SendVakToOpdracht(vak.getId());
        rabbitTemplate.convertAndSend("Opdracht-Vak",sendVakToOpdracht);
    }

    public void sendVakToCursus(Vak vak) {
        SendVakToCursusDto sendVakToCursusDto = new SendVakToCursusDto(vak.getNaam());
        rabbitTemplate.convertAndSend("send-Vak-Cursus",sendVakToCursusDto);
    }
}
