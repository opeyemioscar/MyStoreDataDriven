package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;


	public class ExtentManager extends BaseClass {

	    private static ExtentReports extent;

	    public static ExtentReports getInstance(String fileName) {
	        if (extent == null) {
	            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

	            htmlReporter.config().setTheme(Theme.STANDARD);
	            htmlReporter.config().setDocumentTitle(fileName);
	            htmlReporter.config().setEncoding("utf-8");
	            htmlReporter.config().setReportName(fileName);

	            extent = new ExtentReports();
	            extent.attachReporter(htmlReporter);
	            extent.setSystemInfo("Automation Tester", "Rahul Arora");
	            extent.setSystemInfo("Organization", "Way2Automation");
	            extent.setSystemInfo("Build no", "W2A-1234");
	        }
	        return extent;
	    }

	    public  String screenshotPath;
	    public  String screenshotName;

	    public  void captureScreenshot() {
	        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        Date d = new Date();
	        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
	        try {
	            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



