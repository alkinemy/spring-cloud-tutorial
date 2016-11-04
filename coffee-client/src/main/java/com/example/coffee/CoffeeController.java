package com.example.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CoffeeController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(path = "/names", method = RequestMethod.GET)
	public Collection<String> getNamesHATEOAS() {
		ParameterizedTypeReference<Resources<Coffee>> typeReference = new ParameterizedTypeReference<Resources<Coffee>>() {
		};
		return restTemplate.exchange("http://coffee-server/coffees", HttpMethod.GET, null, typeReference).getBody().getContent()
			.stream()
			.map(Coffee::getName)
			.collect(Collectors.toList());
	}

}