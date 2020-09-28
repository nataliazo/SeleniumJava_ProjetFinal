package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By username = By.id("page_x002e_components_x002e_slingshot-login_x0023_default-username");
	By password = By.id("page_x002e_components_x002e_slingshot-login_x0023_default-password");
	By loginBtn = By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getUsername() {
		return driver.findElement(username);

	}

	public WebElement getPassword() {
		return driver.findElement(password);

	}

	public WebElement login() {
		return driver.findElement(loginBtn);

	}

}
