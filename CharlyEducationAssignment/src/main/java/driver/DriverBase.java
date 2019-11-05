package driver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverBase {
	public WebDriver driver;

	public WebDriver InitializeDriver() throws IOException {

		PropertyReader propertyReaderObj = new PropertyReader();
		String propertyValue = propertyReaderObj.GetPropertyValue(
				"C:\\Users\\lenovo\\eclipse-workspace\\CharlyEducationAssignment\\src\\main\\java\\resources\\data.properties",
				"browser");

		System.out.println(propertyValue);// browser

		if (propertyValue.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}

}
