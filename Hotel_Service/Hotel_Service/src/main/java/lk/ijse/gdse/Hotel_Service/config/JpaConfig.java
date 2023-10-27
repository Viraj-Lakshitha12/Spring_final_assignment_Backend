package lk.ijse.gdse.Hotel_Service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "lk.ijse.gdse.Hotel_Service.repository")
public class JpaConfig {

}
