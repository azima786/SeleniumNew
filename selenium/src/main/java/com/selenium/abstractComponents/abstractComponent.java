package com.selenium.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjectModel.OrderPage;
import pageObjectModel.myCart;

public class abstractComponent {

    WebDriver driver;

    public abstractComponent(WebDriver driver) {
this.driver = driver;
    }

    @FindBy(css="[routerlink*='cart']") WebElement cartHeader;
    //@FindBy(css="button[routerlink*='myorders']") WebElement orderHeader;
    @FindBy(css="button[routerlink='/dashboard/myorders']") WebElement orderHeader;
    

    public void waitForElementToAppearBy(By FindBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
    }

    public void waitForWebElementToAppear(WebElement FindBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
wait.until(ExpectedConditions.visibilityOf(FindBy));
    }

    public myCart goToCart(){
cartHeader.click();
myCart cart = new myCart(driver);
return cart;
    }

    public OrderPage goToOrderPage() throws InterruptedException{
        waitForWebElementToAppear(orderHeader);
        orderHeader.click();
        Thread.sleep(3000);
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
            }

    public void waitForElementToDisappear(WebElement Findby){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
wait.until(ExpectedConditions.invisibilityOf(Findby));

}
}