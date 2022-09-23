package com.TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//Itest Listener
public class listeners implements ITestListener{
    
/**
 * 
 */


@Override
protected Object clone() throws CloneNotSupportedException {
   
    return super.clone();
}

@Override
public boolean equals(Object o) {
   
    return super.equals(o);
}


@Override
public int hashCode() {

    return super.hashCode();
}

@Override
public String toString() {
   
    return super.toString();
}

@Override
public void onFinish(ITestContext context) {
 
    ITestListener.super.onFinish(context);
}

@Override
public void onStart(ITestContext context) {
   
    ITestListener.super.onStart(context);
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
   
    ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
}

@Override
public void onTestFailedWithTimeout(ITestResult result) {
 
    ITestListener.super.onTestFailedWithTimeout(result);
}

@Override
public void onTestFailure(ITestResult result) {
   System.out.println("Test failed");
    ITestListener.super.onTestFailure(result);
}

@Override
public void onTestSkipped(ITestResult result) {
   System.out.println(result.getName());
    ITestListener.super.onTestSkipped(result);
}

@Override
public void onTestStart(ITestResult result) {
   System.out.println("Test started "+result.getName());
    ITestListener.super.onTestStart(result);
}


}
