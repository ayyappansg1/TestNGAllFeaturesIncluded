package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed.txt",glue = {"stepdefinitions"},monochrome = true)
public class ReRunnerClass extends AbstractTestNGCucumberTests{
	

}
