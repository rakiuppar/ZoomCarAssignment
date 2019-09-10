package com.zoom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoom.qa.base.Base;
import com.zoom.qa.pages.HomePage;
import com.zoom.qa.pages.SearchPage;
import com.zoom.qa.util.TestUtilities;

public class CarBookingUsingChrome extends Base
{
	HomePage homePage;
	SearchPage searchPage;
	TestUtilities testUtil;
	
	public CarBookingUsingChrome()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testUtil = new TestUtilities();
		homePage = new HomePage();
		searchPage = new SearchPage();
	}
	
	
	@Test(priority=1)
	public void verifyBalenoCarIsDisplayed() throws InterruptedException
	{
		homePage.searchForACar();
		Assert.assertTrue(searchPage.verifyBalenoItem(), "No Baleno cars found");
		
	}
	
	
	@AfterMethod
	public void cleanUp()
	{
		driver.quit();
	}
	
}
