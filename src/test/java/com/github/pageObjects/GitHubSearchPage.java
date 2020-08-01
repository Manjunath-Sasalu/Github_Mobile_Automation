package com.github.pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.testBase.BaseClass;
import com.github.utilities.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GitHubSearchPage extends BaseClass{
	public AppiumDriver<WebElement> driver;
	
	
	public GitHubSearchPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Git Search WebElemets
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Github')]")
	@CacheLookup
	WebElement weGithub;
	
	@FindBy(xpath = "//android.widget.EditText[contains(@resource-id,'input')]")
	@CacheLookup
	WebElement txtSearchRepo;
	
	@FindBy(xpath = "(//android.widget.TextView[contains(@resource-id,'name')])[1]")
	@CacheLookup
	WebElement weSelectRepoName;
	
	@FindBy(xpath = "(//android.widget.TextView[contains(@resource-id,'desc')])[1]")
	@CacheLookup
	WebElement weSelectRepoDesc;
	
	
	@FindBy(xpath = "(//android.widget.TextView[contains(@resource-id,'name')])[1]")
	@CacheLookup
	WebElement txtVerifySelectedRepo;
	
	@FindBy(xpath = "(//android.widget.ImageView[contains(@resource-id,'imageView')])[1]")
	@CacheLookup
	WebElement imgRepoOwnerAvatar;
	
	@FindBy(xpath = "(//android.widget.TextView[contains(@resource-id,'textView')])[1]")
	@CacheLookup
	WebElement imgRepoOwnerName;
	
	//com.android.example.github:id/avatar
	
	@FindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'avatar')]")
	@CacheLookup
	WebElement imgRepoOwnerAvatarImage;
	//Action Methods
	
	public void verifyGithubSearchPage()  {
		
		Utils.webDriverExplicitWait(driver, weGithub, "visibility", 30);
		Utils.verifyWebElementPresent(weGithub);
	}
	
	public void searchRepo()  {
		
		Utils.clickOnElement(txtSearchRepo);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Utils.typeValue(txtSearchRepo, "Appium Test");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		Utils.pressEnter(driver,txtSearchRepo);
	}
	
	public void selectSearchItem() {
		Utils.webDriverExplicitWait(driver, weSelectRepoName, "clickable", 20);
		Utils.verifyWebElementPresent(weSelectRepoName);
		selectedRepoName = Utils.getEWebElementText(weSelectRepoName);
		System.out.println("Repository Name: "+selectedRepoName);
		Utils.clickOnElement(weSelectRepoName);
		
	}
	
	
	
	public void clickOnRepoOwnerAvatarImage() {
		Utils.webDriverExplicitWait(driver, imgRepoOwnerAvatar, "clickable", 30);
		String verifyRepoName = Utils.getEWebElementText(txtVerifySelectedRepo);
		Assert.assertEquals(verifyRepoName, selectedRepoName);
		Utils.verifyWebElementPresent(imgRepoOwnerAvatar);
		Utils.clickOnElement(imgRepoOwnerAvatar);
	}
	
	public void verifyRepoOwnerAvatarImage() {
		Utils.webDriverExplicitWait(driver, imgRepoOwnerAvatarImage, "visibility", 30);
		Assert.assertEquals(imgRepoOwnerAvatarImage.isDisplayed(), true);
	}
	
}
