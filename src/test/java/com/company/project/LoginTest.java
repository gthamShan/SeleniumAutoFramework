package com.company.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {
	WebDriver driver;

	@BeforeEach
	public void setup() {
		driver = DriverFactory.getDriver();
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void TestLogin() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		assertEquals("Swag Labs", driver.findElement(By.cssSelector("div.app_logo")).getText());
	}

	@AfterEach
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
