package com.verifications;


import org.openqa.selenium.By;

import com.launchbrowsers.BaseTest;
import com.relevantcodes.extentreports.LogStatus;


public class TC_005 extends BaseTest {
	
	

	public static void main(String[] args) throws Exception {
		
		init();
		test = report.startTest("TC_005");
		test.log(LogStatus.INFO, "----------------   Started TC_005 ------------------------");
		test.log(LogStatus.INFO, "initialising the dependency files...... ");
				
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Opening the browser :-" + p.getProperty("chromebrowser"));
				
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to :- " + p.getProperty("amazonurl"));
		
	boolean actualresult=driver.findElement(By.linkText("New Releases")).isDisplayed();
	
			
		if(!actualresult)
		
			System.out.println("link is not dispalyed");
		
		else
			System.out.println("link is dispalyed");
		
		test.log(LogStatus.INFO, "----------------   Ended TC_005 ------------------------");
		
		report.endTest(test);
		report.flush();
	}

	

}


