package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OutilAdminPage {
	public WebDriver driver;
	String vNom;
	By title = By.xpath("//title[text() = \"Alfresco » Outils admin\"]");
	By gestionModelLink = By.xpath("//a[@title = \"Gestionnaire de modèles\"]");
	
	
	public OutilAdminPage(WebDriver driver) {

		this.driver = driver;
	}
	public WebElement title() {
		return driver.findElement(title);
	}
	public WebElement gestionModelLink() {
		return driver.findElement(gestionModelLink);
	}
	
	
	
}
