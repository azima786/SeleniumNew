package com.TestingComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseTest implements ITestListener {
ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public void onTestFailure(ITestResult result) {
       // ITestListener.super.onTestFailure(result);
        extentTest.get().fail(result.getThrowable());
        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
         
            e1.printStackTrace();
        } 
        String filePath=null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }


@Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestStart(ITestResult result) {
     
       ITestListener.super.onTestStart(result);
     test =   extent.createTest(result.getMethod().getMethodName());
     extentTest.set(test); //assign unique thread id
        
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extent.flush();
    }
    
}
