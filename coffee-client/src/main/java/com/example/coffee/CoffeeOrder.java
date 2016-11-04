package com.example.coffee;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface CoffeeOrder {

	@Gateway(requestChannel = Source.OUTPUT)
	void order(String name);

}
