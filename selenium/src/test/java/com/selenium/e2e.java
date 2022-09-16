package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "selenium/target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
		// driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']
		// //a[@value='BLR']")).click();
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

				driver.findElement(By.cssSelector(".ui-state-highlight")).click();

				boolean contain = (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"));
		if (contain) {
			System.out.println(
					"its disabled");
			Assert.assertTrue(true);
		} else {
			System.out.println("its enabled");
			Assert.assertTrue(false);
		}

		WebElement passengerList = driver.findElement(By.id("divpaxinfo"));
		passengerList.click();
		Thread.sleep(2000);
		int n = 1;
		while (n < 4) {
			driver.findElement(By.id("hrefIncAdt")).click();
			n++;

		}
		System.out.println(passengerList.getText());
		Assert.assertEquals(passengerList.getText(), "4 Adult");
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropDown); // static if it says select
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

	//	driver.close();
	}
}
