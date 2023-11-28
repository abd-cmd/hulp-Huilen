package nl.hu.ict.inno.application.execptions;

public class VakNotFoundException extends RuntimeException{
    public VakNotFoundException(String id) {
        super("Vak niet gevonden met id: " + id);
    }
}
