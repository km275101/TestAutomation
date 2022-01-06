package pageFunctionsPageFactory;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.MediaEntityBuilder;
import dataprovider.CommonUtiltyDataProvider;
import pageElementsPageFactory.GooglePagePE;
import pageFactoryCore.OpenAndCloseBrowser;

public class GoogleHomePagePF extends GooglePagePE {

	public GoogleHomePagePF(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	CommonUtiltyDataProvider cud = new CommonUtiltyDataProvider();
	CommonFunctionPF cfp = new CommonFunctionPF(driver);
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

	public void searchAllEntries() {

		cfp.searchAll(searchBox, firstresult, "SearchItems");

	}
	
	
	
	
	
	
	
	

//	public void assertvalue(WebElement el) throws IOException {
//		try {
//			String actual = el.getText().trim();
//			highlightElement(el);
//			scrollToElement(el);
//			String expected = cud.getExpectedData();
//			staticWait(3);
//			assertTrue(actual.contains(expected));
//			test.pass("Asserting",
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AssertValueIsCorrect")).build());
//		} catch (Throwable e) {
//			test.fail(e.toString(),
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AsseertValueIsInCorrect")).build());
//		}
//	}
//
//	public void bingSearch() throws IOException {
//		try {
//			String baseUrl = cud.getUrlDetails("Bing");
//			driver.get(baseUrl);
//			System.out.println("Enter the text into bing search box");
//			highlightElement(bingSearchBox);
//			bingSearchBox.sendKeys(searchItem);
//			test.pass("Item Entered for search",
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("bingSearchBox")).build());
//			staticWait(3);
//			bingSearchBox.sendKeys(Keys.ENTER);
//			staticWait(3);
//			test.pass("Item Searched result for bing",
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("bingSearchBoxResult")).build());
//			assertvalue(firstresultBingSearch);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void assertvalueBingSearch() throws IOException {
//		try {
//			String actual = firstresultBingSearch.getText().trim();
//			highlightElement(firstresultBingSearch);
//			String expected = cud.getExpectedData();
//			staticWait(3);
//			assertTrue(actual.equalsIgnoreCase(expected));
//			test.pass("Asserting",
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AssertValueIsCorrect")).build());
//		} catch (Throwable e) {
//			test.fail(e.toString(),
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AsseertValueIsInCorrect")).build());
//		}
//	}
//
//	public void yahooSearch() {
//		try {
//			String baseUrl = cud.getUrlDetails("Yahoo");
//			driver.get(baseUrl);
//			System.out.println("Enter the text into yahoo search box");
//			yahooSearchBox.sendKeys(searchItem);
//			highlightElement(yahooSearchBox);
//			test.pass("Item Entered for search in Yahoo search",
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("YahooSearchBox")).build());
//			yahooSearchBox.sendKeys(Keys.ENTER);
//			staticWait(3);
//			test.pass("Item Searched result for Yahoo",
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("YahooSearchBoxResult")).build());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void searchAll() {
//		try {
//
//			CommonUtiltyDataProvider data = new CommonUtiltyDataProvider("SearchItems");
//			int n = data.getRowCount();
//			for (int i = 1; i <= n; i++) {
//				driver.get(OpenAndCloseBrowser.baseUrl);
//				String s = data.getWorkSheet().getRow(i).getCell(0).getStringCellValue().toString();
//				highlightElement(searchBox);
//				searchBox.sendKeys(s);
//				test.pass("search item - Google Search box",
//						MediaEntityBuilder.createScreenCaptureFromPath(reportLog("ItemSearchGoogleSearchBox")).build());
//				searchBox.sendKeys(Keys.ENTER);
//				staticWait(3);
//				test.pass("Item Searched", MediaEntityBuilder
//						.createScreenCaptureFromPath(reportLog("ItemSearchResultGoogleSearchBox")).build());
//				assertvalueAll(i);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void assertvalueAll(int i) throws IOException {
//		try {
//			String actual = firstresult.getText().trim();
//			highlightElement(firstresult);
//			String expected = cud.getSpecificExpectedData(i);
//			staticWait(3);
//			assertTrue(actual.equalsIgnoreCase(expected));
//			test.pass("Asserting",
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AssertValueIsCorrect")).build());
//		} catch (Throwable e) {
//			test.fail(e.toString(),
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AsseertValueIsInCorrect")).build());
//		}
//	}
//
//	public void searchAllBing() {
//		try {
//
//			CommonUtiltyDataProvider data = new CommonUtiltyDataProvider("SearchItems");
//			int n = data.getRowCount();
//			for (int i = 1; i <= n; i++) {
//				driver.get(OpenAndCloseBrowser.baseUrl);
//				String s = data.getWorkSheet().getRow(i).getCell(0).getStringCellValue().toString();
//				highlightElement(bingSearchBox);
//				bingSearchBox.sendKeys(s);
//				test.pass("search item - Bing Search box",
//						MediaEntityBuilder.createScreenCaptureFromPath(reportLog("ItemSearchBingSearchBox")).build());
//				bingSearchBox.sendKeys(Keys.ENTER);
//				staticWait(3);
//				test.pass("Item Searched", MediaEntityBuilder
//						.createScreenCaptureFromPath(reportLog("ItemSearchResultBingSearchBox")).build());
//				assertvalueAllBing(i);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void assertvalueAllBing(int i) throws IOException {
//		try {
//			String actual = firstresultBingSearch.getText().trim();
//			highlightElement(firstresultBingSearch);
//			String expected = cud.getSpecificExpectedData(i);
//			staticWait(3);
//			System.out.println(expected);
//			assertTrue(actual.equalsIgnoreCase(expected));
//			test.pass("Asserting",
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AssertValueIsCorrect")).build());
//		} catch (Throwable e) {
//			test.fail(e.toString(),
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AsseertValueIsInCorrect")).build());
//		}
//	}
//
//	public void searchAllYahoo() {
//		try {
//
//			CommonUtiltyDataProvider data = new CommonUtiltyDataProvider("SearchItems");
//			int n = data.getRowCount();
//			for (int i = 1; i <= n; i++) {
//				driver.get(OpenAndCloseBrowser.baseUrl);
//				String s = data.getWorkSheet().getRow(i).getCell(0).getStringCellValue().toString();
//				highlightElement(yahooSearchBox);
//				yahooSearchBox.sendKeys(s);
//				test.pass("search item - Yahoo Search box",
//						MediaEntityBuilder.createScreenCaptureFromPath(reportLog("ItemSearchYahooSearchBox")).build());
//				yahooSearchBox.sendKeys(Keys.ENTER);
//				staticWait(3);
//				test.pass("Item Searched", MediaEntityBuilder
//						.createScreenCaptureFromPath(reportLog("ItemSearchResultYahooSearchBox")).build());
//				assertvalueAll(firstresultYahooSearch, i);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void assertvalueAll(WebElement el, int i) throws IOException {
//		try {
//			String actual = el.getText().trim();
//			scrollToElement(el);
//			highlightElement(el);
//			String expected = cud.getSpecificExpectedData(i);
//			staticWait(3);
//			System.out.println(expected);
//			assertTrue(actual.contains(expected));
//			test.pass("Asserting",
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AssertValueIsCorrect")).build());
//		} catch (Throwable e) {
//			test.fail(e.toString(),
//					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AssertValueIsInCorrect")).build());
//		}
//	}
}
