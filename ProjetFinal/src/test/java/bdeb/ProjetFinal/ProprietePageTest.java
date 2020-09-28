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
import pageObjects.TypePersonnalisePage;
import resources.Base;

public class ProprietePageTest extends Base {
	@BeforeMethod
	public void seConnecter() throws Exception {
		driver = initializeDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		lp.getUsername().sendKeys("1995405");
		lp.getPassword().sendKeys("alfresco");
		lp.login().click();

	}
	@Test (priority = 1)
	public void RQ9_Modifier_une_propriete_dans_un_type_personnalise () throws Exception{
		String vEspaceNom = "111EspaceM";
		String vPrefix = "111Nm";
		String vNomModel = "111MNatalia0";
		String vCreateur = "111MataliaZo";
		String vDescription = "MMoi7";
		String vTypeName = "MTypeNat7";
		String vLibelle = "MNN7";
		String vLibelleNew = "MNN7New";
		String vProprName  = "MNatalia";
		String vProprLabelle ="MNat";
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
		//aller a la page du type personnalise
		mp.choiType().click();
		//Creer un propriete
		TypePersonnalisePage tp = new TypePersonnalisePage(driver, vTypeName);
		Thread.sleep(2000);
		//tp.creerProprietLien(vTypeName).click();		
		tp.creerPropriete( vProprName, vProprLabelle, vDescription);
		//aller a type personnalise
		hm.outilAdmin().click();
		ad.gestionModelLink().click();
		gm.modName(vNomModel).click();
		mp.choiType().click();
		Thread.sleep(2000);
		//Cliquer sur le menu Action du propriete:
		tp.action(vTypeName).click();
		//Cliquer sur le lient Modifier
		tp.modifierProprLien(vTypeName).click();
		//Effacer la contenue du champ 
		tp.nameEditeChamp().clear();
		//Saisir les nouveaux donnee
		tp.nameEditeChamp().sendKeys(vLibelleNew);
		//Cliquer OK
		tp.editerOk().click();
		//Valider que le labeill a ete change
		Thread.sleep(3000);
		Assert.assertEquals(vLibelleNew, tp.placeLabelle().getText());
		//Supprimer le modele cree
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
