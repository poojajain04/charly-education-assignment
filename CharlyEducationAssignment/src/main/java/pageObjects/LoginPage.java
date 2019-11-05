package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	By username = By.id("email");
	By Password = By.id("password");
	By Login = By.xpath("/html/body/div[1]/div[3]/div/div/section/div[2]/div/button");
	By loginFailureErrorMsg = By.xpath("/html/body/div/div[3]/div/div/p");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement EnterUsername() {
		return driver.findElement(username);
	}

	public WebElement EnterPassword() {
		return driver.findElement(Password);
	}

	public WebElement ClickLogin() {
		return driver.findElement(Login);
	}

	public String GetErrorMessageForLoginFailure() {
		return driver.findElement(loginFailureErrorMsg).getText();
	}

}
