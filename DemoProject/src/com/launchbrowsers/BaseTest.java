package com.launchbrowsers;


import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	public static WebDriver driver;
	public static String projectpath= System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties parentProp;
	public static Properties p ;
	public static Properties orprop;
	public static ExtentReports  report;
	public static ExtentTest test;
	
	public static void init() throws Exception 
	{
		
		fis = new FileInputStream(projectpath +"/data.properties");
		p= new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectpath +"/environment.properties");
		parentProp = new Properties();
		parentProp.load(fis);
		String e = parentProp.getProperty("env");
		System.out.println(e);
		
		fis= new FileInputStream(projectpath +"/objrepository.properties");
		orprop = new Properties();
		orprop.load(fis);
		
		fis = new FileInputStream(projectpath +"/log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		report= ExtentManager.getInstance();
		
	
	}

	public static void launch(String browser) 
	{
	
		if (p.getProperty(browser).equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/priyankan/Desktop/Drivers/chromedriver.exe/");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "false");
		    ChromeOptions option= new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\priyankan\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
		    option.addArguments("--disable-notifications");
		    
			driver=new ChromeDriver(option);
		}
		else if(p.getProperty(browser).equals("Firefox"))
		{
			System.setProperty("webdriver.gecho.driver", "C:/Users/priyankan/Desktop/Drivers/geckodriver.exe/");
			ProfilesIni P= new ProfilesIni();
			FirefoxProfile profile=P.getProfile("Novprofile");
			profile.setPreference("dom.webnotifications.enabled", false);
			
			
			FirefoxOptions option=new FirefoxOptions();
			option.setProfile(profile);
			
			driver=new FirefoxDriver(option);
	    }
	}
	
   public static void navigateUrl(String url) 
   {
	
		
		driver.get(p.getProperty(url));
	}
   
   
   public static void clickElement(String locatorkey) 
   {
	   getElement(locatorkey).click();
	   
	   //driver.findElement(By.xpath(orprop.getProperty(locatorkey))).click();
	
   }

   
   public static void Type(String locatorkey, String text) 
   {
      getElement(locatorkey).sendKeys(text);
	   
	   //driver.findElement(By.id(orprop.getProperty(locatorkey))).sendKeys(text);
	
   }

   public static void selectOption(String locatorkey, String item) 
   {
	   getElement(locatorkey).sendKeys(item);
	   
	   //driver.findElement(By.id(orprop.getProperty(locatorkey))).sendKeys(item);
	
   }
    private static WebElement getElement(String locatorkey) 
    {
		WebElement element=null;
		if (locatorkey.endsWith ("_id")) {
			element= driver.findElement(By.id(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith ("_name")) {
			element= driver.findElement(By.name(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith ("_classname")) {
			element=driver.findElement(By.className(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith ("_cssselector")) {
			element=driver.findElement(By.cssSelector(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith ("_xpath")) {
			element=driver.findElement(By.xpath(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith ("_linktext")) {
			element=driver.findElement(By.linkText(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith ("_partialLinkText")) {
			element=driver.findElement(By.partialLinkText(orprop.getProperty(locatorkey)));
		}
		return element;
		
	}

	//*************************************************Verifications*****************************************
    
  public static boolean isElementEqual(String expectedlink) {
    	
    String actuallink=driver.findElement(By.linkText("New Releases")).getText();
    	
    if(actuallink.equals(expectedlink))
    		return true;
		else
	
		return false;
	}
  
  
  //******************************************Reportings***************************************
  
  
  public static void reportSuccess(String passMessage) 
  {
		test.log(LogStatus.PASS, passMessage);
	}
  public static void reportFailure(String failMessage) throws Exception 
	{
		test.log(LogStatus.FAIL, failMessage);
		takeScreenshot();
	}

	public static void takeScreenshot() throws Exception 
	{
		Date dt=new Date();
		System.out.println(dt);
		String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(projectpath+"\\failurescreenshots\\"+dateFormat));
		
		test.log(LogStatus.INFO, "Screenshot --->" +test.addScreenCapture(projectpath+"\\failurescreenshots\\"+dateFormat));
		
	}
	
}
