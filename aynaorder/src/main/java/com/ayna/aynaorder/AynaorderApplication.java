package com.ayna.aynaorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AynaorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AynaorderApplication.class, args);
	}

}
