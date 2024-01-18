package nl.hu.inno.humc.student.messaging.outbound;

import nl.hu.inno.humc.student.presentation.dto.VakInschrijvingDto;

public interface VakProducer {
    void sendInschrijvingToQueue(VakInschrijvingDto vakInschrijvingDto);
}
