package com.br.parquimetro.ParquimetroFiap.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI customOpenAPI(@Value("${application.description}") String appDescription) {

        return new OpenAPI()
                .info(new Info()
                        .title("API Parquimetro Póstech")
                        .version("v1")
                        .description(appDescription)

                );

    }
}
