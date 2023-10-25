package nl.hu.inno.humc.student.domain.exceptions;

public class InvalidTelefoonNummerException extends IllegalArgumentException {
    public InvalidTelefoonNummerException(String message) {
        super(message);
    }
}
