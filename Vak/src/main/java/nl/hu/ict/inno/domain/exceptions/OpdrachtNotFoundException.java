package nl.hu.ict.inno.domain.exceptions;

public class OpdrachtNotFoundException extends RuntimeException{
    public OpdrachtNotFoundException(String id) {
        super("opdracht niet gevonden met id: " + id);
    }

}
