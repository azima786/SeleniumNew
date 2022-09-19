package com.seleniumLatest;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.emulation.Emulation;

import com.github.dockerjava.api.model.Network;

public class mobileEmulator {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/azima.keshwani/Desktop/selenium/selenium/target/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Send commands to CDP Methods-> CDP Methods will invoke and get access to Chrome DeVTools
        devTools.send(Emulation.setDeviceMetricsOverride(320, 400, 75, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

driver.get("https://rahulshettyacademy.com/angularAppdemo/");
driver.findElement(By.cssSelector(".navbar-toggler")).click();
Thread.sleep(3000);
driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

    }
}
