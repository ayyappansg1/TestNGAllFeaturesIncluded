package runner;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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
public class RunnerParallelScenario extends AbstractTestNGCucumberTests{
	private static final Logger logger=LogManager.getLogger(RunnerParallelScenario.class);

	 @Parameters("browser")
	    @BeforeMethod(alwaysRun = true)
	    public void parallelCheck(String browser) throws IOException {
	        if (browser == null) {
	            throw new IllegalArgumentException("Browser parameter not provided in TestNG suite.");
	        }
	        DriverManager.setBrowserName(browser);
	        logger.info("Before method running for browser: " + DriverManager.getBrowserName());
	        logger.info(Thread.currentThread().getId() + " Before setting browser: " + browser);
	        CommonUtils.cleanAllureResults();
	        CommonUtils.loadProperties(DriverManager.getBrowserName());
	    }
	   @Override
	   @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        logger.info("DataProvider is supplying scenarios for thread: " + Thread.currentThread().getId());
	        return super.scenarios();
	    }
//	@AfterClass(alwaysRun = true)
//	public void globalTearDown() {
//		logger.info("Inside After Class for Driver Quit");
//		DriverManager.quitDriver();
//		}
	
	
//	@AfterSuite(alwaysRun = true)
//	public void generateReporting() {
//		Reporting.generateReport(System.getProperty("user.dir")+File.separator+"target"+File.separator+"forReporting.json");
//	}
//	@Parameters("browser")
//	@BeforeSuite(alwaysRun = true)
//	public void setupSuite(String browser) {
//	    if (browser == null) {
//	        throw new IllegalArgumentException("Browser parameter not provided in TestNG suite.");
//	    }
//	    DriverManager.setBrowserName(browser);
//	    logger.info("Browser set in @BeforeSuite: " + browser);
//	}
}
