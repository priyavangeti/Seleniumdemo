package com.verifications;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.launchbrowsers.BaseTest;
import com.relevantcodes.extentreports.LogStatus;


public class TC_008 extends BaseTest {
	
	

	public static void main(String[] args) throws Exception {
		
		init();
		test = report.startTest("TC_007");
		test.log(LogStatus.INFO, "----------------   Started TC_007 ------------------------");
		test.log(LogStatus.INFO, "initialising the dependency files...... ");
				
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Opening the browser :-" + p.getProperty("chromebrowser"));
				
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to :- " + p.getProperty("amazonurl"));

		
		
     String expectedlink = "new Releases";
		
		if(!isElementEqual(expectedlink))
			
			reportFailure("Both links are not equal...!");
		else
			reportSuccess("Both links are equal...");
		
		
		
		test.log(LogStatus.INFO, "----------------   Ended TC_007 ------------------------");
		
		report.endTest(test);
		report.flush();
	}

	
	
	

}


