package com.stepdefinition;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchHotelStep extends BaseClass {
	PageObjectManager pom=new PageObjectManager();
	
	@When("User should search hotel using all fields {string},{string},{string},{string},{string},{string},{string}and{string}")
	public void userShouldSearchHotelUsingAllFieldsAnd(String Location, String Hotels, String RoomType, String NumberofRooms, String CheckInDate, 
			String CheckOutDate, String AdultsperRoom, String ChildrenperRoom) {
		pom.getSearchHotelPage().searchhotels(Location, Hotels, RoomType, NumberofRooms, CheckInDate, CheckOutDate, AdultsperRoom, ChildrenperRoom);
	}

	@Then("User should verify navigate to select hotel page with message {string}")
	public void userShouldVerifyNavigateToSelectHotelPageWithMessage(String expectedSelectHotelmessage) {
		pom.getSearchHotelPage().searchHotelAssert(expectedSelectHotelmessage);
	}

	@When("User should search hotel using mandatory fields {string},{string},{string},{string}and{string}")
	public void userShouldSearchHotelUsingMandatoryFieldsAnd(String Location, String NumberofRooms, String CheckInDate, String CheckOutDate, String AdultsperRoom) {
		pom.getSearchHotelPage().searchhotels(Location, NumberofRooms, CheckInDate, CheckOutDate, AdultsperRoom);
	}

	@Then("User should verify Search Hotel page with error message {string},{string}")
	public void userShouldVerifySearchHotelPageWithErrorMessage(String expectSearchHotelPageErrorMessage1, String expectSearchHotelPageErrorMessage2) {
		pom.getSearchHotelPage().searchHotelDateAssert(expectSearchHotelPageErrorMessage1, expectSearchHotelPageErrorMessage2);
	}

	@When("User should search hotel without enter any fields")
	public void userShouldSearchHotelWithoutEnterAnyFields() {
		pom.getSearchHotelPage().searchhotels();
	}

	@Then("User should verify Search Hotel page with error message {string}")
	public void userShouldVerifySearchHotelPageWithErrorMessage(String expectSearchHotelPageErrorMessage) {
		pom.getSearchHotelPage().searchHotellocationAssert(expectSearchHotelPageErrorMessage);
		
	}

}
