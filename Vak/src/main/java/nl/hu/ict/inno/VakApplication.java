package nl.hu.ict.inno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "nl.hu.ict.inno.*")
public class VakApplication {
	public static void main(String[] args) {
		SpringApplication.run(VakApplication.class, args);
	}
}
