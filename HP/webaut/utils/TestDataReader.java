package HP.webaut.utils;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import HP.webaut.base.GlobalConst;

public class TestDataReader {

	String dataFilePath;
	HashMap<String, String> hmap;
	Properties p;
	Enumeration<?> e;
	String tDataKey;
	String tDataValue;

	public TestDataReader(String dataFilePath) {
		

		try {

			/*System.out.println("Test data file name: " + this.dataFilePath);*/
			hmap = new HashMap<String, String>();
			p = new Properties();
			if (GlobalConst.RUNFROMANT == true) 
			{
				int indexOfLastFrontSlash = dataFilePath.lastIndexOf("/");
				this.dataFilePath = dataFilePath
						.substring(indexOfLastFrontSlash + 1);
				System.out
						.println("Running tests from ANT hence loading test data using getResourceAsStream");
				InputStream inputStream = Thread.currentThread()
						.getContextClassLoader()
						.getResourceAsStream(this.dataFilePath);
				p.load(inputStream);
			} else {
				System.out
						.println("Running tests directly from testng.xml hence loading test data normally");
				p.load(new FileInputStream(GlobalConst.TESTDATASET1));
			}

		} catch (FileNotFoundException e) {

			System.out.println("Problem with loading properties file: "
					+ e.getMessage());

		} catch (IOException e) {
			System.out.println("Problem with loading properties file: "
					+ e.getMessage());
		}

		e = p.propertyNames();
	}

	public HashMap<String, String> getDataMap() {
		while (e.hasMoreElements()) {
			tDataKey = (String) e.nextElement();
			tDataValue = p.getProperty(tDataKey);
			hmap.put(tDataKey, tDataValue);

		}

		return hmap;
	}

}
