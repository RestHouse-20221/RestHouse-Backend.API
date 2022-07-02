package com.rest.resthouse.shared.configuration.configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name = "resthouseOpenApi")
    public OpenAPI resthouseOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("RestHouse Application API")
                        .description("RestHouse API implemented with Spring Boot RESTful service and documented using springdoc-openapi"));
    }

}
