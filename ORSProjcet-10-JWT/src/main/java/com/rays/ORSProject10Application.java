package com.rays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main class for ORS Project 10 Spring Boot Application.
 * <p>
 * This class is responsible for: - Bootstrapping the Spring Boot application -
 * Configuring global CORS settings
 * </p>
 * 
 * * @author Yusuf Khan
 * @version 1.0
 */
 
@SpringBootApplication
public class ORSProject10Application {

	/**
	 * Main method to start the Spring Boot application.
	 * 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ORSProject10Application.class, args);
	}

	/**
	 * Configure Cross-Origin Resource Sharing (CORS).
	 * <p>
	 * This allows frontend applications (e.g., Angular running on localhost:4200)
	 * to access backend APIs.
	 * </p>
	 * 
	 * @return WebMvcConfigurer instance with CORS mappings
	 */
	@Bean
	public WebMvcConfigurer corsConfig() {

		return new WebMvcConfigurer() {

			/**
			 * Add CORS mappings for all endpoints.
			 * 
			 * @param registry CORS registry
			 */
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry.addMapping("/**")
				.allowedOrigins("http://localhost:4200")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
				.allowedHeaders("*")
			    .allowCredentials(true);
			}
		};
	}
}