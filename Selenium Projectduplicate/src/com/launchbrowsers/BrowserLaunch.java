package com.launchbrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {

	public static void main(String[] args) {
		
	WebDriver Driver;
		
		//System.setProperty("webdriver.chrome.driver", "C:/Users/priyankan/Desktop/Drivers/chromedriver.exe/");
	Driver= new ChromeDriver();
	Driver.get("https://bestbuy.com");
	//System.setProperty("webdriver.gecho.driver", "C:/Users/priyankan/Desktop/Drivers/geckodriver.exe/");
	Driver =new FirefoxDriver();
	Driver.get("https://bestbuy.com");
	}

}
