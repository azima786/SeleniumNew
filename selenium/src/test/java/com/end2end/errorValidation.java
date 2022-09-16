package com.end2end;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestingComponents.BaseTest;

import pageObjectModel.ProductCatalog;
import pageObjectModel.myCart;

public class errorValidation extends BaseTest{

   @Test(groups={"ErrorValidation"})
   public void LogInPageErrorValidation() throws IOException{
     landing.loginApplication("ak123@gmail.com", "A3bc123456$");
   landing.errorMessage();
   Assert.assertEquals("Incorrect email or password.", landing.errorMessage());


   }

   @Test
   public void productDisplayedVerification() throws IOException{
      String productName = "ZARA COAT 3";
      //LandingPage landing= launchApplication();
       
       ProductCatalog productCatalog = landing.loginApplication("ak123@gmail.com", "Abc123456$");
       driver.getTitle();
       List<WebElement> products = productCatalog.getProductList();
       productCatalog.addProductToCart(productName);
       myCart cart = productCatalog.goToCart();
       Boolean match = cart.clickOnCart(productName);
       Assert.assertFalse(match);


   }
}
    

