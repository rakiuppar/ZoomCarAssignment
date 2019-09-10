package com.zoom.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zoom.qa.base.Base;

public class HomePage extends Base
{
	@FindBy(xpath="//input[@name='city-search']")
	WebElement searchInputBox;
	
	@FindBy(xpath="//img[@alt='Bangalore']")
	WebElement cityImage;
	
	@FindBy(xpath="//a[@title='Start your wonderful journey']")
	WebElement searchAreaLink;
	
	@FindBy(xpath="//input[@placeholder='Tell us your Starting point in Bangalore']")
	WebElement searchAreaInputBox;
	

	@FindBy(xpath="//button[@class='proceed']")
	WebElement nextButton;
	
	@FindBy(xpath="//*[contains(text(),'PICKUP TIME')]")
	WebElement pickUpInfo;
	
	@FindBy(xpath="//*[contains(text(),'DROP OFF TIME')]")
	WebElement dropOffInfo;

	
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loadUrl(String url)
	{
		driver.get(url);
	}
	
	
	public void searchForACar() throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait(driver, 5);
		searchInputBox.sendKeys(prop.getProperty("city"));
		cityImage.click();
		searchAreaLink.click();
		searchAreaInputBox.sendKeys(prop.getProperty("location"));
		Thread.sleep(2000);
		searchAreaInputBox.sendKeys(Keys.ARROW_DOWN);
		searchAreaInputBox.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(pickUpInfo));
		nextButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropOffInfo));
		nextButton.click();
	}
	
}
