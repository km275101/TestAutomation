package homeTest;

import java.io.IOException;

import org.testng.annotations.Test;

import pageFactoryCore.Initialize;

public class RegressionPack extends Initialize{
	
	@Test(priority=1)
	public void googleSearch() throws IOException {
		googleHomePage.search();
		googleHomePage.assertvalue();
	}
	
	@Test(priority=2)
	public void bingSearch() {
		googleHomePage.bingSearch();
	}
	
	@Test( priority=3)
	public void yahooSearch() {
		googleHomePage.yahooSearch();;
	}

}
