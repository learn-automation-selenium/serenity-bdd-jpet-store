package com.jpetstore.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends BasePage {

	@FindBy(how=How.CSS, using="input[name='username']")
	WebElementFacade username;
	
	@FindBy(how=How.CSS, using="input[name='password']")
	WebElementFacade password;
	
	@FindBy(how=How.CSS, using="input[name='signon']")
	WebElementFacade signOn;
	
	@FindBy(how=How.XPATH, using="//div[@id='Catalog']//a[contains(text(),'Register Now!')]")
	WebElementFacade registerNow;
	
	@FindBy(how=How.XPATH, using="//div[@id='Content']//li")
	WebElementFacade invalidLoginMsg;
	
	/**
	 * Method to login into j-pet store application
	 * @param uname
	 * @param pwd
	 * @return
	 */
	public DashboardPage signInIntoJPetStore(String uname, String pwd) {
		waitForTextToAppear("Please enter your username and password.");
		waitFor(username).type(uname);
		password.type(pwd);
		signOn.click();
		return this.switchToPage(DashboardPage.class);
	}
	
	/**
	 * Method to navigate to Registration page for new user
	 * @return
	 */
	public AccountsPage navigateToRegister() {
		waitForTextToAppear("Please enter your username and password.");
		registerNow.click();
		return this.switchToPage(AccountsPage.class);
	}
	
	/**
	 * Method to fetch the message on invalid login
	 * @return
	 */
	public String getMessageOnInvalidLogin() {
		return invalidLoginMsg.getText();
	}
}
