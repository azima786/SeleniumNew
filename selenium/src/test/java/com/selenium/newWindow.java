package com.selenium;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class newWindow {
	public static void main(String[] args) throws InterruptedException, IOException {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\azima.keshwani\\Desktop\\selenium\\selenium\\target\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
driver.switchTo().newWindow(WindowType.TAB);
Set<String> windowHandles = driver.getWindowHandles();
Iterator<String> it = windowHandles.iterator();
String parentWindow = it.next();
String childWindow = it.next();
driver.switchTo().window(childWindow);
driver.get("https://rahulshettyacademy.com/");
String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
System.out.println(courseName);

driver.switchTo().window(parentWindow);
WebElement name = driver.findElement(By.name("name"));
name.sendKeys(courseName);
File filename = name.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(filename,  new File("logo.png"));

System.out.println(name.getRect().getDimension().getHeight()); //to get height
System.out.println(name.getRect().getDimension().getWidth()); //to get widhth


driver.close();
	}
	
}