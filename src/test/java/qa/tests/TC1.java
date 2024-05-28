package qa.tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.*;
import utils.*;
import pageObjects.*;

public class TC1 extends BaseTest {
ElementFetch ele= new ElementFetch();
HomePageEvents homePage=new HomePageEvents();
LoginPageEvents loginPage = new LoginPageEvents();

	
	@Test
public void sampleMethodforEnteringCreds() {
	homePage.signInButton();
	loginPage.verfiyLoginPageLoad();
	loginPage.enterCreds();
}
}
