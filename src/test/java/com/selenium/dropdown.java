package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dropdown {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "selenium/target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //pause until page is fully loaded
		
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		WebElement passengerList = driver.findElement(By.id("divpaxinfo"));
		passengerList.click();
		Thread.sleep(2000);
		int n = 1;
		while(n<4) {
			driver.findElement(By.id("hrefIncAdt")).click();
			n++;
			
		}
		System.out.println(passengerList.getText());
		Assert.assertEquals(passengerList.getText(), "4 Adult");
		Thread.sleep(2000);
		driver.findElement(By.id("btnclosepaxoption")).click();
	
		Select dropdown = new Select(staticDropDown); //static if it says select
		dropdown.selectByIndex(3);
System.out.println(dropdown.getFirstSelectedOption().getText());		
dropdown.selectByVisibleText("AED");
System.out.println(dropdown.getFirstSelectedOption().getText());
dropdown.selectByValue("INR");
	System.out.println(dropdown.getFirstSelectedOption().getText());


	
	
driver.close();
		
	}
		
}
