package com.github.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.github.pageObjects.GitHubSearchPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author Manjunath
 *
 */
public class BaseClass {
	
	public AppiumDriver<WebElement> driver;
	public GitHubSearchPage ghg;
	
	//public static Logger logger;
	public Properties configPropObj;
	public static String apkPath = System.getProperty("user.dir")+ "\\apk\\automation-github.apk";
	public Logger logger=LogManager.getLogger(this.getClass());    // Log4j
	public String selectedRepoName;
	
	@BeforeClass
	@Parameters("appium_type")
	public void setDesiredCapabilities(String type) throws IOException {
		
		// Load config.properties file
		configPropObj = new Properties();
		FileInputStream configfile = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
		configPropObj.load(configfile);
				// end of loading gconfig.properties file
		if(type.equals("android"))
		{
			DesiredCapabilities dc= new DesiredCapabilities();
	        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, configPropObj.getProperty("PLATFORM_NAME")); 
	        dc.setCapability(MobileCapabilityType.DEVICE_NAME, configPropObj.getProperty("PLATFORM_VERSION"));
	        dc.setCapability(MobileCapabilityType.APP, apkPath);
	        dc.setCapability("app-package",configPropObj.getProperty("APP_PACKAGE"));
	        dc.setCapability("app-activity",configPropObj.getProperty("APP_ACTIVITY"));
      
	        URL url =new URL(configPropObj.getProperty("URL"));
	        driver=new AppiumDriver<WebElement>(url, dc);
		}else if(type.equals("ios"))
		{
			System.out.println("Desired Capabilities");
		}
        //System.out.println("Connection is Successfull");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
