package pageElementsPageFactory;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import pageFactoryCore.ActionDriver;


public class BingPagePE extends ActionDriver{
	
	public BingPagePE(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@aria-label = 'Enter your search term']")
	public WebElement bingSearchBox ;
	
	@FindBy(xpath="(//li[@class='b_algo']//h2/a[1])[1]")
	public WebElement firstresultBingSearch ;
	
	@FindBy(xpath="//a[contains(@href, 'http')]")
	public List<WebElement> links ;
	
}
