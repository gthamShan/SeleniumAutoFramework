package com.company.project;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
	private static ExtentReports extent;

	public static void setupReport() {

		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);

		extent.createTest("MyfirstTest").log(Status.PASS, "This is a logging event");
		extent.flush();
	}

}
