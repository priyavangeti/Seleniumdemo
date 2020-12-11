package com.verifications;


import org.openqa.selenium.By;

import com.launchbrowsers.BaseTest;
import com.relevantcodes.extentreports.LogStatus;


public class TC_006 extends BaseTest {
	
	

	public static void main(String[] args) throws Exception {
		
		init();
		test = report.startTest("TC_006");
		test.log(LogStatus.INFO, "----------------   Started TC_006 ------------------------");
		test.log(LogStatus.INFO, "initialising the dependency files...... ");
				
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Opening the browser :-" + p.getProperty("chromebrowser"));
				
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to :- " + p.getProperty("amazonurl"));

		//String actuallink=driver.findElement(By.linkText("New Releases")).getText();
		String actuallink = driver.findElement(By.linkText("New Releases")).getAttribute("innerHTML");
		String expectedlink= "releases";
		
		System.out.println("Actual Link : " + actuallink);
		System.out.println("Expected Link : " + expectedlink);
		
		//if(actuallink.equals(expectelLink))
		//if(actuallink.equalsIgnoreCase(expectedlink))
		
		if(actuallink.contains(expectedlink)) 
		
			System .out.println("Both links are equal.....");	
		else
			System .out.println("Both links are not equal.....");		
		
		
		test.log(LogStatus.INFO, "----------------   Ended TC_006 ------------------------");
		
		report.endTest(test);
		report.flush();
	}

	

}


