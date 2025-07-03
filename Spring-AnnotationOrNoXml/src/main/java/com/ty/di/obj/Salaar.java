package com.ty.di.obj;

import org.springframework.stereotype.Component;

@Component
//@Primary
public class Salaar implements Movie {

	@Override
	public void story() {
		System.out.println(
				"Story of Salaar ==> A tale of vengeance, power, and the quest for justice in a world of crime.");
	}

}
