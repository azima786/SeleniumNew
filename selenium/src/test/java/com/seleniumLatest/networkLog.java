package com.seleniumLatest;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.network.Network;
import org.openqa.selenium.devtools.v102.network.model.Request;
import org.openqa.selenium.devtools.v102.network.model.Response;

public class networkLog {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/azima.keshwani/Desktop/selenium/selenium/target/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), request -> {
            Request req = request.getRequest();
           // System.out.println(req.getUrl());
          
        });

        devTools.addListener(Network.responseReceived(), response -> {
            Response res = response.getResponse();
            // System.out.println(res.getUrl());
            //System.out.println(res.getStatus());
            if(res.getStatus().toString().startsWith("4")){
                System.out.println(res.getUrl() + " failing");
            }

        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

    }
}
