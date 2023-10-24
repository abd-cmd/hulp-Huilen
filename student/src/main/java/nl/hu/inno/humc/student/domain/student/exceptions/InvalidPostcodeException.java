package nl.hu.inno.humc.student.domain.student.exceptions;

public class InvalidPostcodeException extends RuntimeException {
    public InvalidPostcodeException(String message) {
        super(message);
    }
}
