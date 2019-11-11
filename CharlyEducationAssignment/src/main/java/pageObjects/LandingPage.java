package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	WebDriver driver;

	By loginLink = By.xpath("/html/body/div[2]/div/div[4]/div[3]/a[1]");
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLandingPageLoginElement() {
		return driver.findElement(loginLink);
	}
}
