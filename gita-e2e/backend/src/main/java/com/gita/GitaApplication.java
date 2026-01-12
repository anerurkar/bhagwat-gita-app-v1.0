package com.gita;

import org.springframework.boot.SpringApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@OpenAPIDefinition(
    servers = {
        @Server(url = "http://localhost:8080", description = "Local"),
        @Server(
            url = "https://kshna-svc-100157816972.asia-south1.run.app",
            description = "Cloud Run"
        )
    }
)
public class GitaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitaApplication.class, args);
    }

	/*
	 * @Bean public WebMvcConfigurer corsConfigurer() { return new
	 * WebMvcConfigurer() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**") .allowedOrigins("http://localhost:4200","")
	 * .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); } }; }
	 */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
						    "http://localhost:3000",
                            "http://localhost:4200",
                            "https://kshna-svc-100157816972.asia-south1.run.app",
							"https://*.web.app",
							"https://gita-app-483814.web.app",
                            "https://*.firebaseapp.com"
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
    
}
