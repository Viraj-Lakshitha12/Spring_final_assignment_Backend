package lk.ijse.gdse.VehicleService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "lk.ijse.gdse.VehicleService.repository")
public class JpaConfig {
    // Configuration related to JPA repositories, if needed
}
