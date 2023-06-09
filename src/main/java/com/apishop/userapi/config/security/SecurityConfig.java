package com.apishop.userapi.config.security;
//package com.ibmshop.userapi.config.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http
//				.authorizeHttpRequests(
//							authrizeConfig -> {
//								authrizeConfig.requestMatchers(HttpMethod.GET, "/login").permitAll();
//								authrizeConfig.requestMatchers(HttpMethod.GET, "/logout").permitAll();
//								authrizeConfig.requestMatchers(HttpMethod.GET, "/api/usuarios/**").hasRole("ADMIN");
//								authrizeConfig.requestMatchers(HttpMethod.GET, "/api/usuarios/name/**").hasRole("ADMIN");
//								authrizeConfig.requestMatchers(HttpMethod.GET, "/api/usuarios/cpf/**").hasRole("ADMIN");
//								authrizeConfig.requestMatchers(HttpMethod.POST, "/api/usuarios").hasAnyRole("USER","ADMIN");
//								authrizeConfig.requestMatchers(HttpMethod.PUT, "/api/usuarios").hasAnyRole("USER","ADMIN");
//								authrizeConfig.requestMatchers(HttpMethod.DELETE, "/api/usuarios").hasAnyRole("USER","ADMIN");
//								authrizeConfig.anyRequest().authenticated();
//							}
//						)
//				.httpBasic().and().build();
//	}
//	@Override
//	public void configure(WebSecurity web) throws{
//		web.ignoring().requestMatchers("/v2/api-docs","configuiration/ui", "swagger-resources/**",
//		"configuration-security","/swagger-ui.html","webjars/**");
//  }	
//	
//}
