package com.sngcatering.sng_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SngBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SngBackendApplication.class, args);
	}

}