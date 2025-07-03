package com.ty.bean;

public class Address {

//	@Value(value = "India")
	private String country;

//	@Value(value = "Karnataka")
	private String state;

//	@Value(value = "69211")
	private Long zipcode;

	public void setCountry(String country) {
		this.country = country;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}

	public void display() {
		System.out.println("country : " + country);
		System.out.println("State : " + state);
		System.out.println("zipcode : " + zipcode);
	}
}
