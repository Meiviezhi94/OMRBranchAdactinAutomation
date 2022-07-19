package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

/**
 * @author Mei
 * @Description mentions tags,SnippetType,plugin,features and step definition package
 * @Date 08/07/2022
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@SearchHotel"},snippets = SnippetType.CAMELCASE, 
plugin= {"json:target/output.json"},dryRun=false, 
monochrome = true,
features= {"src\\test\\resources"}, glue= {"com.stepdefinition"})

public class TestRunner {
	
	@AfterClass
	public static void afterclass()
	{
		Reporting.generatesJVMReport("E:\\OMRBranchAdactinAutomation\\target\\output.json");
	}
	

}
