package com.selenium;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/target/chromedriver.exe");

		//target\chromedriver.exe
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator(); //All Windows available [parent, child, subchild]
		String parentId = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		String text = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(text);
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(text);



	
	

		

driver.close();



	}
}