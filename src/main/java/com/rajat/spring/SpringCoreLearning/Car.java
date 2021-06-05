package com.rajat.spring.SpringCoreLearning;

public class Car {
	
	public Car(String name) {
		this.name = name;
	}

	private String name;	
	private Tyre tyre;
	
	
	public Tyre getTyre() {
		return tyre;
	}




	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public void driving() {
		System.out.println("I am a car..Vrooom...");
	}

}
