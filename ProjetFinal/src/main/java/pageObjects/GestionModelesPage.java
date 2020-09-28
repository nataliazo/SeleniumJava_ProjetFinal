package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

public class GestionModelesPage {
	String vNomModel;
	By modName = (By.xpath("//span[text()='" + vNomModel + "']"));
	By action = By.xpath("//*[(text()='" + vNomModel + "')]/following::*[(text()=\"Actions\")][1]");
	By modifier = By.xpath("//div[@class = \"dijitPopup Popup\"]/div/div/div[2]/table/tbody/tr[2]/td[2]");
	By supprimerMod = By.xpath("//div[@class = \"dijitPopup Popup\"]/div/div/div[2]/table/tbody/tr[3]");
	By creerModelButton = By.xpath("//span[text()=\"Créer un modèle\"]");
	By statusModel = By.xpath("//span[text()='" + vNomModel + "']/ancestor::tr/td[3]/span/span/span[2]");
	By desactive = By.xpath("//div[@class = \"dijitPopup Popup\"]/div/div/div[2]/table/tbody/tr[1]/td[2]");
	By supprimerOk = By.xpath("//div[@class = \"footer\"] /span[1]");
	// Form de creation de nouveau modele:
	By espaceNom = By.xpath("//input[@name = \"namespace\"]");
	By espaceNomModifier = By.xpath("//span[text() = \"Modifier le modèle\"]/following::input[@name=\"namespace\"]");
	By prefix = By.xpath("//input[@name=\"prefix\"]");
	By modelName = By.xpath("//input[@name=\"name\"]");
	By createur = By.xpath("//input[@name=\"author\"]");
	By description = By.xpath("//div[@class=\"control\"]/textarea[@name=\"description\"]");
	By creerOK = By.id("CMM_CREATE_MODEL_DIALOG_OK_label");
	By modifierOk = By.id("CMM_EDIT_MODEL_DIALOG_OK_label");
	public WebDriver driver;
	

	public GestionModelesPage(WebDriver driver, String vNomModel) {
		this.vNomModel = vNomModel;
		this.driver = driver;
	}

	public void setVNomModel(String a) {
		vNomModel = a;
	}
	public String getvNomModel() {
		return vNomModel;
		
	}

	public WebElement espaceNomModifier() {
		return driver.findElement(espaceNomModifier);
	}
	public WebElement modifierOk() {
		return driver.findElement(modifierOk);
	}

	public WebElement action(String vNomModel) {
		By action = By.xpath("//*[(text()='" + vNomModel + "')]/following::*[(text()=\"Actions\")][1]");
		return driver.findElement(action);
	}

	public String getNomModel() {
		return vNomModel;
	}

	public WebElement supprimerMod() {
		return driver.findElement(supprimerMod);
	}

	public WebElement modifier() {
		return driver.findElement(modifier);
	}

	public WebElement modName(String vNomModel) {
		By modName = (By.xpath("//span[text()='" + vNomModel + "']"));
		return driver.findElement(modName);
	}

	public String identifierStatus(String vNomModel) {
		By statusModel = By.xpath("//span[text()='" + vNomModel + "']/ancestor::tr/td[3]/span/span/span[2]");
		String status = driver.findElement(statusModel).getText();	
		return status;		
	}
	
	public WebElement desactive(String vNomModel) {
		return driver.findElement(desactive);
	}

	public WebElement supprimerOk() {
		return driver.findElement(supprimerOk);
	}

	public WebElement espaceNom() {
		return driver.findElement(espaceNom);
	}

	public WebElement prefix() {
		return driver.findElement(prefix);
	}

	public WebElement modelName() {
		return driver.findElement(modelName);
	}

	public WebElement createur() {
		return driver.findElement(createur);
	}

	public WebElement description() {
		return driver.findElement(description);
	}

	public WebElement creerOK() {
		return driver.findElement(creerOK);
	}

	public void creerModel(String vEspaceNom, String vPrefix, String vNomModel, String vCreateur, String vDescription)
			throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		// Verification qu'on est dans la page neccesaire
		wait.until(ExpectedConditions.titleIs("Alfresco » Gestionnaire de modèles"));
		// Clique sur le bouton "Creer un modele"
		driver.findElement(creerModelButton).click();
		// Remplir le formulaire de creation du modele
		// Saisir le valeur vEspaceNom:
		driver.findElement(espaceNom).sendKeys(vEspaceNom);
		// Saisir le valeur vPrefix:
		driver.findElement(prefix).sendKeys(vPrefix);
		// Saisir le valeur vNom:
		driver.findElement(modelName).sendKeys(vNomModel);
		// Saisir le valeur vCreateur:
		driver.findElement(createur).sendKeys(vCreateur);
		// Saisir le valeur vDescription:
		driver.findElement(description).sendKeys(vDescription);
		Thread.sleep(1000);
		// Clique sur le bouton OK
		driver.findElement(creerOK).click();
		Thread.sleep(2000);
		// Point de verification:
		/*try {
			Assert.assertEquals(vNomModel,
					driver.findElement(By.xpath("//span[text() ='" + vNomModel + "']")).getText());
			Thread.sleep(4000);
		} catch (Error e) {
			fail("Link with text " + vNomModel + " isn't present");
		}*/
	}

	
	public void supprimerModel(String vNomModel, String status) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);	
		// vNom - contien le nom du modele a supprimer
		// S'assurer que la page est chargee:
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// Cliquer sur "Outil admin", puis sur le lien "Gestionnaire des modeles:
		HomePage hp = new HomePage(driver);
		hp.outilAdmin().click();
		OutilAdminPage out = new OutilAdminPage(driver);
		out.gestionModelLink().click();
		// Verification qu'on est dans la page neccesaire
		wait.until(ExpectedConditions.titleIs("Alfresco » Gestionnaire de modèles"));
		Thread.sleep(2000);
		//Identifier le status du modele (Actife ou Inactif)
		//String status = driver.findElement(statusModel).getText();		
		Thread.sleep(2000);
		//Si le modelele est "Actif" tout d'abour il faut le desactiver pour etre capable de le supprimer:
		if (status.equals("Actif")) { 
			action(vNomModel).click();
			Thread.sleep(4000);
			desactive(vNomModel).click();
			Thread.sleep(4000);
		}
		//Clique sur le lien "Action"
		action(vNomModel).click();
		//driver.findElement(action).click();
		Thread.sleep(2000);
		//Clique sur le lien "Supprimer" du menu "Actions"
		driver.findElement(supprimerMod).click();;
		Thread.sleep(1000);
		//Clique sur le bouton "OK" 
		driver.findElement(supprimerOk).click();
		//Point de verification:	
		try {
	        driver.findElement(modName);
	        fail("Link with text " + vNomModel + " is present");
	    } catch (NoSuchElementException ex) { 
	    }
	}
}
