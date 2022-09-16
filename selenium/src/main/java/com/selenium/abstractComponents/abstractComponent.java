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
    @FindBy(css="button[routerlink*='myorders']") WebElement orderHeader;

    public void waitForElementToAppear(By FindBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
    }

    public void waitForWebElementToAppear(WebElement FindBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.visibilityOf(FindBy));
    }

    public myCart goToCart(){
cartHeader.click();
myCart cart = new myCart(driver);
return cart;
    }

    public OrderPage goToOrderPage(){
        orderHeader.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
            }

    public void waitForElementToDisappear(WebElement spinner){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.invisibilityOf(spinner));

}
}