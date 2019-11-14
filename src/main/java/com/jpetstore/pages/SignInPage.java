package com.jpetstore.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;

public class SignInPage extends BasePage {

	@FindBy(how=How.CSS, using="input[name='username']")
	WebElementFacade username;
	
	@FindBy(how=How.CSS, using="input[name='password']")
	WebElementFacade password;
	
	@FindBy(how=How.CSS, using="input[name='signon']")
	WebElementFacade signOn;
	
	
	public DashboardPage signInIntoJPetStore(String uname, String pwd) {
		waitFor(username).type(uname);
		password.type(pwd);
		signOn.click();
		return this.switchToPage(DashboardPage.class);
	}
	
}
