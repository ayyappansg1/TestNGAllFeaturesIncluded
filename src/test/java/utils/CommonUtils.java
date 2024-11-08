package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import constants.Constants;
import driverManager.DriverManager;

public class CommonUtils {
	private static final Logger logger = LogManager.getLogger(CommonUtils.class);
	private volatile static CommonUtils instance;

	private CommonUtils() {
	}

	public static CommonUtils getInstance() {
		if (instance == null) {
			synchronized (CommonUtils.class) {
				if (instance == null) {
					instance = new CommonUtils();
				}
			}
		}
		return instance;
	}

	public static void loadProperties(String browserName) throws IOException {
		try {
			FileReader reader = new FileReader(new File("src\\test\\resources\\Config.properties"));
			Properties properties = new Properties();
			properties.load(reader);
			Constants.application_url = properties.getProperty("application_url");
			logger.info("browserName is :"+browserName);
			logger.info("ApplicationUrl is :"+Constants.application_url );
			//Constants.browserName = properties.getProperty("browser_name");
			//Constants.browserName=browserName;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String screenshot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + File.separator + "target" + File.separator + "screenshots"
				+ File.separator + todayDate());
		logger.info("Today date is " + todayDate());
		if (!file.exists()) {
			file.mkdirs();
		}
		File destination = new File(file, fileName + ".png");
		FileHandler.copy(screenshotAs, destination);
		return destination.getAbsolutePath();
	}

	public static byte[] screenshotAsByte() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
		byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
		return bytes;
	}

	public static String todayDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm");
		return sdf.format(date);
	}
	public static void cleanAllureResults() {
        File allureResultsFolder = new File("allure-results");
        if (allureResultsFolder.exists()) {
            for (File file : allureResultsFolder.listFiles()) {
                if (!file.isDirectory()) {
                    file.delete();
                }
            }
        }
    }

}
