package test.java.com.selenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo {
	public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\azima.keshwani\\Desktop\\selenium\\selenium\\target\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

driver.findElement(By.xpath("//tr/th[1]")).click();
List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
System.out.println("Elements List " + elementsList);
	
List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted List " + sortedList);

Assert.assertTrue(originalList.equals(sortedList));

//Scan vegetable name column with getText -> Rice -> Print price of vegetable

List<String> price = elementsList.stream().filter(s-> s.getText().contains("Beans")).map(s-> getPriceVeggie(s)).collect(Collectors.toList());
price.forEach(a->System.out.println("Price for Beans $" + a));

	}

	private static String getPriceVeggie(WebElement s){
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
// 	}





	}
	
}