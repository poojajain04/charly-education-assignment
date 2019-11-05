package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CharlyEducationLandingPage {
	WebDriver driver;

	By landingPage = By.xpath("//*[@id='menu']/div[4]/div[2]/a");

	public CharlyEducationLandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement LandingPagelogin() {
		return driver.findElement(landingPage);
	}

}
