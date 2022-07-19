package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

//import junit.framework.Assert;

public class LoginPage extends BaseClass {
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="username")
	private WebElement txtusername;
	
	@FindBy(id="password")
	private WebElement txtpassword;
	
	@FindBy(id="login")
	private WebElement buttonlogin;
	
	public WebElement getErrormessage() {
		return errormessage;
	}


	@FindBy(xpath="//div[@class='auth_error']")
	private WebElement errormessage;

	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtpassword() {
		return txtpassword;
	}

	public WebElement getButtonlogin() {
		return buttonlogin;
	}

	
	
	
	public void login(String userName, String password) throws Exception
	{
		//String txtusername = getPropertyValue(userName);
		//String txtpassword = getPropertyValue(password);
		sendKeys(getTxtusername(), userName);
		sendKeys(getTxtpassword(), password);
		//sendKeys(getTxtusername(),getPropertyValue(userName));
		//sendKeys(getTxtusername(),getPropertyValue(password));
		click(getButtonlogin());

		
	}
	public void loginWithEnter(String userName,String password) throws AWTException {
		sendKeys(getTxtusername(),userName);
		sendKeys(getTxtpassword(),password);
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public void loginAssert(String expected)
	{
		Assert.assertTrue("Verify login page error", getText(getErrormessage()).contains(expected));
	}

}
