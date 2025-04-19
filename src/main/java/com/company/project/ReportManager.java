package com.company.project;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
	private static ExtentReports extent;
	private static ExtentTest test;

	public static void setupReport() {

		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);

		test = extent.createTest("MyfirstTest").log(Status.PASS, "This is a logging event");
		extent.flush();
	}

	public static void log(String message) {
		test.info(message);
	}

}
