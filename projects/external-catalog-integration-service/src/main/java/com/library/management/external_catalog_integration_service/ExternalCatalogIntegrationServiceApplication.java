package com.library.management.external_catalog_integration_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ExternalCatalogIntegrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternalCatalogIntegrationServiceApplication.class, args);
	}
}
