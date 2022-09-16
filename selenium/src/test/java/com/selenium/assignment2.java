package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class assignment2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "selenium/target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys("Azima");
		driver.findElement(By.name("email")).sendKeys("Azima@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("#123");
		driver.findElement(By.id("exampleCheck1")).click();
		Assert.assertTrue(driver.findElement(By.id("exampleCheck1")).isSelected());
		
		WebElement dropown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select option = new Select(dropown);
		option.selectByVisibleText("Female");

		driver.findElement(By.cssSelector("input[value='option1']")).click();
		driver.findElement(By.name("bday")).sendKeys("02/15/1980");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
	String submissionText = 
			driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText();
				
			Assert.assertEquals(submissionText, "Success! The Form has been submitted successfully!.");
		

	
driver.close();

	}
}