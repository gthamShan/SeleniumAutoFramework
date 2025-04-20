package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.epam.healenium.SelfHealingDriver;


public class AIWebDriver {
	private static SelfHealingDriver driver;

	 public static WebDriver getDriver() {
	        if (driver == null) {
	            WebDriver delegate = new ChromeDriver(); // Original WebDriver
	            driver = SelfHealingDriver.create(delegate); // Create SelfHealingDriver
	        }
	        return driver;
	    }

}
