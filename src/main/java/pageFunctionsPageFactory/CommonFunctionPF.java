package pageFunctionsPageFactory;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.MediaEntityBuilder;
import dataprovider.CommonUtiltyDataProvider;
import pageElementsPageFactory.CommonFunctionPE;
import pageFactoryCore.OpenAndCloseBrowser;

public class CommonFunctionPF extends CommonFunctionPE {

	public CommonFunctionPF(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	CommonUtiltyDataProvider cud = new CommonUtiltyDataProvider();
	String searchItem = cud.itemName();
	
	public void assertValue(WebElement el) throws IOException {
		try {
			String actual = el.getText().trim();
			highlightElement(el);
			scrollToElement(el);
			String expected = cud.getExpectedData();
			staticWait(3);
			assertTrue(actual.contains(expected));
			test.pass("Asserting",
					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AssertValueIsCorrect")).build());
		} catch (Throwable e) {
			test.fail(e.toString(),
					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AsseertValueIsInCorrect")).build());
		}
	}


	public void searchAll(WebElement el, WebElement req,String sheetName) {
		try {
			CommonUtiltyDataProvider data = new CommonUtiltyDataProvider(sheetName);
			int n = data.getRowCount();
			for (int i = 1; i <= n; i++) {
				driver.get(OpenAndCloseBrowser.baseUrl);
				String s = data.getWorkSheet().getRow(i).getCell(0).getStringCellValue().toString();
				highlightElement(el);
				el.sendKeys(s);
				test.pass("search item - Google Search box",
						MediaEntityBuilder.createScreenCaptureFromPath(reportLog("ItemSearchGoogleSearchBox")).build());
				el.sendKeys(Keys.ENTER);
				staticWait(3);
				test.pass("Item Searched", MediaEntityBuilder
						.createScreenCaptureFromPath(reportLog("ItemSearchResultGoogleSearchBox")).build());
				assertvalueAll(req ,i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void assertvalueAll(WebElement el, int i) throws IOException {
		try {
			String actual = el.getText().trim();
			scrollToElement(el);
			highlightElement(el);
			String expected = cud.getSpecificExpectedData(i);
			staticWait(3);
			System.out.println(actual);
			assertTrue(actual.contains(expected));
			test.pass("Asserting",
					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AssertValueIsCorrect")).build());
		} catch (Throwable e) {
			test.fail(e.toString(),
					MediaEntityBuilder.createScreenCaptureFromPath(reportLog("AssertValueIsInCorrect")).build());
		}
	}
}
