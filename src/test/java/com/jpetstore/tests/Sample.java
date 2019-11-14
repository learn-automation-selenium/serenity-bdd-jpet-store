package com.jpetstore.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.jpetstore.steps.PetStoreSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class Sample {

	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps store;
	
	@Test
	@Title("Navigating to Sign In Page")
	public void test001() {
		store.navigateToSignInPage();
		store.signInIntoJPetStore("j2ee", "j2ee");
	}
}
