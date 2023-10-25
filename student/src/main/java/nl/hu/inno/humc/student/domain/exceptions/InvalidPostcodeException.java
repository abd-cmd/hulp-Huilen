package nl.hu.inno.humc.student.domain.exceptions;

public class InvalidPostcodeException extends RuntimeException {
    public InvalidPostcodeException(String message) {
        super(message);
    }
}
