package com.zoom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoom.qa.base.Base;

public class SearchPage extends Base
{
	@FindBy(xpath="//*[contains(text(),'Baleno')]")
	WebElement itemCarBaleno;
	
	public SearchPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyBalenoItem()
	{
		return itemCarBaleno.isDisplayed();
		
	}
}
