package homeTest;

import java.io.IOException;

import org.testng.annotations.Test;
import pageFactoryCore.Initialize;

public class GoogleHomePageTC extends Initialize {
	
	@Test
	public void search() throws IOException {
		googleHomePage.search();
		googleHomePage.assertvalue();
	}
	
}
