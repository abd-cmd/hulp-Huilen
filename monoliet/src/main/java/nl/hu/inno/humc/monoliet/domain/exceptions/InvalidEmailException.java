package nl.hu.inno.humc.monoliet.domain.exceptions;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException(String message) {
        super(message);
    }
}
