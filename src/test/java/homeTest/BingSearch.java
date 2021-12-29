package homeTest;

import org.testng.annotations.Test;

import pageFactoryCore.Initialize;

public class BingSearch extends Initialize {
	
	@Test
	public void bingSearch() {
		googleHomePage.bingSearch();
	}

}
