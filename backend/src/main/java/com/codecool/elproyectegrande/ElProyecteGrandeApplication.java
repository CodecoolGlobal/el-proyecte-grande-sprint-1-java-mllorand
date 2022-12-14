package com.codecool.elproyectegrande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ElProyecteGrandeApplication {

	private static final String REACT_HOST = "http://localhost:3000";

	public static void main(String[] args) {
		SpringApplication.run(ElProyecteGrandeApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new ReactCorsConfigurer();
	}

	public class ReactCorsConfigurer implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/dummy")
				.allowedOrigins(REACT_HOST);
		}
	}
}
