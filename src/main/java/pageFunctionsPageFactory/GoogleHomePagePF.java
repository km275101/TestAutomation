package pageFunctionsPageFactory;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.MediaEntityBuilder;
import dataprovider.CommonUtiltyDataProvider;
import pageElementsPageFactory.GoogleHomePagePE;
import pageFactoryCore.OpenAndCloseBrowser;

public class GoogleHomePagePF extends GoogleHomePagePE {

	public GoogleHomePagePF(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	CommonUtiltyDataProvider cud = new CommonUtiltyDataProvider();
	String searchItem = cud.itemName();

	public void search() {
		try {
			System.out.println("Enter the text into search box");
			highlightElement(searchBox);
			searchBox.sendKeys(searchItem);
			test.pass("search item - Google Search box",
					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("ItemSearchGoogleSearchBox")).build());
			searchBox.sendKeys(Keys.ENTER);
			staticWait(3);
			test.pass("Item Searched", MediaEntityBuilder
					.createScreenCaptureFromPath(reportLog("ItemSearchResultGoogleSearchBox")).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void assertvalue() throws IOException {
		try {
			String actual = firstresult.getText().trim();
			highlightElement(firstresult);
			String expected = cud.getExpectedData();
			staticWait(3);
			assertTrue(actual.equalsIgnoreCase(expected));
			test.pass("Asserting",
					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AssertValueIsCorrect")).build());
		} catch (Throwable e) {
			test.fail(e.toString(),
					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AsseertValueIsInCorrect")).build());
		}
	}

	public void bingSearch() {
		try {
			String baseUrl = cud.getUrlDetails("Bing");
			driver.get(baseUrl);
			System.out.println("Enter the text into bing search box");
			highlightElement(bingSearchBox);
			bingSearchBox.sendKeys(searchItem);
			test.pass("Item Entered for search",
					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("bingSearchBox")).build());
			staticWait(3);
			bingSearchBox.sendKeys(Keys.ENTER);
			staticWait(3);
			test.pass("Item Searched result for bing",
					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("bingSearchBoxResult")).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void yahooSearch() {
		try {
			String baseUrl = cud.getUrlDetails("Yahoo");
			driver.get(baseUrl);
			System.out.println("Enter the text into yahoo search box");
			yahooSearchBox.sendKeys(searchItem);
			highlightElement(yahooSearchBox);
			test.pass("Item Entered for search in Yahoo search",
					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("YahooSearchBox")).build());
			yahooSearchBox.sendKeys(Keys.ENTER);
			staticWait(3);
			test.pass("Item Searched result for Yahoo",
					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("YahooSearchBoxResult")).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchAll() {
		try {

			CommonUtiltyDataProvider data = new CommonUtiltyDataProvider("SearchItems");
			int n = data.getRowCount();
			for (int i = 1; i <= n; i++) {
				driver.get(OpenAndCloseBrowser.baseUrl);
				String s = data.getWorkSheet().getRow(i).getCell(0).getStringCellValue().toString();
				highlightElement(searchBox);
				searchBox.sendKeys(s);
				test.pass("search item - Google Search box",
						MediaEntityBuilder.createScreenCaptureFromPath(reportLog("ItemSearchGoogleSearchBox")).build());
				searchBox.sendKeys(Keys.ENTER);
				staticWait(3);
				test.pass("Item Searched", MediaEntityBuilder
						.createScreenCaptureFromPath(reportLog("ItemSearchResultGoogleSearchBox")).build());
				assertvalueAll(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void assertvalueAll(int i) throws IOException {
		try {
			String actual = firstresult.getText().trim();
			highlightElement(firstresult);
			String expected = cud.getSpecificExpectedData(i);
			staticWait(3);
			assertTrue(actual.equalsIgnoreCase(expected));
			test.pass("Asserting",
					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AssertValueIsCorrect")).build());
		} catch (Throwable e) {
			test.fail(e.toString(),
					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AsseertValueIsInCorrect")).build());
		}
	}
}
