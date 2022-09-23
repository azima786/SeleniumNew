package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "selenium/target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://google.com"); //pause until page is fully loaded
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/"); //will not wait
		driver.navigate().back();
driver.navigate().forward();


	
	
driver.close();
		
	}
		
}
