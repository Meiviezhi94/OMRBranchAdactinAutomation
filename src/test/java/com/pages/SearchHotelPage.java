package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import com.baseclass.BaseClass;

public class SearchHotelPage extends BaseClass {
	
	
	public SearchHotelPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement dropLocation;
	
	@FindBy(id="hotels")
	private WebElement drophotels;
	
	@FindBy(id="room_type")
	private WebElement droproomtype;
	
	@FindBy(id="room_nos")
	private WebElement droproomno;

	@FindBy(id="datepick_in")
	private WebElement txtcheckindate;
	
	@FindBy(id="datepick_out")
	private WebElement txtcheckoutdate;
	
	@FindBy(id="adult_room")
	private WebElement dropadult;
	
	@FindBy(id="child_room")
	private WebElement dropchild;
	
	@FindBy(id="Submit")
	private WebElement buttonsubmit;
	
	@FindBy(xpath="//span[text()='Check-In Date shall be before than Check-Out Date']")
	private WebElement checkindateerror;
	
	@FindBy(xpath="//span[text()='Check-Out Date shall be after than Check-In Date']")
	private WebElement checkoutdateerror;
	
	
	public WebElement getCheckindateerror() {
		return checkindateerror;
	}

	public WebElement getCheckoutdateerror() {
		return checkoutdateerror;
	}

	public WebElement getSelectlocationerror() {
		return selectlocationerror;
	}

	public WebElement getSelecthotelmsg() {
		return selecthotelmsg;
	}

	@FindBy(id="location_span")
	private WebElement selectlocationerror;
	
	@FindBy(xpath="//td[text()='Select Hotel ']")
	public WebElement selecthotelmsg;


	public WebElement getDropLocation() {
		return dropLocation;
	}

	public WebElement getDrophotels() {
		return drophotels;
	}

	public WebElement getDroproomtype() {
		return droproomtype;
	}

	public WebElement getDroproomno() {
		return droproomno;
	}

	public WebElement getTxtcheckindate() {
		return txtcheckindate;
	}

	public WebElement getTxtcheckoutdate() {
		return txtcheckoutdate;
	}

	public WebElement getDropadult() {
		return dropadult;
	}

	public WebElement getDropchild() {
		return dropchild;
	}
	
	public WebElement getButtonsubmit() {
		return buttonsubmit;
	}

	
	public void searchhotels(String Location, String Hotels, String RoomType, String NumberofRooms, String CheckInDate, String CheckOutDate, String AdultsperRoom, String ChildrenperRoom)
	{
		SelectOptionByText(getDropLocation(), Location);
		SelectOptionByText(getDrophotels(), Hotels);
		SelectOptionByText(getDroproomtype(), RoomType);
		SelectOptionByText(getDroproomno(), NumberofRooms);
		clear(getTxtcheckindate());
		sendKeys(getTxtcheckindate(), CheckInDate);
		clear(getTxtcheckoutdate());
		sendKeys(getTxtcheckoutdate(), CheckOutDate);
		SelectOptionByText(getDropadult(), AdultsperRoom);
		SelectOptionByText(getDropchild(), ChildrenperRoom);
		click(getButtonsubmit());
	}
	
	public void searchhotels(String Location,String NumberofRooms, String CheckInDate, String CheckOutDate, String AdultsperRoom)
	{
		SelectOptionByText(getDropLocation(), Location);
		SelectOptionByText(getDroproomno(), NumberofRooms);
		sendKeys(getTxtcheckindate(), CheckInDate);
		sendKeys(getTxtcheckoutdate(), CheckOutDate);
		SelectOptionByText(getDropadult(), AdultsperRoom);
		click(getButtonsubmit());
	}
	public void searchhotels()
	{
		click(getButtonsubmit());
	}
	
	public void searchHotelAssert(String select_hotel)
	{
		Assert.assertEquals("Verify select hotel", select_hotel, getText(getSelecthotelmsg()));
	}
	
	public void searchHotelDateAssert(String searchhoteldateinerr,String searchhoteldateouterr)
	{
		Assert.assertEquals("Verify checkin date error message", searchhoteldateinerr, getText(getCheckindateerror()));
		Assert.assertEquals("Verify checkout date error message", searchhoteldateouterr, getText(getCheckoutdateerror()));
	}
	
	public void searchHotellocationAssert(String selectlocationerr)
	{
		Assert.assertEquals("Verify select location error message", selectlocationerr, getText(getSelectlocationerror()));
	}

}
