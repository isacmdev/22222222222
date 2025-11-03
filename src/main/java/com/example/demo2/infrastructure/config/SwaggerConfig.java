package com.example.demo2.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${app.openapi.dev-url:http://localhost:8080}")
    private String devUrl;

    @Bean
    public OpenAPI openAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("URL del servidor en entorno de desarrollo");

        Contact contact = new Contact();
        contact.setEmail("support@example.com");
        contact.setName("Equipo de Soporte");

        License license = new License()
                .name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("API de Inventario de Productos")
                .version("1.0")
                .contact(contact)
                .description("Esta API expone endpoints para gestionar el inventario de productos. " +
                        "Permite crear, actualizar, eliminar, consultar productos y gestionar stock.")
                .license(license);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer));
    }
}
