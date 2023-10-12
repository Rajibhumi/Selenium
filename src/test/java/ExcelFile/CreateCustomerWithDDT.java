package ExcelFile;

//Create New Customer With DDT(Property File & Excel File)

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCustomerWithDDT
{
	public static void main(String[] args) throws Exception
	{
		//Read the Common and Test data from both Property file & Excel File

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

		Properties p =new Properties();

		p.load(fis);



		String BROWSER = p.getProperty("browser");

		String URL = p.getProperty("url");

		String USERNAME = p.getProperty("username");

		String PASSWORD = p.getProperty("password");

		
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\createCustomer.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);

		String CUSTNAME = wb.getSheet("CreateCustomer").getRow(1).getCell(2).getStringCellValue();
		String CUSTDESC = wb.getSheet("CreateCustomer").getRow(1).getCell(3).getStringCellValue();

		WebDriver driver=null;

		if (BROWSER.equalsIgnoreCase("Edge"))
		{
			driver = WebDriverManager.edgedriver().create();
			System.out.println("Edge browser launched");
		}

		else if (BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver = WebDriverManager.chromedriver().create();
			System.out.println("Chrome browser launched");
		}

		else if (BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver = WebDriverManager.firefoxdriver().create();
			System.out.println("Firefox browser launched");
		}

		else
		{
			System.out.println("Invalid browser launched");
		}



		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);

		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);

		driver.findElement(By.xpath("//div[text()='Login ']")).click();



		driver.findElement(By.id("container_tasks")).click();

		driver.findElement(By.xpath("//div[text()='Add New']")).click();

		driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();

		driver.findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys(CUSTNAME);



		driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys(CUSTDESC);

		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();


		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Logout']")).click();

		System.out.println("Created New Customer Successfully");

		driver.quit();

	}

}
