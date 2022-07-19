package com.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.baseclass.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HookClass extends BaseClass {
	@Before
	public void beforeScenario(Scenario sc) throws IOException {
		getDriver(getPropertyValue("browserType"));
		//maximize();
		getUrl(getPropertyValue("Url"));
		
	}
	
	@After
	public void afterScenario(Scenario sc)
	{
	if(!sc.isFailed())
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] as = screenshot.getScreenshotAs(OutputType.BYTES);
		sc.embed(as, "Every Scenario");
	}
	//closeallWindows();
	}

}
