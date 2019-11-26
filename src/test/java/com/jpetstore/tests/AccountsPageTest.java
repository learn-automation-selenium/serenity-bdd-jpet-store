package com.jpetstore.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;
import com.jpetstore.steps.PetStoreSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class AccountsPageTest {

	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps store;
	
	@Test
	@Title("Add a new user and verify if the new user is able to login with the provided credentials")
	public void addNewUserAndVerify() {
		
		Faker faker = new Faker();
		String uname = "test" + faker.number().randomNumber(100, false);
		String pwd = faker.internet().password();
		String repeatPwd = pwd;
		String fname = faker.name().firstName();
		String lname = faker.name().lastName();
		String userEmail = faker.internet().emailAddress();
		String userPhone = faker.phoneNumber().cellPhone();
		String userAddress1 =  faker.address().buildingNumber();
		String userAddress2 = faker.address().streetAddress();
		String userCity = faker.address().city();
		String userState = faker.address().state();
		String userZip = faker.address().zipCode();
		String userCountry = faker.address().country();
		
		store.navigateToSignInPage();
		store.navigateToRegisterUserPage();
		store.enterUserInformation(uname, pwd, repeatPwd);
		store.enterAccountInformation(fname, lname, userEmail, userPhone, 
				userAddress1, userAddress2, userCity, userState, userZip, userCountry);
		store.enterProfileInformation("english", "DOGS", true, true);
		store.saveUserAccountInformation();
		
		store.signInIntoJPetStore(uname, pwd);
		
		String welcomeMsg = store.getGreetingMessage();
		Assert.assertEquals("Welcome " + fname + "!", welcomeMsg);
	}
}
