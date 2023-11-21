package nl.hu.ict.inno.presentation.controller.messaging;

import nl.hu.ict.inno.domain.Vak;

public record SharedMessage(Vak vak, int priority) {
}
