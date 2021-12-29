package dataprovider;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVDataUtility {

	String path = System.getProperty("user.dir") + "\\src\\main\\resources\\Data.csv";

	public String openURL(String tag) throws IOException, CsvException {
		CSVReader readcsv = new CSVReader(new FileReader(path));
		String url = null;
		List<String[]> myData = readcsv.readAll();
		Iterator<String[]> iterator = myData.iterator();
		while (iterator.hasNext()) {
			String[] str = iterator.next();
			for (int i = 0; i < str.length; i++) {
				String value = str[1];
				if (value.equalsIgnoreCase(tag)) {
					url = str[0];
					break;
				}
			}
		}
		return url;
	}
}
