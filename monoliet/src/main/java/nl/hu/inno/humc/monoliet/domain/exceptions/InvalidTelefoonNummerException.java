package nl.hu.inno.humc.monoliet.domain.exceptions;

public class InvalidTelefoonNummerException extends IllegalArgumentException {
    public InvalidTelefoonNummerException(String message) {
        super(message);
    }
}
