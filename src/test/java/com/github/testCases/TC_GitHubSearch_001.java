package com.github.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.pageObjects.GitHubSearchPage;
import com.github.testBase.BaseClass;
import com.github.utilities.XLUtils;

/**
 * @author Manjunath
 *
 */
public class TC_GitHubSearch_001 extends BaseClass {
	
	
	@Test(dataProvider="SearchRepoData")
	public void verifyGithubSearchRepo(String searchRepo, String index)  {
		
		//initialize page objects
		GitHubSearchPage gp= new GitHubSearchPage(driver);
		
		gp.verifyGithubSearchPage();
		gp.searchRepo(searchRepo);
		gp.selectSearchItem();
		gp.clickOnRepoOwnerAvatarImage();
		gp.verifyRepoOwnerAvatarImage();
		
	}
	
	
	@DataProvider(name="SearchRepoData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/TestData/GitHubData.xlsx";
		
		int totalrows=XLUtils.getRowCount(path, "Sheet1");	
		int totalcols=XLUtils.getCellCount(path,"Sheet1",1);
				
		String regdata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //5
		{		
			for(int j=0;j<totalcols;j++)
			{
				regdata[i-1][j]= XLUtils.getCellData(path, "Sheet1",i, j);  //1,0
			}
		}
	return regdata;
				
	}

}
