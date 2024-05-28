package pageEvents;


import org.testng.Assert;

import pageObjects.HomePageElements;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {
	 ElementFetch ele = new ElementFetch();
		
	public void verfiyLoginPageLoad() {
		
		Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.logInButtonText).size()== 0,"Not found");
	}
	
	public void enterCreds() {
		ele.getWebElement("XPATH", LoginPageElements.emailAdd).sendKeys("xx");
		ele.getWebElement("XPATH", LoginPageElements.pwd).sendKeys("xx");
	}
}
