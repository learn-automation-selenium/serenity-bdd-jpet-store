package com.jpetstore.pages;

import com.jpetstore.utils.PetCategories;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BasePage extends PageObject{

	public static final String WELCOME_MSG = "Welcome to JPetStore 6";
	
	@FindBy(how=How.XPATH, using="//a[contains(text(), 'Enter the Store')]")
	WebElementFacade enterStoreLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='MenuContent']//a[contains(text(),'Sign In')]")
	WebElementFacade signInLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='MenuContent']//a[contains(text(), 'Sign Out')]")
	WebElementFacade signOutLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='QuickLinks']/a[@href='/actions/Catalog.action?viewCategory=&categoryId=FISH']")
	WebElementFacade fishLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='QuickLinks']/a[@href='/actions/Catalog.action?viewCategory=&categoryId=DOGS']")
	WebElementFacade dogsLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='QuickLinks']/a[@href='/actions/Catalog.action?viewCategory=&categoryId=REPTILES']")
	WebElementFacade reptilesLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='QuickLinks']/a[@href='/actions/Catalog.action?viewCategory=&categoryId=CATS']")
	WebElementFacade catsLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='QuickLinks']/a[@href='/actions/Catalog.action?viewCategory=&categoryId=BIRDS']")
	WebElementFacade birdsLink;
	
	public LoginPage navigateToSignInPage() {
		open();
		waitForTextToAppear(WELCOME_MSG);
		waitFor(enterStoreLink).click();
		//waitFor(signInLink).click();
		return this.switchToPage(LoginPage.class);
	}
	
	public LoginPage clickSignIn() {
		waitFor(signInLink).click();
		return this.switchToPage(LoginPage.class);
	}
	
	public DashboardPage clickSignOut() {
		waitFor(signOutLink).click();
		return this.switchToPage(DashboardPage.class);
	}
	
	
	public ProductsPage navigateToProductsPage(PetCategories productCategory) {
		switch (productCategory) {
		case FISH:
			waitFor(fishLink).click();
			return this.switchToPage(ProductsPage.class);
		case DOGS:
			waitFor(dogsLink).click();
			return this.switchToPage(ProductsPage.class);
		case REPTILES:
			waitFor(reptilesLink).click();
			return this.switchToPage(ProductsPage.class);
		case CATS:
			waitFor(catsLink).click();
			return this.switchToPage(ProductsPage.class);
		case BIRDS:
			waitFor(birdsLink).click();
			return this.switchToPage(ProductsPage.class);
		default:
			break;
		}
		return null;
	}
}
