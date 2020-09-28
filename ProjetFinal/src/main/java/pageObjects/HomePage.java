package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;
	By title = By.xpath("//span[contains(text(),\"Tableau de bord de\")]");
	By welcome = By.id("HEADER_USER_MENU_POPUP_text");
	By logOut = By.id("HEADER_USER_MENU_LOGOUT_text");
	By outilAdmin =By.xpath("//a[@title = \"Outils admin\"]");

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}
	
	public WebElement getLegend() {
		return driver.findElement(title);
	}
	
	public WebElement getWelcome() {
		return driver.findElement(welcome);
	}
	
	public WebElement logOut() {
		return driver.findElement(logOut);
	}

	public WebElement outilAdmin() {
		
		return driver.findElement(outilAdmin);
	}
	
	
	

}
