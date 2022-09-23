package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class assignment6 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "selenium/target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/#");
	
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		WebElement checkBox = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]"));
		checkBox.click();
		String opt = checkBox.getText(); // You need to save variable as text to get text
	
	
		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		Select option = new Select(dropDown);
		option.selectByVisibleText(opt);

		WebElement alert = driver.findElement(By.id("name"));
		alert.sendKeys(opt);
		WebElement alertButton = driver.findElement(By.id("alertbtn"));
		alertButton.click();
		String alertText = driver.switchTo().alert().getText().split(" ")[1].trim().split(",")[0];

driver.switchTo().alert().accept();
Assert.assertEquals(opt, alertText);
	
		
driver.close();



	

		




	}
}