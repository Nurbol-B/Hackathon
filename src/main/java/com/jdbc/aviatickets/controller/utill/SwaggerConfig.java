package com.jdbc.aviatickets.controller.utill;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI configure(){
        return new OpenAPI()
                .info(new Info()
                        .title("AviaTickets")
                        .description("Сервис для покупки авиабилетов")
                        .version("1.0.0")
                        .contact(new Contact().name("nurbol")
                                .email("nurbol@gmail.com"))
                );
    }
}
