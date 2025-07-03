package com.ty.di.obj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Theatre {

	@Autowired
	private Movie movie;

	@Value(value = "PVR")
	private String name;

	@Value(value = "Bangalore")
	private String address;

//	@Autowired
//	@Qualifier(value = "KGF")
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Autowired
	public Theatre(@Qualifier(value = "salaar") Movie movie) {
		this.movie = movie;
	}

	public void display() {
		System.out.println("Theatre Name: " + name);
		System.out.println("Address: " + address);
		if (movie != null) {
			movie.story();
		} else {
			System.out.println("No movie is currently showing.");
		}
	}

}
