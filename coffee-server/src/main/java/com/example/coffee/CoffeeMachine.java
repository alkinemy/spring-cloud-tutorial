package com.example.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint
public class CoffeeMachine {

	@Autowired
	private CoffeeRepository coffeeRepository;

	@ServiceActivator(inputChannel = Sink.INPUT)
	public void process(Message<String> name) {
		System.out.println(name);
		coffeeRepository.save(new Coffee(name.getPayload()));
	}

}
