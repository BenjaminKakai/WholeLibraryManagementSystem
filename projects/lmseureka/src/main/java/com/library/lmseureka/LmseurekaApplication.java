package com.library.lmseureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LmseurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmseurekaApplication.class, args);
	}
}
