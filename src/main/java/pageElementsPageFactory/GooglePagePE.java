package pageElementsPageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import pageFactoryCore.ActionDriver;


public class GooglePagePE extends ActionDriver{
	
	public GooglePagePE(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@title = 'Search']")
	public WebElement searchBox ;
	
	@FindBy(xpath="(//h2[contains(text(), 'Web result')]/..//a/h3)[1]")
	public WebElement firstresult ;

}
