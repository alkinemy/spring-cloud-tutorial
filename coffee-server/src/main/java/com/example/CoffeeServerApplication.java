package com.example;

import com.example.coffee.Coffee;
import com.example.coffee.CoffeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@EnableBinding(Sink.class)
@EnableDiscoveryClient
@SpringBootApplication
public class CoffeeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner dummyCommandLineRunner(CoffeeRepository coffeeRepository) {
		return args -> Stream.of("Americano", "Mocha")
			.forEach(name -> coffeeRepository.save(new Coffee(name)));
	}

}
