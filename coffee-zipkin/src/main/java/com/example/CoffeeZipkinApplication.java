package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class CoffeeZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeZipkinApplication.class, args);
	}
}
