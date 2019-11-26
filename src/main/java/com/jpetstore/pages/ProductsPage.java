package com.jpetstore.pages;

import com.jpetstore.utils.PetCategories;

//static import for Bean Matchers
import static net.thucydides.core.matchers.BeanMatchers.*;
import static net.thucydides.core.pages.components.HtmlTable.inTable;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductsPage extends BasePage {

	@FindBy(how=How.XPATH, using="//div[@id='Catalog']/table")
	WebElementFacade productsTable;
	
	/**
	 * Method to click on the particular products
	 * 
	 * @param petCategories
	 * @param petName
	 * @return
	 */
	public ProductsPage selectPetByName(PetCategories petCategories, String petName) {
		waitForTextToAppear(petCategories.getValue());
		List<WebElement> petDetails = inTable(productsTable).filterRows(the("Name", equalTo(petName)));
		petDetails.get(0).findElement(By.tagName("a")).click();
		return this;
	}
}
