package com.jpetstore.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountsPage extends BasePage {

	@FindBy(how=How.XPATH, using="//input[@name='username']")
	WebElementFacade username;
	
	@FindBy(how=How.XPATH, using="//input[@name='password']")
	WebElementFacade password;
	
	@FindBy(how=How.XPATH, using="//input[@name='repeatedPassword']")
	WebElementFacade repeatedPassword;
	
	/**
	 * Method to enter the details for user information
	 * @param uname
	 * @param pwd
	 * @param repeatPwd
	 * @return
	 */
	public AccountsPage enterUserInformation(String uname, String pwd, String repeatPwd) {
		waitForTextToAppear("User Information");
		username.type(uname);
		password.type(pwd);
		repeatedPassword.type(repeatPwd);
		return this;
	}
}
