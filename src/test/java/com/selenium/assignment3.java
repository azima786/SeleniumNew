package com.selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment3 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "selenium/target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(options);
		dropdown.selectByValue("consult");

		driver.findElement(By.id("signInBtn")).click();
String[] itemList = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };
		addPhone(driver, itemList);
		driver.findElement(By.className("btn-primary")).click();
		driver.findElement(By.className("btn-success")).click();

		
	}

	public static void addPhone(WebDriver driver, String[] itemList) {
	
	//List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-footer']/button"));
		List<WebElement> product = driver.findElements(By.xpath("//h4[@class='card-title']"));
		for (int i = 0; i < product.size(); i++) {
			List itemsNeededList = Arrays.asList(itemList);
			String name = product.get(i).getText();
			System.out.println(itemsNeededList);
			System.out.println(name);
			if (itemsNeededList.contains(name)) {
				//List<WebElement> productsNeeded = driver.findElements(By.xpath("//div[@class='card-footer']/button"));
driver.findElements(By.cssSelector(".card-footer .btn-info")).get(i).click();
//				product.get(i).click();

			}

		}
	}
}

