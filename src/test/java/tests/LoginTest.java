package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.DriverFactory;
import pages.LoginPage;

public class LoginTest {
	WebDriver driver;

	@BeforeEach
	public void setup() {
		driver = DriverFactory.initDriver();
	}

	@Test
	public void TestLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		assertEquals("Swag Labs", driver.findElement(By.cssSelector("div.app_logo")).getText());
	}

	@AfterEach
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
