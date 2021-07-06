package com.atradius.cibt.model;

import java.io.Serializable;

public class Food implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Long calories;
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
	public Long getCalories() {
		return calories;
	}
	public void setCalories(Long calories) {
		this.calories = calories;
	}
	
	

}
