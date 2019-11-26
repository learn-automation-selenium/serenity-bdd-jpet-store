package com.jpetstore.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.jpetstore.steps.PetStoreSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class LoginPageTest {

	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps store;
	
	@Test
	@Title("Verify if the user is able to login into petstores using valid credentials")
	public void verifyIfUserIsAbleToLogin() {
		store.navigateToSignInPage();
		store.signInIntoJPetStore("j2ee", "j2ee");
		String greetingMessage = store.getGreetingMessage();
		Assert.assertEquals("Welcome ABC!", greetingMessage);
	}
	
	@Test
	@Title("Verify if the user is able to logout from the application after successful login")
	public void verifyIfUserIsAbleToLogout() {
		store.navigateToSignInPage();
		store.signInIntoJPetStore("j2ee", "j2ee");
		store.clickSignOut();
	}
	
	@Test
	@Title("Verify the message <b><i> Invalid username or password. Signon failed. </i></b> for invalid credentials")
	public void verifyErrorMessageForInvalidLogin() {
		store.navigateToSignInPage();
		store.signInIntoJPetStore("j2eee", "j2ee");
		String invalidLoginMsg = store.getMessageOnInvalidLogin();
		Assert.assertEquals("Invalid username or password. Signon failed.", invalidLoginMsg);
	}
}
