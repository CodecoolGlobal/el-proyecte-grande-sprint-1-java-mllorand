package com.codecool.elproyectegrande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@SpringBootApplication
public class ElProyecteGrandeApplication {

	private static final String REACT_HOST = "http://localhost:3000";
	private static final String POSTMAN_HOST = "https://codecrush.postman.co";
	private static final String[] CORS_ENDPOINTS = {
		"/profile",
		"/profile/**"
	};

	public static void main(String[] args) {
		SpringApplication.run(ElProyecteGrandeApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				Arrays.stream(CORS_ENDPOINTS)
					.forEach(endpoint -> registry.addMapping(endpoint)
						.allowedOrigins(REACT_HOST)
						.allowedOrigins(POSTMAN_HOST));
			}
		};
	}
}
