package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;
import gherkin.GenerateTokens;

public class BookHotelStep extends BaseClass
{
	PageObjectManager pom=new PageObjectManager();
	@Then("User should Book Hotel {string},{string}and{string}")
	public void userShouldBookHotelAnd(String FirstName, String LastName, String BillingAddress, io.cucumber.datatable.DataTable dataTable) {
	List<Map<String,String>> m=dataTable.asMaps();
	Map<String,String> e=m.get(0);
	String ccNum = e.get("Credit_Card_No");
	String ccType = e.get("Credit_Card_Type");
	String expMonth = e.get("Expiry_Month");
	String expYear = e.get("Expiry_Year");
	String cvv = e.get("CVV_Number");
	pom.getBookHotelPage().bookHotels(FirstName, LastName, BillingAddress, ccNum, ccType, expMonth, expYear, cvv);
	
	}

	@Then("User should verify the message in Booking confirmation page as {string}")
	public void userShouldVerifyTheMessageInBookingConfirmationPageAs(String expectedBookingConfirmationPagemessage) throws InterruptedException {
		pom.getBookingConfirmationPage().bookingconfirmassert(expectedBookingConfirmationPagemessage);
		
	}
	

	@Then("User should click Book Now without enter any fields")
	public void userShouldClickBookNowWithoutEnterAnyFields() {
		pom.getBookHotelPage().bookHotels();
	}

	@Then("User should verify Book A Hotel page with error message {string},{string},{string},{string},{string},{string}and{string}")
	public void userShouldVerifyBookAHotelPageWithErrorMessageAnd(String expectedBookAHotelPageErrormessage1,String expectedBookAHotelPageErrormessage2, 
			String expectedBookAHotelPageErrormessage3, String expectedBookAHotelPageErrormessage4, String expectedBookAHotelPageErrormessage5, 
			String expectedBookAHotelPageErrormessage6, String expectedBookAHotelPageErrormessage7) throws InterruptedException {
		pom.getBookHotelPage().bookHotelwithoutenteringfields(expectedBookAHotelPageErrormessage1, expectedBookAHotelPageErrormessage2, expectedBookAHotelPageErrormessage3, expectedBookAHotelPageErrormessage4, expectedBookAHotelPageErrormessage5, expectedBookAHotelPageErrormessage6, expectedBookAHotelPageErrormessage7);
		
	}


}
