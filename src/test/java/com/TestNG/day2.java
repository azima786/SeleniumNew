package com.TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class day2 {

    @Test
    @Parameters({"URL", "username"})
public void name(String urlName, String username) {
    System.out.println("HELLO");
    System.out.println("I am default parameter from testNG xml file " + urlName + username);
}

@Test(dataProvider = "DataProvider")
public void name2(String username, String password) {
    System.out.println("HELLO2");
    System.out.println(username + password);
}

@Test
public void name3() {
    System.out.println("HELLO3");
    
}

@Test(groups={"smoke"})
public void name4() {
    System.out.println("I am smoke");
}
@BeforeMethod
public void prerequest(){
    System.out.println("Before this method!");
}

@AfterTest
public void AfterTest(){
    System.out.println("After all test!");
}

@BeforeSuite
public void afterSuite(){
    System.out.println("I am before all test");
}

@DataProvider
public Object[][] DataProvider(){

    //3 rows/combinations and 2 values with username and password
  Object[][] data = new Object[3][2];
data[0][0] = "firstsetusername";
data[0][1] = "firstpassword";

//
data[1][0] = "username2";
data[1][1] = "password2";

//
data[2][0] = "username3";
data[2][1] = "password3";

return data;

}

@BeforeClass
public void BeforeClass(){
    System.out.println("I am before all class in this test");
}
}
