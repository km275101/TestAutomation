package configurations;

import org.openqa.selenium.WebDriver;

public abstract class BrowserConfiguration {
	
	protected WebDriver driver;
    protected abstract void initiateBrowser();

    public void quitDriver() {
            try {
				driver.quit();
				System.out.println("Browser Closed");
			} catch (Exception e) {
				System.out.println("Driver instance is not present");
				e.printStackTrace();
			}
    }
    
    public WebDriver getDriver() {
        if (null == driver) {
        	initiateBrowser();
        }
        return driver;
    }
}
