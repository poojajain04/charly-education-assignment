package driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public String GetPropertyValue(String filePath, String propertyKey) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		String propertyValue = prop.getProperty(propertyKey);
		return propertyValue;
	}

}
