package nl.hu.inno.humc.monoliet.domain.exceptions;

public class OpleidingNietGevondenException extends RuntimeException {
    
    public OpleidingNietGevondenException(Long id) {
        super("Opleiding niet gevonden met id: " + id);
    }
}
