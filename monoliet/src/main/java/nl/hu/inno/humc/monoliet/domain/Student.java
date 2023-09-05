package nl.hu.inno.humc.monoliet.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    public Student(){}

    public Long getId() {
        return id;
    }
}
