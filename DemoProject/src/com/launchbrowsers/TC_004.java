package com.launchbrowsers;


import com.relevantcodes.extentreports.LogStatus;


public class TC_004 extends BaseTest {
	
	

	public static void main(String[] args) throws Exception {
		
		init();
		test = report.startTest("TC_004");
		test.log(LogStatus.INFO, "----------------   Started TC_004 ------------------------");
		test.log(LogStatus.INFO, "initialising the dependency files...... ");
				
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Opening the browser :-" + p.getProperty("chromebrowser"));
				
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to :- " + p.getProperty("amazonurl"));
			
		selectOption("amazondropdown_id","Books");
		test.log(LogStatus.FAIL, "Selected the option books by using the locator :- "+ orprop.getProperty("amazondropdown_id"));
		
		Type("amazonsearchtext_id","Harry Potter");
		test.log(LogStatus.INFO, "Entered the test Harry Potter by using locator :- " + orprop.getProperty("amazonsearchtext_id"));
	
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.ERROR, "Clicked on search button by using locator :- " + orprop.getProperty("amazonsearchbutton_xpath"));
		
		
		test.log(LogStatus.INFO, "----------------   Ended TC_004 ------------------------");
		
		report.endTest(test);
		report.flush();
	}

	

}


