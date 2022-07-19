package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class BookingConfirmationPage extends BaseClass {
	
	public BookingConfirmationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//td[contains(text(),'Booking')]")
	public WebElement msgBookingconfirmation;
	
	@FindBy(id="order_no")
	public WebElement Order_id;
	
	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	public WebElement BookedItinerary;

	public WebElement getMsgBookingconfirmation() {
		return msgBookingconfirmation;
	}

	public WebElement getOrder_id() {
		return Order_id;
	}

	public WebElement getBookedItinerary() {
		return BookedItinerary;
	}
	
	public String getOrderId() {
		String attribute = getAttribute(getOrder_id());
		System.out.println(attribute);
		return attribute;
		
	}
	
	public void bookingconfirmassert(String bookingconfirmationmessage) throws InterruptedException
	{
		Thread.sleep(30000);
		Assert.assertEquals("Verify booking confirmation message", bookingconfirmationmessage, getText(getMsgBookingconfirmation()));
	}
	
	
	}
