package com.ty.di.obj;

public class Engine {

	private String type;
	private Integer cc;

	public Engine(String type, Integer cc) {
		this.type = type;
		this.cc = cc;
	}

	public String getType() {
		return type;
	}

//	public void setType(String type) {
//		this.type = type;
//	}

	public Integer getCc() {
		return cc;
	}

//	public void setCc(Integer cc) {
//		this.cc = cc;
//	}

}
