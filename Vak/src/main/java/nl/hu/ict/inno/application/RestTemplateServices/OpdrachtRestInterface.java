package nl.hu.ict.inno.application.RestTemplateServices;

import nl.hu.ict.inno.domain.Opdracht;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.presentation.dto.SendVakToOpdracht;

public interface OpdrachtRestInterface {

    public Opdracht SendVakToOpdracht(Vak vak);
}
