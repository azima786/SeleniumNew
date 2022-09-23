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
                "C:/Users/azima.keshwani/Desktop/selenium/target/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        //Which API request has failed. Not giving data properly
        //What exactly happened and why test failed
        //Initialize Object
        DevTools devTools = driver.getDevTools();
        //Initialize session
        devTools.createSession();

        //Network related there is domain called network. Enable tracking and events to network and will give informaiton back to us. It will give all data it found if given optional. 
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //Events - some activities that are getting triggered. Listening to event and will be notified when that event happens
        //Before request is been sent. It will show what information is being sent to backend
        devTools.addListener(Network.requestWillBeSent(), request -> {
            Request req = request.getRequest();
           System.out.println("FrontEnd URL " + req.getUrl());
          
        });

        //When response is available back to browser. response = response we received back. 
        devTools.addListener(Network.responseReceived(), response -> {
            Response res = response.getResponse();
            //System.out.println("ResponseURL " + res.getUrl());
            System.out.println("ResponseStatus " + res.getStatus());
            if(res.getStatus().toString().startsWith("4")){
                System.out.println(res.getUrl() + " failing");
            }

        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

    }
}
