package com.stepdefinition;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;

public class SelectHotelStep {
	PageObjectManager pom=new PageObjectManager();
	@Then("User should select Hotel")
	public void userShouldSelectHotel() {
	 pom.getSelectHotelPage().selectHotel();
	}

	@Then("User should verify message after Select Hotel as {string}")
	public void userShouldVerifyMessageAfterSelectHotelAs(String expectedSelectHotelPagemessage) {
		pom.getSelectHotelPage().bookhotelmsg(expectedSelectHotelPagemessage);
	}

	@Then("User should click continue without select any Hotel")
	public void userShouldClickContinueWithoutSelectAnyHotel() {
		pom.getSelectHotelPage().selectHotelwithoutclick();
	}

	@Then("User should verify select Hotel page error message {string}")
	public void userShouldVerifySelectHotelPageErrorMessage(String expectedSelectHotelPageErrormessage) {
		pom.getSelectHotelPage().selectHotelerroreMsg(expectedSelectHotelPageErrormessage);
	}


}
