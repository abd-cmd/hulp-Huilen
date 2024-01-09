package nl.hu.inno.humc.student.messaging.outbound;

import nl.hu.inno.humc.student.presentation.dto.OpleidingInschrijvingDto;

public interface OpleidingProducer {
    void newInschrijving(OpleidingInschrijvingDto inschrijvingDto);
}
