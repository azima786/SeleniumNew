package com.end2end;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestingComponents.BaseTest;
import com.TestingComponents.Retry;
import com.pageObjectModel.OrderPage;
import com.pageObjectModel.ProductCatalog;
import com.pageObjectModel.confirmationPage;
import com.pageObjectModel.myCart;
import com.pageObjectModel.paymentMethod;

public class submitTest extends BaseTest{
 String productName = "ZARA COAT 3";
   @Test(dataProvider = "getData", groups={"Purchase"}, retryAnalyzer = Retry.class)
   //public void submitOrder(String email, String password, String productName) throws IOException{
   public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException{
     
      //LandingPage landing= launchApplication();
       
       ProductCatalog productCatalog = landing.loginApplication(input.get("email"), input.get("password"));
//       ProductCatalog productCatalog = landing.loginApplication("ak123@gmail.com", "Abc123456$");
       List<WebElement> products = productCatalog.getProductList();
       productCatalog.addProductToCart(input.get("productName"));
       myCart cart = productCatalog.goToCart();
       Boolean match = cart.clickOnCart(input.get("productName"));
       Assert.assertTrue(match);
       paymentMethod payment = cart.checkOutButton();
       payment.selectCountryFromDropDown("india");  
       confirmationPage confirmPage = payment.clickOnPlaceOrder();
       String orderConfirmation =confirmPage.confirmOrderSubmission();
       Assert.assertTrue(orderConfirmation.equalsIgnoreCase("Thankyou for the order."));


   }

   @Test  (dependsOnMethods = {"submitOrder"}, retryAnalyzer = Retry.class)
  // public void OrderHistoryTest(String email, String password, String productName){
public void OrderHistoryTest() throws InterruptedException{
      ProductCatalog productCatalog = landing.loginApplication("ak123@gmail.com", "Abc123456$");
      OrderPage orderPage = productCatalog.goToOrderPage();
      Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));

   }




   @DataProvider
   public Object[][] getData() throws IOException{

      // HashMap<String,String> map = new HashMap<String,String>();
      // map.put("email", "ak123@gmail.com");
      // map.put("password", "Abc123456$");
      // map.put("productName", "ZARA COAT 3");

      // HashMap<String,String> map1 = new HashMap<String,String>();
      // map1.put("email", "shetty@gmail.com");
      // map1.put("password", "Iamking@000");
      // map1.put("productName", "ADIDAS ORIGINAL");

      List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"/src/test/java/com/data/purchaseOrder.json");
   //return new Object[][] {{"ak123@gmail.com", "Abc123456$", "ZARA COAT 3"}, {"shetty@gmail.com", "Iamking@000", "ADIDAS ORIGINAL"}};
      return new Object[][]  {{data.get(0)}, {data.get(1)}};
   }

}
    

