package com.github.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

/**
 * @author Manjunath
 *
 */
public class Utils {
	
	public static void typeValue(WebElement weElement, String value) {
		weElement.clear();
		//webDriverExplicitWait()
		weElement.sendKeys(value);
	}
	/**
	 * @author Manjunath
	 *
	 */	
	public static void clickOnElement(WebElement weElement) {
		weElement.click();
		
	}
	/**
	 * @author Manjunath
	 *
	 */	
	public static void pressEnter(AppiumDriver<WebElement> driver, WebElement weElement) {
		Actions enter = new Actions(driver);
		enter.sendKeys(Keys.ENTER).build().perform();
		
		//weElement.sendKeys(Keys.ENTER);
	}
	/**
	 * @author Manjunath
	 *
	 */
	// Explicit waits
		public static void webDriverExplicitWait(AppiumDriver<WebElement> driver, WebElement weElement, String action, int timeInSeconds) {
			  
			
			  WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
			  if(action.equals("clickable")) {
				  wait.until(ExpectedConditions.elementToBeClickable(weElement));
			  }else if(action.equals("visibility")) {
				  
				  wait.until(ExpectedConditions.visibilityOf(weElement));
			  }     
			  
		  }
		/**
		 * @author Manjunath
		 *
		 */	
		public static String getEWebElementText(WebElement weElement)
		{
			return weElement.getText();
		}
		/**
		 * @author Manjunath
		 * @param weElement
		 *
		 */
		public static void verifyWebElementPresent(WebElement weElement) {
			
			if(weElement.isDisplayed()) {
				Assert.assertTrue(weElement.isDisplayed());
			}
			
		}

}
