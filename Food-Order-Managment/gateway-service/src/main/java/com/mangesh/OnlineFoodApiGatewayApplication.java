package com.mangesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OnlineFoodApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodApiGatewayApplication.class, args);
	}
	
}
