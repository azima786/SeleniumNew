package com.selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class lotsOfElements {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "selenium/target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String itemsNeeded[] = { "Cucumber", "Brocolli", "Beetroot", "Beans" };
		Thread.sleep(3000);
		addItems(driver, itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		String promo = driver.findElement(By.cssSelector(".promoInfo")).getText();
Assert.assertEquals(promo, "Code applied ..!");
	

	}
	
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> product = driver.findElements(By.cssSelector(".product-name"));
		int j = itemsNeeded.length;
		for (int i = 0; i < product.size(); i++) {

			List itemsNeededList = Arrays.asList(itemsNeeded);
			String[] name = product.get(i).getText().split("-");
			String formattedname = name[0].trim();
			System.out.println(formattedname);

			if (itemsNeededList.contains(formattedname)) {
				j++;
				driver.findElements(By.xpath("(//div[@class='product-action']/button)")).get(i).click();
				if (j == 3) {
					break;
				}

			}
		}
	}
}