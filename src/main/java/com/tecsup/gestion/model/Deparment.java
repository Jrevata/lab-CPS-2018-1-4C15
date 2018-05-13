package com.tecsup.gestion.model;

public class Deparment {

	Integer deparement_id;
	String name;
	String description;
	String city;
	
	public Deparment(Integer deparement_id, String name, String description, String city) {
		super();
		this.deparement_id = deparement_id;
		this.name = name;
		this.description = description;
		this.city = city;
	}
	
	public Deparment() {}

	public Integer getDeparement_id() {
		return deparement_id;
	}

	public void setDeparement_id(Integer deparement_id) {
		this.deparement_id = deparement_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Deparment [deparement_id=" + deparement_id + ", name=" + name + ", description=" + description
				+ ", city=" + city + "]";
	}
	
	
	
	
	
}
