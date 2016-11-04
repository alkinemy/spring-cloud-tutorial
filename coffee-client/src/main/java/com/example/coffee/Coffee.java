package com.example.coffee;

public class Coffee {

	public Coffee() {
	}

	public Coffee(String name) {
		this.name = name;
	}

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
