package CharlyEducation.CharlyEducationAssignment;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.jsoup.Connection.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.DriverBase;
import pageObjects.LandingPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import resources.TabHelper;

public class CharlyEducationTest extends DriverBase {

	@Parameters({ "url" })
	@BeforeMethod
	public void BasePageNavigation(String url) throws IOException {
		driver = InitializeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		LandingPage landingPageObj = new LandingPage(driver);
		WebElement loginButton = landingPageObj.LandingPagelogin();
		this.waitForLoad(driver);
		loginButton.click();
		TabHelper tabHelperObj = new TabHelper();
		tabHelperObj.SwitchToNewTab(driver);
	}

	@Parameters({ "userName", "password", "successMsg" })
	@Test
	public void Login_RightAuthenticationDetails_ShouldLoginSuccessfully(String userName, String password,
			String successMsg) {
		System.out.println(userName + "  " + password);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.EnterUsername().sendKeys(userName);
		loginPageObj.EnterPassword().sendKeys(password);
		loginPageObj.ClickLogin().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		DashboardPage signInPageObj = new DashboardPage(driver);
		assertEquals(signInPageObj.GetUserName(), successMsg);
		
	}

	@Parameters({ "userName", "password", "errorMessage" })
	@Test
	public void Login_WrongAuthenticationDetails_ShouldFailLogin(String userName, String password, String errorMsg) {
		System.out.println(userName + "  " + password);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.EnterUsername().sendKeys(userName);
		loginPageObj.EnterPassword().sendKeys(password);
		loginPageObj.ClickLogin().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		assertEquals(loginPageObj.GetErrorMessageForLoginFailure(), errorMsg);
	}
	

	@AfterMethod
	public void Closewindows() {
		driver.quit();
	}

}
