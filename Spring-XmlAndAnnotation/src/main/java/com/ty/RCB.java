package com.ty;

import org.springframework.stereotype.Component;

@Component(value = "myRCB")
public class RCB {

	public void play() {
		System.out.println("RCB is playing");
	}
}
