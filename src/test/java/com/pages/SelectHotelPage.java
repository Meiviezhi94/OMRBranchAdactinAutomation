package com.pages;

import org.junit.Assert;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;


public class SelectHotelPage extends BaseClass{
	
	public SelectHotelPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="radiobutton_0")
	public WebElement radio;
	
	@FindBy(id="continue")
	public WebElement buttoncontinue;
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	public WebElement bookhotelmsg;
	
	@FindBy(id="radiobutton_span")
	public WebElement selecthotelerrormessage;
	
	public WebElement getBookhotelmsg() {
		return bookhotelmsg;
	}

	public WebElement getSelecthotelerrormessage() {
		return selecthotelerrormessage;
	}

	public WebElement getRadio() {
		return radio;
	}

	public WebElement getButtoncontinue() {
		return buttoncontinue;
	}

	public void selectHotel()
	{
		click(getRadio());
		click(getButtoncontinue());

	}

	public void selectHotelwithoutclick()
	{
		click(getButtoncontinue());

	}
	public void bookhotelmsg(String bookahotel)
	{
		Assert.assertEquals("Verify book hotel", bookahotel, getText(getBookhotelmsg()));
	}
	
	public void selectHotelerroreMsg(String selecthotelerrormessge)
	{
		Assert.assertEquals("Verify select hotel error messgage", selecthotelerrormessge, getText(getSelecthotelerrormessage()));

	}

}
