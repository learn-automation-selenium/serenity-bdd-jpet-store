package com.jpetstore.utils;

public enum PetCategories {
	FISH("Fish"),
	DOGS("Dogs"),
	REPTILES("Reptiles"),
	CATS("Cats"),
	BIRDS("Birds");
	
	private String value;
	
	private PetCategories(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
