package pageFactoryCore;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageFunctionsPageFactory.CommonFunctionPF;

public class ActionDriver extends OpenAndCloseBrowser {

	protected WebDriver driver;
	String fileName;

	public ActionDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void expliciWait(WebElement el) {
		// explicit method can be implemented based on requirements
	}
	
	public void staticWait(int n) throws InterruptedException {
		long time = n*1000;
		Thread.sleep(time);
	}
	
	public String reportLog(String message) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File srFfile = sc.getScreenshotAs(OutputType.FILE);
		String userDir = System.getProperty("user.dir");

		LocalDateTime ld = LocalDateTime.now();
		int s = ld.getSecond();
		int ns = ld.getNano();
		fileName = message+String.valueOf(s) + String.valueOf(ns);
		filePath = userDir + File.separator +"target"+File.separator + "screenshots"+File.separator +fileName+".png";
		File f = new File(filePath);
		File destFile = new File(f.toString());
		FileUtils.copyFile(srFfile, destFile);
		
		return filePath;
	}
	
	public void highlightElement(WebElement e) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		try {
			jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');", e);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void scrollToElement(WebElement e) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		try {
			jse.executeScript("arguments[0].scrollIntoView(true);", e);
			staticWait(2);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
}
