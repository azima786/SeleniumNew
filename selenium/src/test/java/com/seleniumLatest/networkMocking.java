package com.seleniumLatest;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.fetch.Fetch;

public class networkMocking {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/azima.keshwani/Desktop/selenium/selenium/target/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Mock or intercepting till code. Send command of wht you want to do. patten listen to only css request
        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));

        //Before sending any request you can manipulate request. It will be fired when you are ready to send request to backEnd. Send modified request instead of original
        devTools.addListener(Fetch.requestPaused(), request -> {
            if (request.getRequest().getUrl().contains("shetty")) {
                String mockedURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
                System.out.println(mockedURL);

                //continue request to hit server
                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedURL), Optional.of(request.getRequest().getMethod()),
                        Optional.empty(), Optional.empty(), Optional.empty()));

            }

            else {
                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()),
                Optional.empty(), Optional.empty(), Optional.empty()));
            }
            
        

        });    
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
         Thread.sleep(3000);
            driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
            Thread.sleep(3000);
System.out.println(driver.findElement(By.cssSelector("p")).getText());

    }
}
