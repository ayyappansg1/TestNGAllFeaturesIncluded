package driverManager;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import constants.Constants;
import driverManager.DriverManager.BrowserType;

public class DriverFactory {
	private static final Logger logger=LogManager.getLogger(DriverFactory.class);

	 public static WebDriver getDriver(BrowserType browserType) throws MalformedURLException {
	        WebDriver driver = null;
	        String gridUrl = "http://localhost:4444/wd/hub"; // or replace with your Selenium Hub URL
	        switch (browserType) {
			case EDGE:
				logger.info("Launching edge Browser");
		        EdgeOptions options = new EdgeOptions();
				driver=new EdgeDriver(options);
	            //driver = new RemoteWebDriver(new URL(gridUrl), options);
				break;
			case CHROME:
				logger.info("Launching Chrome Browser");
				//capabilities.setBrowserName("chrome");
				ChromeOptions chromeOptions=new ChromeOptions();
				driver=new ChromeDriver(chromeOptions);
	            //driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
				break;
			case FIREFOX:
				logger.info("Launching firefox Browser");
				FirefoxOptions firefoxOptions=new FirefoxOptions();
				//capabilities.setBrowserName("chrome");
				driver=new FirefoxDriver();
	            //driver = new RemoteWebDriver(new URL(gridUrl),firefoxOptions);
				break;
			default:
				ChromeOptions chromeOptionsdef=new ChromeOptions();
				driver=new ChromeDriver(chromeOptionsdef);
				logger.info("Defaulting to Chrome Browser on Docker");
	            //driver = new RemoteWebDriver(new URL(gridUrl), new ChromeOptions());
	            break;
			}
	        return driver;
	 }

}
