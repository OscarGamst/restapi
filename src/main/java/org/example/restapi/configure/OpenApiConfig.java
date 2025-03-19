package org.example.restapi.configure;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.*;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Workout API")
                        .version("1.0")
                        .description("API for managing Activities such as workouts and run, and users")
                        .contact(new Contact()
                                .name("Application Admin")
                                .email("admin@admin.com"))
                );
    }
}