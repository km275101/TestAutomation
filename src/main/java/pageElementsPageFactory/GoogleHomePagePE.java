package pageElementsPageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import pageFactoryCore.ActionDriver;


public class GoogleHomePagePE extends ActionDriver{
	
	public GoogleHomePagePE(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@title = 'Search']")
	public WebElement searchBox ;
	
	@FindBy(xpath="(//h2[contains(text(), 'Web result')]/..//a/h3)[1]")
	public WebElement firstresult ;
	
	@FindBy(xpath="//input[@aria-label = 'Enter your search term']")
	public WebElement bingSearchBox ;
	
	@FindBy(xpath="//input[@name = 'p']")
	public WebElement yahooSearchBox ;
	

}
