package com.ibmshop.userapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "IBM Shop - User API", version = "1", description = "User Api for IBM Shop Ecommerce Associates Project"))
@SpringBootApplication
public class UserapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserapiApplication.class, args);
	}

}