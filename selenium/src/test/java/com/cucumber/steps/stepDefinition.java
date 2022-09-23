package com.cucumber.steps;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.TestingComponents.BaseTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModel.LandingPage;
import pageObjectModel.ProductCatalog;
import pageObjectModel.confirmationPage;
import pageObjectModel.myCart;
import pageObjectModel.paymentMethod;

public class stepDefinition extends BaseTest {

    public ProductCatalog productCatalog;
    public LandingPage landing;
    public myCart cart;
    public paymentMethod payment;
    public confirmationPage confirmPage;
    
    
    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException{
       landing = launchApplication();
    }

    @Given ("Logged in with username {string} and password {password}")
    public void Logged_in_with_username_and_password(String username, String password){
       productCatalog = landing.loginApplication(username, password);
    }

    @When ("I add product {string} from Cart")
    public void I_add_product_from_Cart(String productName){
        List<WebElement> products = productCatalog.getProductList();
        productCatalog.addProductToCart(productName);
    }

@And ("checkout {string} and submit the order")
public void checkout_submit_the_order(String productName) throws InterruptedException{
    myCart cart = productCatalog.goToCart();
    Boolean match = cart.clickOnCart(productName);
    Assert.assertTrue(match);
    payment = cart.checkOutButton();
    payment.selectCountryFromDropDown("india");  
    confirmPage = payment.clickOnPlaceOrder();
}

@Then ("{string} message is displayed on ConfirmationPage$")
public void message_displayed_on_ConfirmationPage(String string) throws InterruptedException{
    String orderConfirmation =confirmPage.confirmOrderSubmission();
    Assert.assertTrue(orderConfirmation.equalsIgnoreCase(string));
}

@Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
        Assert.assertEquals(strArg1, landing.errorMessage());
        driver.close();
    }

}
