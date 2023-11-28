package nl.hu.ict.inno.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.Objects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    private String id;
    private String voornaam;

    public Student() {
    }

    public Student(String id, String voornaam) {
        this.id = id;
        this.voornaam = voornaam;
    }

    public String getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setNaam(String naam) {
        this.voornaam = naam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(voornaam, student.voornaam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, voornaam);
    }
}
