package com.autoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class fluentwait {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/azima.keshwani/Desktop/selenium/target/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://admin:admin@the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Basic Auth")).click();

        
    }
}
