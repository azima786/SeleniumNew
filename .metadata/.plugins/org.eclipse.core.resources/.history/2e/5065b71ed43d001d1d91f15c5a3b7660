package com.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features", 
        glue = "steps", 
        tags = "@Regression", 
        monochrome = true, 
        plugin = {
                "html:target/cucumber.html" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
