package com.ayna.aynaserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AynaserviceregistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AynaserviceregistryApplication.class, args);
	}

}
