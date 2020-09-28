package bdeb.ProjetFinal;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;

public class TypePersonnalisePageTest extends Base {
	@BeforeMethod
	public void seConnecter() throws Exception {
		driver = initializeDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		lp.getUsername().sendKeys("1995405");
		lp.getPassword().sendKeys("alfresco");
		lp.login().click();

	}
	@Test
	public void Q9_Éditer_les_propriétés_des_panneaux_dans_un_type_personnalisé() {
		
	}
	
	

}
