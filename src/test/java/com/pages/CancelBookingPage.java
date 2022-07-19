package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class CancelBookingPage extends BaseClass {
	
	public CancelBookingPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Booked Itinerary']")
	public WebElement buttonitinerary;
	
	@FindBy(id="btn_id_636115")
	public WebElement cancelbutton;
	
	@FindBy(id="order_id_text")
	public WebElement textorderidtext;
	
	@FindBy(id="search_hotel_id")
	public WebElement searchhotelbutton;
	 
	@FindBy(id="check_all")
	public WebElement checkallbutton;
	
	@FindBy(xpath="(//input[@type='submit'])[2]")
	public WebElement cancelselectedbutton;
	
	@FindBy(id="search_result_error")
	public WebElement cancelbookingmsg;
	
	@FindBy(xpath="(//input[@type=\"button\"])[1]")
	public WebElement cancelbookbutton;
	
	
	public WebElement getCancelbookbutton() {
		return cancelbookbutton;
	}

	public WebElement getCancelbookingmsg() {
		return cancelbookingmsg;
	}

	public WebElement getCancelselectedbutton() {
		return cancelselectedbutton;
	}

	public WebElement getCheckallbutton() {
		return checkallbutton;
	}

	public WebElement getTextorderidtext() {
		return textorderidtext;
	}

	public WebElement getSearchhotelbutton() {
		return searchhotelbutton;
	}

	public WebElement getButtonitinerary() {
		return buttonitinerary;
	}

	public WebElement getCancelbutton() {
		return cancelbutton;
	}
	
		public void cancel(String Order_Id) throws InterruptedException
	{
		Thread.sleep(3000);
		click(getButtonitinerary());
		sendKeys(getTextorderidtext(), Order_Id);
		click(getSearchhotelbutton());
		click(getCheckallbutton());
		//click(getCancelselectedbutton());
		click(getCancelbookbutton());
		Thread.sleep(3000);
		acceptAlert();

	}
		public void cancelBooking() {
			click(getButtonitinerary());
			click(getCancelbutton());
			acceptAlert();
		}
		
		public void cancelbookingpagemsg(String cancelbookedmessage) throws InterruptedException
		{
			Thread.sleep(30000);
			Assert.assertEquals("Verify cancel booking page message", cancelbookedmessage, getText(getCancelbookingmsg()));
		}
}
