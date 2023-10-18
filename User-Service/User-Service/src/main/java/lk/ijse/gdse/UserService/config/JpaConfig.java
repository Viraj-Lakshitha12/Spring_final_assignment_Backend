package lk.ijse.gdse.UserService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "lk.ijse.gdse.UserService.repository")
public class JpaConfig {
    // Configuration related to JPA repositories, if needed
}
