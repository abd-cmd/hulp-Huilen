package nl.hu.inno.humc.student.application;

import nl.hu.inno.humc.student.presentation.dto.VakDto;

public interface VakClient {
    VakDto getVakById(String id);
}
