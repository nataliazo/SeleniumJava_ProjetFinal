package bdeb.ProjetFinal;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;

public class LogoutTest extends Base {
	public WebDriver driver;

	@Test
	public void logOut() throws Exception {
		driver = initializeDriver();

		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("1995405");
		lp.getPassword().sendKeys("alfresco");
		lp.login().click();
		HomePage hp = new HomePage(driver);
		hp.getWelcome().click();
		Thread.sleep(3000);
		hp.logOut().click();

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
