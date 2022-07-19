package com.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * 
 * @author Mei
 * @Description LoginStep created to login the application using baseclass methods
 * @Date 08/07/2022
 */
public class LoginStep extends BaseClass {
	
	PageObjectManager pom=new PageObjectManager();
	
	
	@Given("User is on the Adactin page")
	public void userIsOnTheAdactinPage() throws IOException {
		
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @throws Exception 
	 * @Description to perform login with credentials
	 * @Date 08/07/2022
	 */
	@When("User should perform login {string} and {string}")
	public void userShouldPerformLoginAnd(String userName, String password) throws Exception {
		//pom.getLoginPage().login(userName, password);
		pom.getLoginPage().login(userName,password);
	}
	/**
	 * 
	 * @param userName
	 * @param password
	 * @throws AWTException
	 * @throws IOException 
	 * @Description to perform login with credentials by using enter key
	 */
	@When("User should perform login {string} and {string} with enter key")
	public void userShouldPerformLoginAndWithEnterKey(String userName, String password) throws AWTException, IOException {
		pom.getLoginPage().loginWithEnter(getPropertyValue("userName"), getPropertyValue("password"));
	}
	
	/**
	 * 
	 * @param expectedErrorMessage
	 * @Description to check
	 */
	@Then("User should verify after login error message contains {string}")
	public void userShouldVerifyAfterLoginErrorMessageContains(String expectedErrorMessage) {
		pom.getLoginPage().loginAssert(expectedErrorMessage);
	}
	
	


	

}
