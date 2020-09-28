package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModelePage {
	String vNomModel;
	String vTypeName;
	
	//Web elements:
	By creerTypeButton = By.xpath("//span[text()='Créer un type personnalisé']");
	//Formulaire de Type personnalise:
	By nameType = By.xpath("//div[@id = \"CMM_CREATE_TYPE_DIALOG\"]//following::*[@name = \"name\"]");
	By typeLibelle = By.xpath("//div[@id = \"CMM_CREATE_TYPE_DIALOG\"]//following::*[@name = \"title\"]");
	By typeDescription = By.xpath("//div[@id = \"CMM_CREATE_TYPE_DIALOG\"]//following::*[@name = \"description\"]");
	By creeOKButton = By.xpath("//span[@id='CMM_CREATE_TYPE_DIALOG_OK_label']");
	By actionTypeLink = By.xpath("//span[contains(text(), '"+vTypeName+"')]/following::td[4]/div/div/div/span[2]");
	By modifierTypeLink = By.xpath("//div[@class = \"dijitPopup Popup\"][1]/div/div/div[2]/table/tbody/tr[2]/td[1]/img");
	By modifierOK = By.id("CMM_EDIT_TYPE_DIALOG_OK_label");
	By placeLabelle = By.xpath("//td[@class=\"alfresco-lists-views-layouts-Cell displayLabelColumn smallpad\"]/span/span/span[2]");
	By typeLibbelleEdit = By.xpath("//input[@name = \"title\"]");
	By choiType = By.xpath("//td[@class = \"alfresco-lists-views-layouts-Cell nameColumn smallpad\"]//span[contains(text(),'"+vTypeName+"')]");
	public WebDriver driver;
	public ModelePage(WebDriver driver, String vNomModel, String vTypeName ) {
		this.vNomModel = vNomModel;
		this.driver = driver;
		this.vTypeName = vTypeName;
	}
	public void setvTypeName(String a) {
		vTypeName = a;
	}
	public String getvTypeName() {
		return vTypeName;
		
	}
	public WebElement actionTypLink(String vTypeName) {
		By actionTypeLink = By.xpath("//span[contains(text(),'"+ vTypeName +"')]/following::td[4]/div/div/div/span[2]");
		return driver.findElement(actionTypeLink);
	}
	
	public WebElement choiType() {
		By choiType = By.xpath("//td[@class = \"alfresco-lists-views-layouts-Cell nameColumn smallpad\"]//span[contains(text(),'"+vTypeName+"')]");
		return driver.findElement(choiType);
	}
	public WebElement modifierTypeLink() {
		return driver.findElement(modifierTypeLink);
	}
	public WebElement typeLibbelleEdit() {
		return driver.findElement(typeLibbelleEdit);
	}
	public WebElement typeLibelle() {
		return driver.findElement(typeLibelle);
	}
	public WebElement creerTypeButton() {
		return driver.findElement(creerTypeButton);
	}
	public WebElement placeLabelle() {
		return driver.findElement(placeLabelle);
	}
	
	public WebElement modifierOK() {
		return driver.findElement(modifierOK);
	}
	public WebElement nameType() {
		return driver.findElement(nameType);
	}
	public WebElement typeDescription() {
		return driver.findElement(typeDescription);
	}
	public WebElement creeOKButton() {
		return driver.findElement(creeOKButton);
	}
	
	public void creeTypePersonnalise(String vNomModel, String vTypeName, String vLibelle, String vDescription)
			throws Exception {
		// click sur le boutton creer un type personnalisé
		driver.findElement(creerTypeButton).click();
		// remplis le formulaire de creation de type perso
		driver.findElement(nameType).sendKeys(vTypeName);
		driver.findElement(typeLibelle).sendKeys(vLibelle);
		driver.findElement(typeDescription).sendKeys(vDescription);
		// attendre que le bouton creer soit activé
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(creeOKButton));
		// Click sur le boutton creer une fois actif
		driver.findElement(creeOKButton).click();
	}
	
	
	

}
