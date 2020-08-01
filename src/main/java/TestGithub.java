import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestGithub {
	
	public AppiumDriver<WebElement> driver;
	public static String apkPath = System.getProperty("user.dir")+ "\\apk\\automation-github.apk";
	
	@BeforeClass
	public void setDesiredCapabilities() throws IOException {
		
		// Load config.properties file
		Properties configPropObj = new Properties();
		FileInputStream configfile = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
		configPropObj.load(configfile);
				// end of loading gconfig.properties file
		
		DesiredCapabilities dc= new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, configPropObj.getProperty("PLATFORM_NAME")); 
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, configPropObj.getProperty("PLATFORM_VERSION"));
        dc.setCapability(MobileCapabilityType.APP, apkPath);
        dc.setCapability("app-package",configPropObj.getProperty("APP_PACKAGE"));
        dc.setCapability("app-activity",configPropObj.getProperty("APP_ACTIVITY"));
      
        URL url =new URL(configPropObj.getProperty("URL"));
        driver=new AppiumDriver<WebElement>(url, dc);
        
        //System.out.println("Connection is Successfull");
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void verifyGithubSearch() {
		//WebElements
		
		WebElement txtSearchRepo = driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'input']"));
		WebElement weSelectRepoName = driver.findElement(By.xpath(""));
		
	}
	

}
