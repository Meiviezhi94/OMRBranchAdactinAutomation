package com.report;
	import java.io.File;
	import java.util.ArrayList;
	import java.util.List;

	import net.masterthought.cucumber.Configuration;
	import net.masterthought.cucumber.ReportBuilder;

	public class Reporting {

		public static void generatesJVMReport(String jsonFile)
		{
			File file = new File("E:\\OMRBranchAdactinAutomation\\target");
			Configuration configuration = new Configuration(file,"ADACTIN HOTEL PAGE");
			configuration.addClassifications("Browser", "Chrome");
			configuration.addClassifications("versions", "108");
			configuration.addClassifications("OS", "Window10");
			List<String> jsonFiles = new ArrayList<String>();
			jsonFiles.add(jsonFile);
			ReportBuilder reportBuilder = new ReportBuilder(jsonFiles,configuration);
			reportBuilder.generateReports();
			
		}

	}



