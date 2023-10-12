package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageRepo 
{
	//we will not run any in src/main
	@FindBy(id="username")
	private WebElement userNameId;

	@FindBy(name="pwd")
	private WebElement passWord;

	@FindBy(xpath="//div[text()='Login ']")
	private WebElement loginBtn;
	
	public LoginPageRepo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameId() {
		return userNameId;
	}



	public WebElement getPassWord() {
		return passWord;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginIntoApp(String USERNAME,String PASSWORD)
	{
		userNameId.sendKeys(USERNAME);
		passWord.sendKeys(PASSWORD);
		loginBtn.click();
	}




}
