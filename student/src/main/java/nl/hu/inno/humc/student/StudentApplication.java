package nl.hu.inno.humc.student;

import nl.hu.inno.humc.student.domain.Opleiding;
import nl.hu.inno.humc.student.domain.Vak;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);

    }
}
