package com.ty.di.obj;

import org.springframework.stereotype.Component;

@Component
public class KGF implements Movie {

	@Override
	public void story() {
		System.out.println("Stroy of KGF ==> mining mafia, power struggles, and the rise of a hero named Rocky.");
	}

}
