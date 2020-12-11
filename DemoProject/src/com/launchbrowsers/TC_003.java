package com.launchbrowsers;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_003 extends BaseTest {
	
	private static final Logger log = Logger.getLogger(TC_003.class);

	public static void main(String[] args) throws Exception {
		
		init();
		
		log.info("initialising the dependency files...... ");
		
		launch("chromebrowser");
		log.info("Opening the browser :-" + p.getProperty("chromebrowser") );
		
		navigateUrl("amazonurl");
		log.info("Navigated to :- " + p.getProperty("amazonurl") );
		
		selectOption("amazondropdown_name","Books");
		log.info("Selected the option books by using the locator :- "+ orprop.getProperty("amazondropdown_id") );
		
		Type("amazonsearchtext_id","harry potter");
		log.info("Entered the test Harry Potter by using locator :- " + orprop.getProperty("amazonsearchtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on search button by using locator :- " + orprop.getProperty("amazonsearchbutton_xpath"));
		
      // WebElement loc = driver.findElement(By.id("searchDropdownBox"));
	  // loc.sendKeys("Books");
	
	//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
	//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("harry potter");
	//driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[2]/div[1]/form[1]/div[3]/div[1]/span[1]/input[1]")).click();
	}

	

}


