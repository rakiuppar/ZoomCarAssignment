package com.zoom.qa.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zoom.qa.base.Base;
import com.zoom.qa.pages.HomePage;
import com.zoom.qa.pages.SearchPage;
import com.zoom.qa.util.TestUtilities;

public class CarBookingParallelTests extends Base
{
	HomePage homePage;
	SearchPage searchPage;
	TestUtilities testUtil;
	
	public CarBookingParallelTests()
	{
		super();
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser)
	{
//		initialization();
		if(browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "BrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie")) 
		{ 
			System.setProperty("webdriver.gecko.driver", "BrowserDrivers\\IEDriverServer.exe");	
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "BrowserDrivers\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		
		homePage.loadUrl(prop.getProperty("url"));		
		testUtil = new TestUtilities();
		homePage = new HomePage();
		searchPage = new SearchPage();
	}
	
	
	@Test(priority=1)
	public void bookCar() throws InterruptedException
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
