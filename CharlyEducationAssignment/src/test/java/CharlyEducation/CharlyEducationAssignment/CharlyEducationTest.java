package CharlyEducation.CharlyEducationAssignment;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.DriverBase;
import pageObjects.LandingPage;
import pageObjects.CustomerRegistration;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.TabHelper;

public class CharlyEducationTest extends DriverBase {

	@Parameters({ "url" , "browser"})
	@BeforeMethod
	public void BasePageNavigation(String url,String browser) throws IOException {
		driver = InitializeDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();

		LandingPage landingPageObj = new LandingPage(driver);
		WebElement loginButton = landingPageObj.getLandingPageLoginElement();
		this.waitForLoad(driver);
		loginButton.click();
		TabHelper tabHelperObj = new TabHelper();
		tabHelperObj.SwitchToNewTab(driver);
	}

	@Parameters({ "userName", "password", "successMsg" })
	@Test
	public void Login_RightAuthenticationDetails_ShouldLoginSuccessfully(String userName, String password,
			String successMsg) {
		LoginPage loginPageObj = new LoginPage(driver);
		doLogin(loginPageObj, userName, password);
		DashboardPage signInPageObj = new DashboardPage(driver);
		assertEquals(signInPageObj.getUserNameText(), successMsg);

	}

	private void doLogin(LoginPage loginPageObj, String userName, String password) {
		loginPageObj.getUserNameElement().sendKeys(userName);
		loginPageObj.getPasswordElement().sendKeys(password);
		loginPageObj.getLoginButtonElement().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Parameters({ "userName", "password", "errorMessage" })
	@Test
	public void Login_WrongAuthenticationDetails_ShouldFailLogin(String userName, String password, String errorMsg) {
		LoginPage loginPageObj = new LoginPage(driver);
		doLogin(loginPageObj, userName, password);
		assertEquals(loginPageObj.getErrorMessageForLoginFailure(), errorMsg);
	}
	
	@Parameters({ "userName", "password", "errorMessage" })
	@Test
	public void Login_SqlInjection_ShouldFailLogin(String userName, String password, String errorMsg) {
		LoginPage loginPageObj = new LoginPage(driver);
		doLogin(loginPageObj, userName, password);
		assertEquals(loginPageObj.getErrorMessageForLoginFailure(), errorMsg);
	}

	@Test
	public void Login_PasswordField_ShouldBeTypePassword() {
		LoginPage loginPageObj = new LoginPage(driver);
		assertEquals(loginPageObj.getPasswordElement().getAttribute("type"), "password");
	}
	
	@Parameters({ "HeadingMsg" })
	@Test
	public void Register_RegistrationLink_IsClickable(String HeadingMsg) {
		CustomerRegistration customerRegistrationObj = new CustomerRegistration(driver);
		WebElement registrationLinkElement = customerRegistrationObj.getRegistrationLink();
		assertEquals(registrationLinkElement.isDisplayed(), true);
		registrationLinkElement.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals(customerRegistrationObj.getRegistrationPageHeadingText(), HeadingMsg);
	}

	@AfterMethod
	public void Closewindows() {
		driver.quit();
	}

}
