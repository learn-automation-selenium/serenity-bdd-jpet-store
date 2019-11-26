package com.jpetstore.pages;

import com.jpetstore.utils.PetCategories;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;

public class DashboardPage extends BasePage {

	@FindBy(how=How.XPATH, using="//div[@id='WelcomeContent']")
	WebElementFacade welcomeMessage;
	
	@FindBy(how=How.XPATH, using="//div[@id='SidebarContent']/a[contains(@href, 'FISH')]")
	WebElementFacade fishSideLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='SidebarContent']/a[contains(@href, 'DOGS')]")
	WebElementFacade dogsSideLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='SidebarContent']/a[contains(@href, 'CATS')]")
	WebElementFacade catsSideLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='SidebarContent']/a[contains(@href, 'REPTILES')]")
	WebElementFacade reptilesSideLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='SidebarContent']/a[contains(@href, 'BIRDS')]")
	WebElementFacade birdsSideLink;
	
	@FindBy(how=How.CSS, using="div[id='MainImageContent'] area[href$='BIRDS']")
	WebElementFacade birdCenterImageLink;
	
	@FindBy(how=How.CSS, using="div[id='MainImageContent'] area[href$='FISH']")
	WebElementFacade fishImageLink;
	
	@FindBy(how=How.CSS, using="div[id='MainImageContent'] area[href$='DOGS']")
	WebElementFacade dogsImageLink;
	
	@FindBy(how=How.CSS, using="div[id='MainImageContent'] area[href$='REPTILES']")
	WebElementFacade reptilesImageLink;
	
	@FindBy(how=How.CSS, using="div[id='MainImageContent'] area[href$='CATS']")
	WebElementFacade catsImageLink;
	
	@FindBy(how=How.CSS, using="div[id='MainImageContent'] area[href$='CATS'] + area[href$='BIRDS']")
	WebElementFacade birdsImageLink;
	
	/**
	 * Method to get the greeting message after logging into the pet application
	 * @return
	 */
	public String getGreetingMessage() {
		return waitFor(welcomeMessage).getText();
	}
	
	/**
	 * Method to navigate to the ProductsPage based on the pet categories selected in the side link
	 * 
	 * @param petCategories
	 * @return
	 */
	public ProductsPage selectProductsFromSidebarLink(PetCategories petCategories) {
		switch (petCategories) {
		case FISH:
			waitFor(fishSideLink).click();
			return this.switchToPage(ProductsPage.class);
		case DOGS:
			waitFor(dogsSideLink).click();
			return this.switchToPage(ProductsPage.class);
		case REPTILES:
			waitFor(reptilesSideLink).click();
			return this.switchToPage(ProductsPage.class);
		case CATS:
			waitFor(catsSideLink).click();
			return this.switchToPage(ProductsPage.class);
		case BIRDS:
			waitFor(birdsSideLink).click();
			return this.switchToPage(ProductsPage.class);
		default:
			break;
		}
		return null;
	}
	
	/**
	 * Method to navigate to the ProductsPage based on the pet categories selected on the center image
	 * 
	 * @param petCategories
	 * @return
	 */
	public ProductsPage selectProductsFromCenterImageLink(PetCategories petCategories) {
		switch (petCategories) {
		case FISH:
			waitFor(fishImageLink).click();
			return this.switchToPage(ProductsPage.class);
		case DOGS:
			waitFor(dogsImageLink).click();
			return this.switchToPage(ProductsPage.class);
		case REPTILES:
			waitFor(reptilesImageLink).click();
			return this.switchToPage(ProductsPage.class);
		case CATS:
			waitFor(catsImageLink).click();
			return this.switchToPage(ProductsPage.class);
		case BIRDS:
			waitFor(birdsImageLink).click();
			return this.switchToPage(ProductsPage.class);
		default:
			break;
		}
		return null;
	}
}
