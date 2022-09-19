package com.seleniumLatest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class setGeoLocation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/azima.keshwani/Desktop/selenium/selenium/target/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("latitude", 40);
        deviceMetrics.put("longitude", 3);
        deviceMetrics.put("accuracy", 1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", deviceMetrics);

        driver.get("https://www.google.com/");
        Thread.sleep(3000);
    
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    //    driver.findElement(By.cssSelector("button[class='M6CB1c rr4y5c']")).click();
        driver.findElements(By.cssSelector(".ezO2md")).get(0).click();
        String title = driver.findElement(By.cssSelector("our-story-card-title")).getText();
        System.out.println(title);

    }
}
