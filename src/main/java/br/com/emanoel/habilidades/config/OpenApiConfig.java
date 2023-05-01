package br.com.emanoel.habilidades.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("REST-FULL API WITH JAVA 16 AND SPRING BOOT 3").
				version("v1").
				description("").
				termsOfService("").
				license(new License().
						name("Apache 2.0").url("https://www.linkedin.com/in/emanoel-galv%C3%A3o-da-silva-5955811b3/")
						));
	}
}
