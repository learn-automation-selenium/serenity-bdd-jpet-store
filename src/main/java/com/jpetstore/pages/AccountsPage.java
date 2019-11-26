package com.jpetstore.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webelements.Checkbox;

public class AccountsPage extends BasePage {

	@FindBy(how=How.XPATH, using="//input[@name='username']")
	WebElementFacade username;
	
	@FindBy(how=How.XPATH, using="//input[@name='password']")
	WebElementFacade password;
	
	@FindBy(how=How.XPATH, using="//input[@name='repeatedPassword']")
	WebElementFacade repeatedPassword;
	
	@FindBy(how=How.XPATH, using="//input[@name='account.firstName']")
	WebElementFacade firstName;
	
	@FindBy(how=How.XPATH, using="//input[@name='account.lastName']")
	WebElementFacade lastName;
	
	@FindBy(how=How.XPATH, using="//input[@name='account.email']")
	WebElementFacade email;
	
	@FindBy(how=How.XPATH, using="//input[@name='account.phone']")
	WebElementFacade phone;
	
	@FindBy(how=How.XPATH, using="//input[@name='account.address1']")
	WebElementFacade address1;
	
	@FindBy(how=How.XPATH, using="//input[@name='account.address2']")
	WebElementFacade address2;
	
	@FindBy(how=How.XPATH, using="//input[@name='account.city']")
	WebElementFacade city;
	
	@FindBy(how=How.XPATH, using="//input[@name='account.state']")
	WebElementFacade state;
	
	@FindBy(how=How.XPATH, using="//input[@name='account.zip']")
	WebElementFacade zip;
	
	@FindBy(how=How.XPATH, using="//input[@name='account.country']")
	WebElementFacade country;
	
	@FindBy(how=How.XPATH, using="//select[@name='account.languagePreference']")
	WebElementFacade languagePreference;
	
	@FindBy(how=How.XPATH, using="//select[@name='account.favouriteCategoryId']")
	WebElementFacade favouriteCategory;
	
	@FindBy(how=How.XPATH, using="//input[@name='account.listOption']")
	WebElementFacade enableMyList;
	
	@FindBy(how=How.XPATH, using="//input[@name='account.bannerOption']")
	WebElementFacade enableMyBanner;
	
	@FindBy(how=How.XPATH, using="//input[@name='newAccount']")
	WebElementFacade newAccountBtn;
	
	
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
	
	/**
	 * Method to enter the details of Accounts Information
	 * @param fname
	 * @param lname
	 * @param userEmail
	 * @param userPhone
	 * @param userAddress1
	 * @param userAddress2
	 * @param userCity
	 * @param userState
	 * @param userZip
	 * @param userCountry
	 * @return
	 */
	public AccountsPage enterAccountInformation(String fname, String lname, String userEmail, String userPhone, 
			String userAddress1, String userAddress2, String userCity, String userState, 
			String userZip, String userCountry) {
		
		waitForTextToAppear("Account Information");
		firstName.type(fname);
		lastName.type(lname);
		email.type(userEmail);
		phone.type(userPhone);
		address1.type(userAddress1);
		address2.type(userAddress2);
		city.type(userCity);
		state.type(userState);
		zip.type(userZip);
		country.type(userCountry);
		return this;
	}

	/**
	 * Method to enter the details for profile information
	 * @param language
	 * @param category
	 * @param isMyListEnabled
	 * @param isMyBannerEnabled
	 * @return
	 */
	public AccountsPage enterProfileInformation(String language, String category, boolean isMyListEnabled, 
			boolean isMyBannerEnabled) {
		languagePreference.selectByVisibleText(language);
		favouriteCategory.selectByVisibleText(category);
		new Checkbox(enableMyList).setChecked(isMyListEnabled);
		new Checkbox(enableMyBanner).setChecked(isMyBannerEnabled);
		return this;
	}
	
	/**
	 * Method to Save the Account information
	 * @return
	 */
	public DashboardPage saveUserAccountInformation() {
		waitFor(newAccountBtn).click();
		return this.switchToPage(DashboardPage.class);
	}
}
