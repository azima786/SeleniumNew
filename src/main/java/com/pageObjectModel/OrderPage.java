package com.pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abstractComponents.abstractComponent;



public class OrderPage extends abstractComponent {

  
WebDriver driver;

    public OrderPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
  //ProductCatalog productCatalog = new ProductCatalog(driver);
    //PageFactory

@FindBy(css=".totalRow button") WebElement checkoutButton;
@FindBy(css="tr td:nth-of-type(2)") List<WebElement> productNames;


public Boolean VerifyOrderDisplay(String productName){
Boolean match = productNames.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
return match;


}


}
