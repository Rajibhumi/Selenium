package Property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//TO READ DATA FROM PROPERTY FILE
public class ReadDataFromPropertyFile 
{
	public static void main(String[] args) throws IOException
	{
		//Step 1 : Take the path of the property file
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

		//step 2: create object for property file
		Properties prop = new Properties();

		//step 3: Load the file into object of properties
		prop.load(file);

		//step 4: Get the values of Proprty file based on key
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");

		//printing
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	}
}


