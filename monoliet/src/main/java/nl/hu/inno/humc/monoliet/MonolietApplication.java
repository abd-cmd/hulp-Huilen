package nl.hu.inno.humc.monoliet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MonolietApplication {



	public static void main(String[] args) {
		SpringApplication.run(MonolietApplication.class, args);
	}

}
