package homeTest;

import java.io.IOException;

import org.testng.annotations.Test;

import pageFactoryCore.Initialize;

public class RegressionPack extends Initialize{
	
	@Test(priority = 1, groups = { "google" })
	public void googleSearch() throws IOException {
		googleHomePage.search();
		googleHomePage.assertvalue();
	}
	
	@Test(priority = 2, groups = { "bing" })
	public void bingSearch() throws IOException {
		bingHomePage.bingSearch();
	}
	
	@Test( priority =3,groups = { "yahoo" })
	public void yahooSearch() {
		yahooHomePage.yahooSearch();
	}
	
	@Test( priority =4,groups = { "searchAll" })
	public void searchAll() {
		googleHomePage.searchAllEntries();
		bingHomePage.searchAll();
		yahooHomePage.searchAllYahoo();
	}

}
