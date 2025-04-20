package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class ReportManager {
	private static ExtentReports extent;
	private static ExtentTest test;

	public static void setupReport() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		test = extent.createTest("MyFirstTest");
		extent.flush();
	}

	public static void log(String message) {
		test.info(message);
	}

	public static void logwithScreenshot(String message, WebDriver driver) {
		String screenshotPath = captureScreenshot(driver);
		test.info(message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	public static String captureScreenshot(WebDriver driver) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = "target/screenshots/" + System.currentTimeMillis() + ".png";
		try {
			Files.copy(screenshot, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;

	}

}
