package com.example.coffee;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("coffee-server")
public interface CoffeeClient {

	@RequestMapping(path = "/coffees", method = RequestMethod.GET)
	Resources<Coffee> getCoffees();

}
