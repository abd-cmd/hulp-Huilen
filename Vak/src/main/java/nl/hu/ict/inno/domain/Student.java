package nl.hu.ict.inno.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.Objects;

public class Student {

    private Long id;
    private String naam;

    public Student() {
    }

    public Student(Long id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
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
