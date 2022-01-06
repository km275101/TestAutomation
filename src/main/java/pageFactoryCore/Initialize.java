package pageFactoryCore;

import org.testng.annotations.BeforeMethod;
import configurations.BrowserConfiguration;
import pageFunctionsPageFactory.BingHomePagePF;
import pageFunctionsPageFactory.CommonFunctionPF;
import pageFunctionsPageFactory.GoogleHomePagePF;
import pageFunctionsPageFactory.YahooHomePagePF;

public class Initialize extends OpenAndCloseBrowser {
	
	protected GoogleHomePagePF googleHomePage ;
	protected YahooHomePagePF yahooHomePage ;
	protected BingHomePagePF bingHomePage ;
	
	@BeforeMethod(alwaysRun = true)
	public void initialize() {
		googleHomePage = new GoogleHomePagePF(driver);
		yahooHomePage = new YahooHomePagePF(driver);
		bingHomePage = new BingHomePagePF(driver);
		
	}

}