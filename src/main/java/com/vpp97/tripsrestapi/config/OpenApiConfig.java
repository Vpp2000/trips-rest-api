package com.vpp97.tripsrestapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        servers = {@Server(url = "/", description = "Default Server URL")},
        info = @Info(
                title = "Trips API",
                version = "1.0",
                description = "Documentation for endpoints in Trips API")
)
public class OpenApiConfig {
}
