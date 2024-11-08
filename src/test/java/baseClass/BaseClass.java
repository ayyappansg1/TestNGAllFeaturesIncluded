package baseClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import constants.Constants;
import driverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonUtils;

public class BaseClass extends DriverManager{
	private static final Logger logger=LogManager.getLogger(BaseClass.class);

	public static void launchApplication(String url) throws MalformedURLException {
		logger.info("Maximising the window");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		logger.info("Launching the Application");
		getDriver().get(url);
	}

}
