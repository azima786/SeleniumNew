package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class login {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "selenium/target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String name = "rahul";
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		String homepageText = driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(homepageText, "You are successfully logged in.");
		String displayName = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		Assert.assertEquals(displayName, "Hello " + name + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();

	}

	private static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000); // Page to be displayed
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = (driver.findElement(By.cssSelector("form p")).getText());
		String[] password = passwordText.split("'");
		String actualPassword = password[1].split("'regex")[0];
		return actualPassword;
	}
	
	
}
