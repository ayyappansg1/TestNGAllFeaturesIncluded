package cucumberReporting;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import constants.Constants;
import driverManager.DriverManager;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generateReport(String json) {
		File file=new File(System.getProperty("user.dir")+File.separator+"target");
		Configuration config=new Configuration(file, "HerokupAppAutomation");
		config.addClassifications("Tester", "Ayyappan");
		config.addClassifications("BrowserName", DriverManager.getBrowserName());
		List<String>li=new LinkedList<String>();
		li.add(json);
		ReportBuilder builder=new ReportBuilder(li, config);
		builder.generateReports();
	}
}
