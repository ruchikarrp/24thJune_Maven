package Module1_login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage {
	@FindBy(xpath = "//button[text()='Open Menu']")
	private WebElement menu;
	WebDriver driver;

	public SwagLabHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//public void verifySwagLabHomePageTitle(String expTitle) 
//{
//	String actTitle=driver.getTitle();
//	String expTitle1="Swag-Labs";
//	
//	if(actTitle.equals(expTitle))
//	{
//		System.out.println("Pass");
//	}
//	else
//	{
//		System.out.println("Fail");
//	}

	public String getSwagLabHomePageTitle() {
		String actTitle = driver.getTitle();
		return actTitle;

	}

	public void clickSwagLabHomePageMenuBtn()

	{
		menu.click();
	}

}
