package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerRegistration {
	WebDriver driver;
	By registrationlink = By.xpath("/html/body/div[1]/div[3]/div/div/div/a");
	By headingRegistrationPage = By.xpath("/html/body/div[1]/div[3]/div/h1");

	public CustomerRegistration(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getRegistrationLink() {
		return driver.findElement(registrationlink);
	}

	public String getRegistrationPageHeadingText() {
		return driver.findElement(headingRegistrationPage).getText();

	}

}
