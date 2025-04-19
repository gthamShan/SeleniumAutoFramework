package com.company.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	
	public void login(String userName,String password) {
		driver.findElement(usernameField).sendKeys(userName);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	

}
