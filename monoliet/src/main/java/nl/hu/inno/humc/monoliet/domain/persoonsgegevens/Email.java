package nl.hu.inno.humc.monoliet.domain.persoonsgegevens;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String email;

    public Email(String email){
        if (email.isBlank()) throw new RuntimeException();
        if(!isEmailValide(email)) throw new RuntimeException("Inavlid email");

        this.email = email;
    }

    private boolean isEmailValide(String email){
        String regexString = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@" +
                "[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
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
