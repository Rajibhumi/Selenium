package Property;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataIntoPropertFile {

	public static void main(String[] args) throws IOException
	{
		//step 1: create object of property file
		Properties prop = new Properties();

		//step 2: provide the keys and values details
		prop.setProperty("browser", "Edge");
		prop.setProperty("username", "admin");

		//step 3: set the  path for property file
		FileOutputStream file = new FileOutputStream(".\\src\\test\\resources\\WriteData.properties");

		//step 4 : Load the property file
		prop.store(file, "This is my common data file");
	}
}
