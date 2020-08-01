package com.github.testCases;

import org.testng.annotations.Test;

import com.github.pageObjects.GitHubSearchPage;
import com.github.testBase.BaseClass;

public class TC_GitHubSearch_001 extends BaseClass {
	
	@Test
	public void verifyGithubSearchRepo()  {
		
		//initialize page objects
		GitHubSearchPage gp= new GitHubSearchPage(driver);
		
		gp.verifyGithubSearchPage();
		gp.searchRepo();
		gp.selectSearchItem();
		gp.clickOnRepoOwnerAvatarImage();
		gp.verifyRepoOwnerAvatarImage();
		
	}

}
