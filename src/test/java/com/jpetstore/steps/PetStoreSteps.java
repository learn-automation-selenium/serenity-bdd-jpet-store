package com.jpetstore.steps;

import com.jpetstore.pages.AccountsPage;
import com.jpetstore.pages.BasePage;
import com.jpetstore.pages.DashboardPage;
import com.jpetstore.pages.LoginPage;
import com.jpetstore.pages.ProductsPage;
import com.jpetstore.utils.PetCategories;

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
	DashboardPage dashboardPage;
	ProductsPage productsPage;
	
	
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
		basePage.clickSignIn();
		return loginPage.signInIntoJPetStore(uname, pwd);
	}
	
	@Step("Navigate to register new page")
	public AccountsPage navigateToRegisterUserPage() {
		return loginPage.navigateToRegisterUserPage();
	}
	
	@Step("Getting the invalid login credentials message")
	public String getMessageOnInvalidLogin() {
		return loginPage.getMessageOnInvalidLogin();
	}
	
	
	/*******************************************************************
	 ********************  ACCOUNTS PAGE STEPS   ***********************
	 *******************************************************************/
	
	@Step("User enters user accounts info by entering username : {0}, password: {1}, and repeated password : {2}")
	public AccountsPage enterUserInformation(String uname, String pwd, String repeatPwd) {
		return accountsPage.enterUserInformation(uname, pwd, repeatPwd);
	}
	
	@Step("User enters account information by entering firstname: {0}, lastname: {1}, email: {2}, phone: {3}, "
			+ "address1: {4}, address2: {5}, city: {6}, state: {7}, zipCode:{8} and country: {9}")
	public AccountsPage enterAccountInformation(String fname, String lname, String userEmail, String userPhone, 
			String userAddress1, String userAddress2, String userCity, String userState, 
			String userZip, String userCountry) {
		
		return accountsPage.enterAccountInformation(fname, lname, userEmail, userPhone, userAddress1, 
				userAddress2, userCity, userState, userZip, userCountry);
	}
	
	@Step("User enters profile information by selecting language: {0}, category: {1},"
			+ "listEnabled: {2} and bannerEnabled: {3}")
	public AccountsPage enterProfileInformation(String language, String category, boolean isMyListEnabled, 
			boolean isMyBannerEnabled) {
		return accountsPage.enterProfileInformation(language, category, isMyListEnabled, isMyBannerEnabled);
	}
	
	@Step("Saving the user information")
	public DashboardPage saveUserAccountInformation() {
		return accountsPage.saveUserAccountInformation();
	}
	
	
	/*******************************************************************
	 ********************  DASHBORAD PAGE STEPS   ***********************
	 *******************************************************************/
	
	@Step("Getting the greetings message")
	public String getGreetingMessage() {
		return dashboardPage.getGreetingMessage();
	}
	
	@Step("Selecting: {0} the pet from side bar link")
	public ProductsPage selectProductsFromSidebarLink(PetCategories petCategories) {
		return dashboardPage.selectProductsFromSidebarLink(petCategories);
	}
	
	@Step("Selecting: {0} the pet from center image link")
	public ProductsPage selectProductsFromCenterImageLink(PetCategories petCategories) {
		return dashboardPage.selectProductsFromCenterImageLink(petCategories);
	}
	
	
	/*******************************************************************
	 ********************  PRODUCTS PAGE STEPS   ***********************
	 *******************************************************************/
	
	@Step("Selecting the petcategory: {0} for the petname: {1}")
	public ProductsPage selectPetByName(PetCategories petCategories, String petName) {
		return productsPage.selectPetByName(petCategories, petName);
	}
	
	@Step("Adding the product: {0} to the cart")
	public ProductsPage addProductToCart(String productName) {
		return productsPage.addProductToCart(productName);
	}
}