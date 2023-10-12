package ExcelFile;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCustomer
{
	public static void main(String[] args) throws Throwable
	{
		WebDriver driver = WebDriverManager.edgedriver().create();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");

		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();

		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys("Attra1Synechron");

		driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys("Creating New Customer");

		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Logout']")).click();

		System.out.println("Created New Customer Successfully");
		Thread.sleep(3000);
		driver.quit();

	}

}


