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
import pageElementsPageFactory.BingPagePE;
import pageElementsPageFactory.GooglePagePE;
import pageFactoryCore.OpenAndCloseBrowser;

public class BingHomePagePF extends BingPagePE {

	public BingHomePagePF(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	CommonUtiltyDataProvider cud = new CommonUtiltyDataProvider();
	CommonFunctionPF cfp = new CommonFunctionPF(driver);
	String searchItem = cud.itemName();

	public void bingSearch() throws IOException {
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
	
	public void assertvalueBingSearch() throws IOException {
		try {
			String actual = firstresultBingSearch.getText().trim();
			highlightElement(firstresultBingSearch);
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


	public void searchAll() {
		
		cfp.searchAll(bingSearchBox, firstresultBingSearch, "SearchItems");
		
	}
}
