package com.TestingComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pageObjectModel.LandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public WebDriver driver;
    public LandingPage landing;

    public WebDriver initialzeDriver() throws IOException{

        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//Resources//GlobalData.properties");
        prop.load(fs);
String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

      //  prop.getProperty("browser");

if(browserName.contains("chrome")){

    ChromeOptions options = new ChromeOptions();
     WebDriverManager.chromedriver().setup();
     if(browserName.contains("headless")){
        options.addArguments("headless");
     }
   driver = new ChromeDriver(options);
   driver.manage().window().setSize(new Dimension(1440, 900));
   
}
else if(browserName.equalsIgnoreCase("firefox")){
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
 
}

// else if(browserName.equalsIgnoreCase("edge")){
//     WebDriverManager.edgedriver().setup();
//    driver = new EdgeDriver();
// }

//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.manage().window().maximize();
return driver;
} 

@BeforeMethod(alwaysRun = true)
public LandingPage launchApplication() throws IOException{
    driver = initialzeDriver();
    landing= new LandingPage(driver);
    landing.goTo();
    return landing;
}

public String getScreenshot(String testCaseName, WebDriver driver) throws IOException{
    TakesScreenshot ts = (TakesScreenshot)driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    File file = new File(System.getProperty("user.dir")+testCaseName+".png");
    FileUtils.copyFile(source, file);
    return System.getProperty("user.dir")+testCaseName+".png";
    }

public List<HashMap<String, String>> getJsonDataToMap(String FilePath) throws IOException{

String jsonContent = FileUtils.readFileToString(new File (FilePath), StandardCharsets.UTF_8);

//String to HashMap Jackson Databind
ObjectMapper mapper = new ObjectMapper();
List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
    
});

return data;
   }

   
@AfterTest(alwaysRun = true)
public void tearDown(){
   driver.close();
}
    }
   
