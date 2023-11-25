package Module1_login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage 
{
	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement UN;
@FindBy(xpath = "//input[@id='password']")
private WebElement PWD;
@FindBy(xpath = "//input[@id='login-button']")
private WebElement Login;

public SwagLabLoginPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
public void inpSwagLabLoginPageUN(String username)
{
	UN.sendKeys(username);
}
public void inpSwagLabLoginPagePWD(String password)
{
	PWD.sendKeys(password);
}
public void clickSwagLabLoginPageLoginBtn() 
{
Login.click();
}
}
