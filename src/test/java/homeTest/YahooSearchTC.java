package homeTest;

import java.io.IOException;

import org.testng.annotations.Test;

import pageFactoryCore.Initialize;

public class YahooSearchTC extends Initialize {
	
	@Test(enabled = false)
	public void yahooSearch() throws IOException {
		yahooHomePage.yahooSearch();
		yahooHomePage.assertFirst();
	}
	
	@Test(enabled = true)
	public void yahooSearchAll() throws IOException {
		yahooHomePage.searchAllYahoo();
	}

}
