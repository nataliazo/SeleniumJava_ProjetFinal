package bdeb.ProjetFinal;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.GestionModelesPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ModelePage;
import pageObjects.OutilAdminPage;
import resources.Base;

public class ModelePageTest extends Base {
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
	public void RQ9_Modifier_un_type_personnalise() throws Exception {
		String vEspaceNom = "Espace7";
		String vPrefix = "N7";
		String vNomModel = "2Natalia0";
		String vCreateur = "NataliaZo7";
		String vDescription = "Moi7";
		String vTypeName = "TypeNat7";
		String vLibelle = "NN7";
		String vLibelleNew = "NN7New";

		HomePage hm = new HomePage(driver);
		hm.outilAdmin().click();
		// Cliquer sur le lien Gestionnaire des modeles
		OutilAdminPage ad = new OutilAdminPage(driver);
		ad.gestionModelLink().click();
		// Preconditions: creation du modele et de type personnalise
		GestionModelesPage gm = new GestionModelesPage(driver, vNomModel);
		gm.creerModel(vEspaceNom, vPrefix, vNomModel, vCreateur, vDescription);
		Thread.sleep(4000);
		// Cliquer sur le nom du model cree
		gm.modName(vNomModel).click();
		// Creer un type personnalise:
		ModelePage mp = new ModelePage(driver, vNomModel, vTypeName);
		mp.creeTypePersonnalise(vNomModel, vTypeName, vLibelle, vDescription);
		// Acceder le type personnalise cree:
		hm.outilAdmin().click();
		ad.gestionModelLink().click();
		gm.modName(vNomModel).click();
		// Cliquer sur le lien Modifier:
		Thread.sleep(4000);
		mp.actionTypLink(vTypeName).click();
		// Clquer sur le lien Modifier
		Thread.sleep(2000);
		mp.modifierTypeLink().click();
		Thread.sleep(2000);
		// Changer les donnee:
		mp.typeLibbelleEdit().clear();
		mp.typeLibbelleEdit().sendKeys(vLibelleNew);
		mp.modifierOK().click();
		;
		// point verification
		Thread.sleep(3000);
		Assert.assertEquals(vLibelleNew, mp.placeLabelle().getText());
		// postconditioin: identifier le status du modele et le supprimer
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
