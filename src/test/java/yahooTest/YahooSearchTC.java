package yahooTest;

import java.io.IOException;

import org.testng.annotations.Test;

import pageFactoryCore.Initialize;

public class YahooSearchTC extends Initialize {
	
	@Test
	public void yahooSearch() throws IOException {
		yahooHomePage.yahooSearch();
		yahooHomePage.assertFirst();
	}
	
	@Test
	public void yahooSearchAll() throws IOException {
		yahooHomePage.searchAllYahoo();
	}

}
