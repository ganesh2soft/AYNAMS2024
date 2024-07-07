package com.ayna.aynaconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AynaconfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AynaconfigserverApplication.class, args);
	}

}
