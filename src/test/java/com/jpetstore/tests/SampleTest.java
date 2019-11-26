package com.jpetstore.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.jpetstore.steps.PetStoreSteps;
import com.jpetstore.utils.PetCategories;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class SampleTest {

	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps store;
	
	@Test
	@Title("testing of image navigation link")
	public void test001() throws InterruptedException {
		
		store.navigateToSignInPage();
		store.selectProductsFromCenterImageLink(PetCategories.REPTILES);
		store.selectPetByName(PetCategories.REPTILES, "Rattlesnake");
		Thread.sleep(5000);
	}
}
