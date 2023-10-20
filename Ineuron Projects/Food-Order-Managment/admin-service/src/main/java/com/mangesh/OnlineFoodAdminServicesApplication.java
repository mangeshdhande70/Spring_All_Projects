package com.mangesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OnlineFoodAdminServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodAdminServicesApplication.class, args);
	}

}
