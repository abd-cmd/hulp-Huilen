package nl.hu.inno.humc.monoliet.domain.student.exceptions;

public class InvalidTelefoonNummerException extends IllegalArgumentException {
    public InvalidTelefoonNummerException(String message) {
        super(message);
    }
}
