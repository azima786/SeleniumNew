package com.TestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class day1 {

    @Test(enabled = false)
public void name() {
    System.out.println("HELLO");
}

@Test(groups={"smoke"})
public void name2() {
    System.out.println("I am smoke");
}

@Test(dependsOnMethods ={"name5"})
public void name3() {
    System.out.println("I come after name5");
}

@Test(groups={"smoke"})
public void name4() {
    System.out.println("I am smoke");
}

@Test(timeOut = 4000)
public void name5() {
    System.out.println("I am name5");
}

@AfterSuite
public void afterSuite(){
    System.out.println("I am last of all test");
}

}
