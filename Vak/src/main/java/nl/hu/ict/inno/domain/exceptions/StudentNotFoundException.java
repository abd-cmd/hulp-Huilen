package nl.hu.ict.inno.domain.exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String id) {
        super("Student niet gevonden met id: " + id);
    }

}
