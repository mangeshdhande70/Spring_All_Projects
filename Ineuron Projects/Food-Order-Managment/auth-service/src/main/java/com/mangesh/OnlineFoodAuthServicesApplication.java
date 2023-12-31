package com.mangesh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
public class OnlineFoodAuthServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodAuthServicesApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Value("${allowed.origins}")
			private String allowedOrigins;

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(allowedOrigins.trim().split(",")).allowCredentials(true)
						.allowedMethods("GET","POST","PUT", "OPTIONS");
			}
		};
	}

}
