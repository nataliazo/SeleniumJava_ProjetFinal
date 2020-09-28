package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TypePersonnalisePage {
	String vTypeName;
	By creerProprietLien = By.xpath("//div[@role=\"tabpanel\"][3]/div/div/div[4]/div/div/span[2]");
	By action = By.xpath("//span[contains(text(), '"+vTypeName+"')]/following::*[text()=\"Actions\"][last()]");
	//Formulaire de Proprietaire:
	By nameChamp = By.xpath("//span[@id = \"CMM_CREATE_PROPERTY_DIALOG_title\"]/following::input[@name = \"name\"]");
	By nameEditeChamp = By.xpath("//span[@id = \"CMM_EDIT_PROPERTY_DIALOG_title\"]/following::input[@name = \"title\"]");
	By libelleChamp = By.xpath("//span[@id = \"CMM_CREATE_PROPERTY_DIALOG_title\"]/following::input[@name = \"title\"]");
	By descriptChamp = By.xpath("//span[@id = \"CMM_CREATE_PROPERTY_DIALOG_title\"]/following::textarea[@name = \"description\"]");
	By creerOK = By.id("CMM_CREATE_PROPERTY_DIALOG_CREATE_label");
	By editerOk = By.id("CMM_EDIT_PROPERTY_DIALOG_SAVE_label");
	By modifierProprLien = By.xpath("//span[contains(text(), \"popo\")]/following::td[text()=\"Modifier\"][last()]");
	By placeLabelle = By.xpath("//span[text()=\"MNN7New\"]");
	public WebDriver driver;
	public TypePersonnalisePage(WebDriver driver,  String vTypeName ) {
		this.driver = driver;
		this.vTypeName = vTypeName;
	}
	public void setvTypeName(String a) {
		vTypeName = a;
	}
	public String getvTypeName() {
		return vTypeName;
			}
	public WebElement modifierProprLien(String vTypeName) {
		By modifierProprLien = By.xpath("//span[contains(text(), \"popo\")]/following::td[text()=\"Modifier\"][last()]");	
		return driver.findElement(modifierProprLien);
	}
	public WebElement action(String vTypeName) {
		By action = By.xpath("//span[contains(text(), '"+vTypeName+"')]/following::*[text()=\"Actions\"][last()]");
		return driver.findElement(action);
	}
	public WebElement editerOk() {
		return driver.findElement(editerOk);
	}
	public WebElement nameEditeChamp() {
		return driver.findElement(nameEditeChamp);
	}
	public WebElement creerOK() {
		return driver.findElement(creerOK);
	}
	public WebElement placeLabelle() {
		return driver.findElement(placeLabelle);
	}
	public WebElement descriptChamp() {
		return driver.findElement(descriptChamp);
	}
	public WebElement libelleChamp() {
		By libelleChamp = By.xpath("//span[@id = \"CMM_CREATE_PROPERTY_DIALOG_title\"]/following::input[@name = \"title\"]");
		return driver.findElement(libelleChamp);
	}
	public WebElement nameChamp() {
		By nameChamp = By.xpath("//span[@id = \"CMM_CREATE_PROPERTY_DIALOG_title\"]/following::input[@name = \"name\"]");
		return driver.findElement(nameChamp);
	}
	
	public WebElement creerProprietLien() {
		return driver.findElement(creerProprietLien);
	}
	
	public void creerPropriete( String nameProp, String libelleProp, String descripPropr) throws InterruptedException {		
		//cliquer sur le lien "Creer un proprietaire"
		Thread.sleep(2000);
		creerProprietLien().click();
		//remplir le formulaire de Proprietaire
		driver.findElement(nameChamp).sendKeys(nameProp);
		driver.findElement(libelleChamp).sendKeys(libelleProp);
		driver.findElement(descriptChamp).sendKeys(descripPropr);
		//Cliquer OK
		driver.findElement(creerOK).click();
				
		
	}
	
	
	
	
	
	
}
