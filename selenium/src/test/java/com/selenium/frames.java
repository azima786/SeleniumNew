package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frames {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "selenium/target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/droppable/");
		WebElement frame = driver.findElement(By.className("demo-frame"));
System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(frame); // 0 is default frame
WebElement drag = driver.findElement(By.id("draggable"));
WebElement drop = driver.findElement(By.id("droppable"));
Actions a = new Actions(driver);
a.dragAndDrop(drag, drop).build().perform();
driver.switchTo().defaultContent();

driver.close();



	}
}