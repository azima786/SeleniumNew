package com.selenium;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class relativeLocator {
	public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\azima.keshwani\\Desktop\\selenium\\selenium\\target\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));
WebElement dateOfBirth =driver.findElement(By.cssSelector("[for='dateofBirth']"));
WebElement iceCreamLocator =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
WebElement radioButton =driver.findElement(By.id("inlineRadio1"));


System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click(); //- Relative locator do not identify flex
driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLocator)).click(); 
System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText()); 



driver.close();
	}
	
}