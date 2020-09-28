package bdeb.ProjetFinal;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import pageObjects.GestionModelesPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OutilAdminPage;
import resources.Base;

public class GestionModelesPageTest extends Base {

	@BeforeMethod
	public void seConnecter() throws Exception {
		driver = initializeDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		lp.getUsername().sendKeys("1995405");
		lp.getPassword().sendKeys("alfresco");
		lp.login().click();

	}

	@Test(priority = 1)
	public void RQ9_Modifier_Un_Modele() throws Exception {
		String vEspaceNom = "Espace0";
		String newEspaceNom = "NewEspace0";
		String vPrefix = "N0";
		String vNomModel = "1Natalia0";
		String vCreateur = "NataliaZo0";
		String vDescription = "Moi0";
		// Cliquer sur le lien OutilAdmin
		HomePage hm = new HomePage(driver);
		hm.outilAdmin().click();
		// Cliquer sur le lien Gestionnaire des modeles
		OutilAdminPage ad = new OutilAdminPage(driver);
		ad.gestionModelLink().click();
		// Preconditions: creation du modele et de type personnalise
		GestionModelesPage gm = new GestionModelesPage(driver, vNomModel);
		gm.creerModel(vEspaceNom, vPrefix, vNomModel, vCreateur, vDescription);
		Thread.sleep(4000);
		// Appuyer sur le button Action
		// gm.setVNomModel(vNomModel);
		gm.action(vNomModel).click();
		// Cliquer sur le lien Modifier
		gm.modifier().click();
		Thread.sleep(2000);
		// Supprimer la contenue du champe EspaceNom
		gm.espaceNomModifier().clear();
		Thread.sleep(2000);
		// Saisir le nouveau EspaceNom:
		gm.espaceNomModifier().sendKeys(newEspaceNom);
		Thread.sleep(2000);
		// Cliquer OK
		gm.modifierOk().click();
		Thread.sleep(2000);
		// Verifier que l<espace du Nom a ete change
		Assert.assertEquals(newEspaceNom, gm.modName(newEspaceNom).getText());
		// Supprimer modele
		Thread.sleep(2000);
		String status = gm.identifierStatus(vNomModel);
		gm.supprimerModel(vNomModel, status);
	}

	@AfterMethod
	public void seDecconecter() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getWelcome().click();
		Thread.sleep(3000);
		hp.logOut().click();
		driver.close();
	}

}
