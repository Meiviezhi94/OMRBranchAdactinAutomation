package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class BookHotelPage extends BaseClass {
	
	public BookHotelPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="first_name")
	public WebElement txtfirstname;
	
	@FindBy(id="last_name")
	public WebElement txtlastname;
	
	@FindBy(id="address")
	public WebElement txtaddress;
	
	@FindBy(id="cc_num")
	public WebElement txtcreditnum;
		
	@FindBy(id="cc_type")
	public WebElement dropcctype;
	
	@FindBy(id="cc_exp_month")
	public WebElement dropmonth;
	
	@FindBy(id="cc_exp_year")
	public WebElement dropyear;
	
	@FindBy(id="cc_cvv")
	public WebElement txtcvv;

	@FindBy(id="book_now")
	public WebElement btnbook;
	
	@FindBy(xpath="//td[contains(text(),'Booking')]")
	public WebElement bookconfirmmsg;
	
	@FindBy(id="first_name_span")
	private WebElement firstNameError;
	
	@FindBy(id="last_name_span")
	private WebElement lastNameError;
	
	@FindBy(id="address_span")
	private WebElement addressError;
	
	@FindBy(id="cc_num_span")
	private WebElement ccNumError;
	
	@FindBy(id="cc_type_span")
	private WebElement ccTypeError;
	
	@FindBy(id="cc_expiry_span")
	private WebElement expiryError;
	
	@FindBy(id="cc_cvv_span")
	private WebElement cvvNumError;
	
	


	public WebElement getFirstNameError() {
		return firstNameError;
	}

	public WebElement getLastNameError() {
		return lastNameError;
	}

	public WebElement getAddressError() {
		return addressError;
	}

	public WebElement getCcNumError() {
		return ccNumError;
	}

	public WebElement getCcTypeError() {
		return ccTypeError;
	}

	public WebElement getExpiryError() {
		return expiryError;
	}

	public WebElement getCvvNumError() {
		return cvvNumError;
	}

	public WebElement getBookconfirmmsg() {
		return bookconfirmmsg;
	}

	public WebElement getTxtfirstname() {
		return txtfirstname;
	}

	public WebElement getTxtlastname() {
		return txtlastname;
	}

	public WebElement getTxtaddress() {
		return txtaddress;
	}

	public WebElement getTxtcreditnum() {
		return txtcreditnum;
	}

	public WebElement getDropcctype() {
		return dropcctype;
	}

	public WebElement getDropmonth() {
		return dropmonth;
	}
	
	public WebElement getDropyear() {
		return dropyear;
	}

	public WebElement getTxtcvv() {
		return txtcvv;
	}
	
	public WebElement getBtnbook() {
		return btnbook;}
	
	public void bookHotels(String FirstName, String LastName,String BillingAddress, String ccNum, 
			String ccType, String expMonth, String expYear,String cvv)
	{
		sendKeys(getTxtfirstname(), FirstName);
		sendKeys(getTxtlastname(), LastName);
		sendKeys(getTxtaddress(), BillingAddress);
		sendKeys(getTxtcreditnum(), ccNum);
		SelectOptionByText(getDropcctype(), ccType);
		SelectOptionByText(getDropmonth(), expMonth);
		sendKeys(getDropyear(), expYear);
		sendKeys(getTxtcvv(), cvv);
		click(getBtnbook());
		
	}
	public void bookHotels()
	{
		click(getBtnbook());
	}
	
	public void bookHotelwithoutenteringfields(String fnameerror, String lnameerror,
			String billingaddresserror, String ccNumerr, String ccTypeerr,String expiryerr, String cvverr) throws InterruptedException
	{
		Thread.sleep(30000);
		Assert.assertEquals("Verify first name error message", fnameerror, getText(getFirstNameError()));
		Assert.assertEquals("Verify last name error message", lnameerror, getText(getLastNameError()));
		Assert.assertEquals("Verify billing address error message", billingaddresserror, getText(getAddressError()));
		Assert.assertEquals("Verify ccNum error message", ccNumerr, getText(getCcNumError()));
		Assert.assertEquals("Verify ccType error message", ccTypeerr, getText(getCcTypeError()));
		Assert.assertEquals("Verify expiry date error message", expiryerr, getText(getExpiryError()));
		Assert.assertEquals("Verify cvv error message", cvverr, getText(getCvvNumError()));
		
	}
}
