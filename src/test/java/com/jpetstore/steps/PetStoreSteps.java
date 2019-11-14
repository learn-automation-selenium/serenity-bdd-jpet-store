package com.jpetstore.steps;

import com.jpetstore.pages.AccountsPage;
import com.jpetstore.pages.BasePage;
import com.jpetstore.pages.DashboardPage;
import com.jpetstore.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class PetStoreSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BasePage basePage;
	LoginPage loginPage;
	AccountsPage accountsPage;
	
	
	/*******************************************************************
	 ********************  BASE PAGE STEPS   ***************************
	 *******************************************************************/
	
	@Step("Signing out from the Pet store")
	public DashboardPage clickSignOut() {
		return basePage.clickSignOut();
	}
	
	@Step("Navigating to Sign in page")
	public LoginPage navigateToSignInPage() {
		return basePage.navigateToSignInPage();
	}
	
	
	/*******************************************************************
	 *******************  LOGIN PAGE STEPS   ***************************
	 *******************************************************************/
	
	@Step("Logging into Petstore using username : {0} and password: {1}")
	public DashboardPage signInIntoJPetStore(String uname, String pwd) {
		return loginPage.signInIntoJPetStore(uname, pwd);
	}
	
	
	/*******************************************************************
	 ********************  ACCOUNTS PAGE STEPS   ***********************
	 *******************************************************************/
	
	@Step("User user accounts info by entering username : {0}, password: {1}, and repeated password : {2}")
	public AccountsPage enterUserInformation(String uname, String pwd, String repeatPwd) {
		return accountsPage.enterUserInformation(uname, pwd, repeatPwd);
	}
	
}
