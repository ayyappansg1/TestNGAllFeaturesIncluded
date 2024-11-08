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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass;
import constants.Constants;
import helper.LocalHelper;

public class DriverManager {
	private static final Logger logger = LogManager.getLogger(DriverManager.class);
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<String> browserName = new ThreadLocal<>();

	public enum BrowserType {
		CHROME, FIREFOX, EDGE
	}
	public static void setBrowserName(String browser) {
        browserName.set(browser);
    }
	public static WebDriver getDriver() throws MalformedURLException {
		String browser = browserName.get();
		if (browser == null) {
		    logger.error("Browser name is null; ensure parameter is set correctly for parallel runs.");
		    throw new NullPointerException("Browser name not set for this thread.");
		}
		if (browserName.get() == null) {
		    throw new IllegalStateException("Browser parameter was not initialized in @BeforeClass.");
		}
		if (driver.get() == null) {
            logger.info("Initializing driver for thread: " + Thread.currentThread().getId());
            try {
                WebDriver webDriver = DriverFactory.getDriver(BrowserType.valueOf(browser.toUpperCase()));
                driver.set(webDriver);
                logger.info("Driver initialized for thread: " + Thread.currentThread().getId());
            } catch (IllegalArgumentException e) {
                logger.error("Invalid browser type specified: " + Constants.browserName, e);
                throw e;
            }
        } else {
            logger.info("Reusing existing driver for thread: " + Thread.currentThread().getId());
        }
        return driver.get();
	}
	public static String getBrowserName() {
	    String browser = browserName.get();
	    if (browser == null) {
	        throw new NullPointerException("Browser name not set for this thread.");
	    }
	    return browser;
	}
	public static void quitDriver() {
		if (driver.get() != null) {
            logger.info("Quitting driver for thread: " + Thread.currentThread().getId());
            driver.get().quit(); // Quit the driver
            driver.remove(); // Remove the driver reference from ThreadLocal
            //browserName.remove();
            logger.info("Driver quit and removed for thread: " + Thread.currentThread().getId());
        }
    }
	public static void closeBrowser() {
		if (driver.get() != null) {
            logger.info("Closing driver for thread: " + Thread.currentThread().getId());
            driver.get().close();
		}
	}
}
