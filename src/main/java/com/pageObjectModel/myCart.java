package com.pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abstractComponents.abstractComponent;



public class myCart extends abstractComponent {

  
WebDriver driver;

    public myCart(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
  //ProductCatalog productCatalog = new ProductCatalog(driver);
    //PageFactory

@FindBy(css=".totalRow button") WebElement checkoutButton;
@FindBy(css=".cartSection h3") List<WebElement> cartItems;


public Boolean clickOnCart(String productName) throws InterruptedException{

//List<WebElement> cartProducts = cartItems;
//WebElement prod = productCatalog.getProductByName(productName);
Thread.sleep(3000);
Boolean match = cartItems.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
//Boolean match = cartItems.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
return match;


}

public paymentMethod checkOutButton(){
checkoutButton.click();
paymentMethod payment = new paymentMethod(driver);
return payment;

}
}
