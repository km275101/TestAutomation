package pageFunctionsPageFactory;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.MediaEntityBuilder;
import dataprovider.CommonUtiltyDataProvider;
import pageElementsPageFactory.YahooPagePE;

public class YahooHomePagePF extends YahooPagePE {

	public YahooHomePagePF(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	CommonUtiltyDataProvider cud = new CommonUtiltyDataProvider();
	CommonFunctionPF cfp = new CommonFunctionPF(driver);
	String searchItem = cud.itemName();

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

	public void assertFirst() throws IOException {

		cfp.assertValue(firstresultYahooSearch);

	}

	public void searchAllYahoo() {

		cfp.searchAll(yahooSearchBox, firstresultYahooSearch, "SearchItems");

	}
}
