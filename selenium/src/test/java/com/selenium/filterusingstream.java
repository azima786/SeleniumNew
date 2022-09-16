package com.selenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class filterusingstream {
	public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\azima.keshwani\\Desktop\\selenium\\selenium\\target\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
driver.findElement(By.id("search-field")).sendKeys("Rice");
List<WebElement> Veggies = driver.findElements(By.xpath("//tr/td[1]"));
List <WebElement> filteredListVeggies = Veggies.stream().filter(veggie-> veggie.getText().contains("Rice")).collect(Collectors.toList());

Assert.assertTrue(Veggies.equals(filteredListVeggies));
Assert.assertEquals(Veggies.size(), filteredListVeggies.size());

driver.close();
	}
	
}