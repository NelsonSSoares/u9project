package com.apishop.userapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI baseOpenAPI() {
		return new OpenAPI().info(new Info().title("Shop - User API").version("1.0.0").description("User Api for Shop Ecommerce"));
				
	}
}
