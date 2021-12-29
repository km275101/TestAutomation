package configurations;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeManager extends BrowserConfiguration {

	@Override
	protected void initiateBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	

}
