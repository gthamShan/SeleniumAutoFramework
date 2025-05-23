package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@FindBy(id = "user-name")
	private WebElement usernameField;
	@FindBy(id = "password")
	private WebElement passwordField;
	@FindBy(id = "login-button")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String userName, String password) {
		enterText(usernameField, userName);
		enterText(passwordField, password);
		clickElement(loginButton);
	}

}
