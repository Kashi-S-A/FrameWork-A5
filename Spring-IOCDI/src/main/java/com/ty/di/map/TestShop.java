package com.ty.di.map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestShop {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("config5.xml");
		Shop shop = (Shop) app.getBean("myShop");
		shop.displayShopInfo();
	}
}
