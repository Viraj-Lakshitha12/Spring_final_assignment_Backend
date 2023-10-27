package lk.ijse.gdse.MainTravelService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MainTravelServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainTravelServiceApplication.class, args);
	}
}
