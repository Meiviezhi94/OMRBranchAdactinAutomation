package com.stepdefinition;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;

public class CancelBookingStep extends BaseClass {

	PageObjectManager pom=new PageObjectManager();
	
	@Then("User should cancel the Order Id")
	public void userShouldCancelTheOrderId() throws InterruptedException {
		Thread.sleep(10000);
		//String orderId = pom.getBookingConfirmationPage().getOrderId();
		pom.getCancelBookingPage().cancel(pom.getBookingConfirmationPage().getOrderId());
	}

	@Then("User should verify Booked Itinerary page after cancel booking with message as {string}")
	public void userShouldVerifyBookedItineraryPageAfterCancelBookingWithMessageAs(String expectedcancelbookingmessage) throws InterruptedException {
		pom.getCancelBookingPage().cancelbookingpagemsg(expectedcancelbookingmessage);
	}

	@Then("User should cancel the {string}")
	public void userShouldCancelThe(String attribute) throws Exception 
	{
		pom.getCancelBookingPage().cancel(attribute);
	
	}

}
