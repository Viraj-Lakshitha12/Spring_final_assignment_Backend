package lk.ijse.gdse.Guide_Service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "lk.ijse.gdse.Guide_Service.repository")
public class JpaConfig {

}
