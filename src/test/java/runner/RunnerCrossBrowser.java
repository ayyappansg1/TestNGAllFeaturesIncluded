package runner;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import constants.Constants;
import cucumberReporting.Reporting;
import driverManager.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.CommonUtils;

/**
 * This is a Runner Class
 * Execution starts from here.Additional runner classes also can be Maintained 
 */

@CucumberOptions(dryRun = false,features = "src\\test\\resources\\FeatureFiles",
glue = {"stepdefinitions"},monochrome = true,
plugin = {"rerun:target/failed.txt",
		"json:target/forReporting.json",
		"html:target/sangar.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
}
//tags = "not @smoke"
)
public class RunnerCrossBrowser extends AbstractTestNGCucumberTests{
	private static final Logger logger=LogManager.getLogger(RunnerCrossBrowser.class);
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void parallelCheck(String browser) throws IOException {
		logger.info("Before suite running");
		CommonUtils.cleanAllureResults();
		CommonUtils.loadProperties(browser);
		DriverManager.setBrowserName(browser);
	}
//	@AfterTest(alwaysRun = true)
//	public void globalTearDown() {
//		logger.info("Inside After Class for Driver Quit");
//		DriverManager.quitDriver();
//		}
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//	}
}
