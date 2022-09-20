package com.seleniumLatest;

import java.util.Optional;

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

        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
       devTools.addListener(Fetch.requestPaused(), request->{
if(request.getRequest().getUrl().contains("shetty")){
String mockedURL=    request.getRequest().getUrl().replace("=shetty", "=BadGuy");
System.out.println(mockedURL);

devTools.send(Fetch.continueRequest(request.getRequestId(), mockedURL, request.getRequest().getMethod(), request.getRequest().getPostData(), request.getRequest().getHeaders(), Optional.empty()));

}
       });
    }
}
