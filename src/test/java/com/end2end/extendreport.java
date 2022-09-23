package com.end2end;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestingComponents.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extendreport extends BaseTest{
    ExtentReports extent;


    @BeforeTest
public void config(){
    String path = System.getProperty("user.dir")+"\\reports.html";
    ExtentSparkReporter reporter = new ExtentSparkReporter(path);
    reporter.config().setReportName("Extend Report Trail");
    reporter.config().setDocumentTitle("Extend Report Test");

    
    extent = new ExtentReports();
    extent.attachReporter(reporter);
    extent.setSystemInfo("Tester", "Azima");


}


    @Test
    public void initialDemo() {
        ExtentTest test = extent.createTest("MyTest");
        
        driver.get("https://rahulshettyacademy.com/client");
        System.out.println( driver.getTitle());
        driver.close();
        test.fail("Results do not match");
extent.flush();
    }
}
