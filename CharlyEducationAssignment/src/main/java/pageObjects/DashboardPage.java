package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	WebDriver driver;
	By getUser = By.xpath("//*[@id=\'root\']/div[3]/div/div[2]/div[1]/div/strong");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public String GetUserName() {
		return driver.findElement(getUser).getText();
	}

}
