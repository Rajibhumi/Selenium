package Actitime;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageWithDDT {

	public static void main(String[] args) throws  Exception {
		
		//Step 1 : Read data from the property file
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(file);

		//step 2: Get the values of Property file based on key
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");

		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("Edge")) 
		{
			driver = WebDriverManager.edgedriver().create();
			System.out.println("Edge Browser is Launched");
		}
		else if(BROWSER.equalsIgnoreCase("chrome")) 
		{
			driver = WebDriverManager.edgedriver().create();
			System.out.println("Chrome Browser is Launched");
		}
		else if(BROWSER.equalsIgnoreCase("Safari")) 
		{
			driver = WebDriverManager.edgedriver().create();
			System.out.println("Safari Browser is Launched");
		}
		else
		{
			System.out.println("Invalid Browser  Launched");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.get(URL);

		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

		driver.quit();	
	}
}
