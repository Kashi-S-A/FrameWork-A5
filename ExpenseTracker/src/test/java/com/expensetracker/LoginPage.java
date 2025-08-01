package com.expensetracker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/");
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Dinga");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Expense List")).click();

	}

}
