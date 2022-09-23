package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment7 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "selenium/target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)"); //Window scroll
		
int th=	driver.findElements(By.cssSelector(".table-display th")).size();
int tr=	driver.findElements(By.cssSelector(".table-display tr")).size();
String row3 = driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText();
System.out.println(th);
		System.out.println(tr);
		System.out.println(row3);



	}
}