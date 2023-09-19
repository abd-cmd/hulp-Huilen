package nl.hu.inno.humc.monoliet.domain.persoonsgegevens;

import nl.hu.inno.humc.monoliet.domain.exceptions.InvalidEmailException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String email;

    protected Email(){}

    public Email(String email){
        if (email.isBlank()) throw new IllegalArgumentException("E-mailadres mag niet leeg zijn");
        if(!isEmailValide(email)) throw new InvalidEmailException("Ongeldig e-mailadres: " + email);

        this.email = email;
    }

    private boolean isEmailValide(String email){
        String regexString = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern regex = Pattern.compile(regexString);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
