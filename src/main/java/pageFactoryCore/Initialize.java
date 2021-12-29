package pageFactoryCore;

import org.testng.annotations.BeforeMethod;
import configurations.BrowserConfiguration;
import pageFunctionsPageFactory.GoogleHomePagePF;

public class Initialize extends OpenAndCloseBrowser {
	
	protected GoogleHomePagePF googleHomePage ;
	
	@BeforeMethod
	public void initialize() {
		googleHomePage = new GoogleHomePagePF(driver);
		
	}

}