package pageElementsPageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import pageFactoryCore.ActionDriver;


public class YahooPagePE extends ActionDriver{
	
	public YahooPagePE(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name = 'p']")
	public WebElement yahooSearchBox ;
	
	@FindBy(xpath="(//li[@class='first']//h3/a[1])[1]")
	public WebElement firstresultYahooSearch ;

}
