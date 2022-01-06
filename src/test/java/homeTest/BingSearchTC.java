package homeTest;

import java.io.IOException;

import org.testng.annotations.Test;

import pageFactoryCore.Initialize;

public class BingSearchTC extends Initialize {
	
	@Test
	public void bingSearch() throws IOException {
		bingHomePage.bingSearch();
		bingHomePage.assertvalueBingSearch();
	}
	
	@Test
	public void bingSearcAllh() throws IOException {
		bingHomePage.searchAll();

	}

}
