package com.selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scope {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "selenium/target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

int links=		driver.findElements(By.tagName("a")).size();
WebElement footer = driver.findElement(By.id("gf-BIG"));

int footersize = footer.findElements(By.tagName("a")).size(); //limiting scope
WebElement footerDriver = driver.findElement(By.xpath("//tr/td/ul"));
int footerDrivesize = footerDriver.findElements(By.tagName("a")).size();
for (int i = 0; i < footerDrivesize; i++) {
	String clickOnText = Keys.chord(Keys.CONTROL, Keys.ENTER);
	footerDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnText);
	Thread.sleep(5000);}
Set<String> it = driver.getWindowHandles();
Iterator<String> abc = it.iterator();
	
while (abc.hasNext()) {
	driver.switchTo().window(abc.next());
	System.out.println(driver.getTitle());
}

System.out.println(footerDrivesize);
System.out.println(footersize);
System.out.println(links);
		

driver.close();


}
	}
