package lk.ijse.gdse.Guide_Service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Specify the allowed origin(s) for your front-end application
        config.addAllowedOrigin("http://localhost:63342");

        // Allow all HTTP methods (GET, POST, etc.)
        config.addAllowedMethod("*");

        // Allow all headers
        config.addAllowedHeader("*");

        // Expose custom headers if needed
        // config.addExposedHeader("headerName");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
