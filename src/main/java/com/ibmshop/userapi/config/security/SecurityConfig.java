package com.ibmshop.userapi.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(
							authrizeConfig -> {
								authrizeConfig.requestMatchers(HttpMethod.GET, "/login").permitAll();
								authrizeConfig.requestMatchers(HttpMethod.GET, "/logout").permitAll();
								authrizeConfig.anyRequest().authenticated();
								authrizeConfig.requestMatchers(HttpMethod.GET, "/ibm/usuarios/**").hasRole("ADMIN");
								authrizeConfig.requestMatchers(HttpMethod.GET, "/ibm/usuarios/name/**").hasRole("ADMIN");
								authrizeConfig.requestMatchers(HttpMethod.GET, "/ibm/usuarios/cpf/**").hasRole("ADMIN");
								authrizeConfig.requestMatchers(HttpMethod.POST, "/ibm/usuarios").hasAnyRole("USER","ADMIN");
								authrizeConfig.requestMatchers(HttpMethod.PUT, "/ibm/usuarios").hasAnyRole("USER","ADMIN");
								authrizeConfig.requestMatchers(HttpMethod.DELETE, "/ibm/usuarios").hasAnyRole("USER","ADMIN");
							}
						)
				.formLogin(Customizer.withDefaults())
				.build();
	}
	
	
	
}
