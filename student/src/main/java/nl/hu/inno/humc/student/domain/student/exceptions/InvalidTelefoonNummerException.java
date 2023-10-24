package nl.hu.inno.humc.student.domain.student.exceptions;

public class InvalidTelefoonNummerException extends IllegalArgumentException {
    public InvalidTelefoonNummerException(String message) {
        super(message);
    }
}
