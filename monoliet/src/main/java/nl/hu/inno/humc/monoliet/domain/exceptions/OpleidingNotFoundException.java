package nl.hu.inno.humc.monoliet.domain.exceptions;

public class OpleidingNotFoundException extends RuntimeException {
    
    public OpleidingNotFoundException(Long id) {
        super("Opleiding niet gevonden met id: " + id);
    }
}
