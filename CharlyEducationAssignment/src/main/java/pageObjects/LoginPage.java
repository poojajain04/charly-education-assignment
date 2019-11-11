package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	By username = By.id("email");
	By password = By.id("password");
	By loginButton = By.xpath("/html/body/div[1]/div[3]/div/div/section/div[2]/div/button");
	By loginFailureErrorMsg = By.xpath("/html/body/div/div[3]/div/div/p");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUserNameElement() {
		return driver.findElement(username);
	}

	public WebElement getPasswordElement() {
		return driver.findElement(password);
	}

	public WebElement getLoginButtonElement() {
		return driver.findElement(loginButton);
	}

	public String getErrorMessageForLoginFailure() {
		return driver.findElement(loginFailureErrorMsg).getText();
	}
}
