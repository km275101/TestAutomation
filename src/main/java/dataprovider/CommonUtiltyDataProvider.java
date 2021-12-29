package dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonUtiltyDataProvider {
	int rowCount;
	public String path = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx";
	public XSSFWorkbook workbook;
	public XSSFSheet worksheet;
	
	public CommonUtiltyDataProvider() {
		
	}
	
	public CommonUtiltyDataProvider(String sheetName) throws IOException{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		worksheet = workbook.getSheet(sheetName);
		rowCount = worksheet.getLastRowNum();
	}
	
	public int getRowCount() {
		return rowCount;
	}
	public XSSFSheet getWorkSheet() {
		return worksheet;
	}
	
	FileInputStream fis;
	static int generatedNumberRandom;

	public List<String> getUserDetails() {
		List<String> userDetails = new ArrayList<String>();
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet worksheet = workbook.getSheet("Login");
			int n = worksheet.getLastRowNum();

			userDetails.add(worksheet.getRow(1).getCell(0).getStringCellValue().toString());
			userDetails.add(worksheet.getRow(1).getCell(1).getStringCellValue().toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return userDetails;

	}

	public String getUrlDetails(String urlTag) {
		String urlDetail = null;
		int n = extractUrl(urlTag);
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet worksheet = workbook.getSheet("urlConfig");
			urlDetail = worksheet.getRow(n).getCell(0).getStringCellValue();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return urlDetail;
	}

	public String itemName() {
		String searchItem = null;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet worksheet = workbook.getSheet("SearchItems");
			int n = worksheet.getLastRowNum();
			Random random = new Random();
			generatedNumberRandom = random.nextInt(n) + 1;
			searchItem = worksheet.getRow(generatedNumberRandom).getCell(0).getStringCellValue();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return searchItem;
	}

	public String getExpectedData() {
		String expectedData = null;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet worksheet = workbook.getSheet("SearchItems");
			int n = worksheet.getLastRowNum();
			expectedData = worksheet.getRow(generatedNumberRandom).getCell(1).getStringCellValue();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return expectedData;
	}
	
	public String getSpecificExpectedData(int i) {
		String expectedData = null;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet worksheet = workbook.getSheet("SearchItems");
			expectedData = worksheet.getRow(i).getCell(1).getStringCellValue();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return expectedData;
	}

	public int extractUrl(String s) {
		int n = 0;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);

			XSSFSheet worksheet = workbook.getSheet("urlConfig");
			int rowCount = worksheet.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) {
				String value = worksheet.getRow(i).getCell(1).getStringCellValue();
				if (value.equalsIgnoreCase(s)) {
					n = i;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}
}
