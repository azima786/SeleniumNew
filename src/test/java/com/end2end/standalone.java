package com.end2end;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class standalone {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String productName = "ZARA COAT 3";
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/client");

        driver.findElement(By.id("userEmail")).sendKeys("ak123@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Abc123456$");
        driver.findElement(By.id("login")).click();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);

prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

Assert.assertTrue(match);

driver.findElement(By.cssSelector(".totalRow button")).click();

//driver.findElement(By.cssSelector(".form-group .text-validated")).sendKeys("ind");
//[placeholder='Select Country']
//WebElement options = driver.findElement(By.cssSelector("button .ng-star-inserted"));
    
Actions a = new Actions(driver);
a.sendKeys(driver.findElement(By.cssSelector(".form-group .text-validated")),"india").build().perform();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

driver.findElement(By.cssSelector(".ta-item:last-of-type")).click();
driver.findElement(By.cssSelector(".action__submit")).click();
String message =driver.findElement(By.cssSelector(".hero-primary")).getText();


Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));

driver.quit();


}
    
}
