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

        // dummy data
        Opleiding opleiding = new Opleiding("HBO-ICT", LocalDate.now().minusYears(2), LocalDate.now().plusYears(2));
        new Vak("BEP2", LocalDate.now().minusDays(30), LocalDate.now().plusMonths(2), 10, opleiding);

    }

}
