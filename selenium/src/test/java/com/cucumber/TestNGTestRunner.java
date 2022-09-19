package com.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/cucumber", glue = "stepDefinitions.stepDefinitionImp", tags = "@Regression",monochrome = true, plugin = {
        "html:target/cucumber.html" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

 

}
