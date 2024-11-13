package config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaRepositories(basePackages = "empleados.repository")
@EntityScan(basePackages = "empleados.model")
public class AppConfigu {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
