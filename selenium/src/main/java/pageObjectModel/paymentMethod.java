package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.abstractComponents.abstractComponent;

public class paymentMethod extends abstractComponent {
    public paymentMethod(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    WebDriver driver;

   
  //ProductCatalog productCatalog = new ProductCatalog(driver);
    //PageFactory
@FindBy(css=".form-group .text-validated") WebElement countryElement;
@FindBy(css=".action__submit") WebElement placeOrder;
@FindBy(css=".ta-item:last-of-type") WebElement selectCountry;

By countryResults = By.cssSelector(".ta-results");


public void selectCountryFromDropDown(String country){
    Actions a = new Actions(driver);
a.sendKeys(countryElement,country).build().perform();
waitForElementToAppearBy(countryResults);
selectCountry.click();
}

public confirmationPage clickOnPlaceOrder(){
placeOrder.click();
return new confirmationPage(driver);

}
}


