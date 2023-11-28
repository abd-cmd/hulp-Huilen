package nl.hu.ict.inno.domain.exceptions;

public class OpleidingNotFoundException extends RuntimeException {
    
    public OpleidingNotFoundException(String id) {
        super("Opleiding niet gevonden met id: " + id);
    }
}
