package configurations;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxManager extends BrowserConfiguration {

	@Override
	protected void initiateBrowser() {
		WebDriverManager.firefoxdriver().setup();
		try {
			FirefoxOptions options = new FirefoxOptions();
	        options.setBinary("C:\\Users\\kamlesh.maurya\\AppData\\Local\\Mozilla Firefox\\firefox.exe"); 
	        driver = new FirefoxDriver(options);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
