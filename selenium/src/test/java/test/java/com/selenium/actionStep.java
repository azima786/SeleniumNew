package test.java.com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionStep {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "selenium/target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");

		Actions a = new Actions(driver);
			WebElement target = driver.findElement(By.id("nav-link-accountList"));
			a.moveToElement(target).build().perform(); //Move to specific element
			a.moveToElement(target).contextClick(); //right click on element
		
			WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
			a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		a.moveToElement(search).doubleClick().build().perform();
		a.moveToElement(search).clickAndHold().build().perform();
	

		

driver.close();



	}
}