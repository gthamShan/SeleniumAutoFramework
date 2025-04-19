package com.company.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver initDriver() {
		String browser = getConfig("browser");

		switch (browser.toLowerCase()) {
		case "chrome":
			driver.set(new ChromeDriver());
			break;
		case "edge":
			driver.set(new EdgeDriver());
		default:
			throw new IllegalArgumentException("unsupported browser: " + browser);
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(getConfig("baseURL"));
		return getDriver();

	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}

	private static String getConfig(String key) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("./src/test/resources/config/qaconfig.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

}
