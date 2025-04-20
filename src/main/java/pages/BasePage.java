package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		// wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	protected WebElement waitForElement(WebElement element) {
		return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(1))
				.ignoring(Exception.class).until(ExpectedConditions.visibilityOf(element));

	}

	protected void clickElement(WebElement element) {
		waitForElement(element);
		element.click();
	}

	protected void enterText(WebElement element, String text) {
		waitForElement(element);
		element.sendKeys(text);
	}
}
