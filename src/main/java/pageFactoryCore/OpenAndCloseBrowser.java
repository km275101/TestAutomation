package pageFactoryCore;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.opencsv.exceptions.CsvException;

import configurations.BrowserConfiguration;
import configurations.ChromeManager;
import configurations.FirefoxManager;
import dataprovider.CSVDataUtility;
import dataprovider.CommonUtiltyDataProvider;

public class OpenAndCloseBrowser {
	WebDriver driver;
	Logger logger = Logger.getLogger(OpenAndCloseBrowser.class);
	CommonUtiltyDataProvider cud = new CommonUtiltyDataProvider();
	CSVDataUtility csvUtility = new CSVDataUtility();
	BrowserConfiguration browserConfig;
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;
	public static String filePath;
	public static String testName1;
	public static String baseUrl;

	@BeforeTest
	@Parameters({ "browser", "urlDetail" })
	public void setUp(String browserName, String urlTag, ITestContext ctx) throws InterruptedException, IOException, CsvException {
		String testName = ctx.getName();
		logger.info("Initiate Browser");
		browserConfig = getManager(browserName);
		driver = browserConfig.getDriver();
		//String baseUrl = cud.getUrlDetails(urlTag);
		baseUrl  = csvUtility.openURL(urlTag);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test = extent.createTest(testName);
		test.log(Status.PASS, "Browser Opened");	
	}

	@AfterTest
	public void afterMethod() {
		test.log(Status.PASS, "Browser Closed");
		browserConfig.quitDriver();
	}

	public static BrowserConfiguration getManager(String type) {
		BrowserConfiguration browserInfo = null;
		switch (type) {
		case "chrome":
			browserInfo = new ChromeManager();
			break;
		case "firefox":
			browserInfo = new FirefoxManager();
			break;
		default:
			browserInfo = new ChromeManager();
			break;
		}
		return browserInfo;
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		extent.flush();
		System.out.println("Extent Report Flush Method");
		System.out.println("Please access the location for report : "+testName1);
	}
	
	@BeforeSuite
	public void beforeSuite() {
		extent = Report.getInstance("ReportView");
	}

}
