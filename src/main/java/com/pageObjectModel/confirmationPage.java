package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abstractComponents.abstractComponent;


public class confirmationPage extends abstractComponent{
    public confirmationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    WebDriver driver;


@FindBy(css=".hero-primary") WebElement message;



public String confirmOrderSubmission() throws InterruptedException{
Thread.sleep(3000);
String orderConfirmation = message.getText();
return orderConfirmation;

}}