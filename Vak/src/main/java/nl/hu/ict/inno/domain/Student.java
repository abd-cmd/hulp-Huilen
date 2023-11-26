package nl.hu.ict.inno.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.Objects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    private String id;
    private String naam;

    public Student() {
    }

    public Student(String id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public String getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(naam, student.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naam);
    }
}
