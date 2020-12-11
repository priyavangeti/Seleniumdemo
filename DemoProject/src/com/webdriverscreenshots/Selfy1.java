package com.webdriverscreenshots;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.launchbrowsers.BaseTest;

public class Selfy1 extends BaseTest {

	public static void main(String[] args)  throws Exception{

		init();

		launch("chromebrowser");
		
		navigateUrl("amazonurl");

		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File("C:\\Users\\priyankan\\Desktop\\amazon.png"));
	
	}

}
