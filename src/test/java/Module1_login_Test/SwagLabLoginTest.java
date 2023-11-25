package Module1_login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_login.SwagLabHomePage;
import Module1_login.SwagLabLoginPage;
import Module1_login.SwagLabMenuPage;

public class SwagLabLoginTest extends BaseClass {

	private static final String TCID = null;
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabMenuPage menu;
	Sheet sh;

	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {
		initializeBrowser();

		login = new SwagLabLoginPage(driver);

		home = new SwagLabHomePage(driver);

		menu = new SwagLabMenuPage(driver);

	}

	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException {
		login.inpSwagLabLoginPageUN(UtilityClass.getDataFromPF("UN"));

		Thread.sleep(2000);

		login.inpSwagLabLoginPagePWD(UtilityClass.getDataFromPF("PWD"));

		Thread.sleep(3000);

		login.clickSwagLabLoginPageLoginBtn();

		Thread.sleep(3000);
	}

	@Test
	public void VerifyTitle() throws EncryptedDocumentException, IOException {

		String actTitle = home.getSwagLabHomePageTitle();

		String exptitle = UtilityClass.getTD(0, 2);

		Assert.assertEquals(actTitle, exptitle, "Faiked:Both results are Failed");

		// home.verifySwagLabHomePageTitle(sh.getRow(0).getCell(2).getStringCellValue());

	}

	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws InterruptedException, IOException {
		if (s1.getStatus() == ITestResult.FAILURE) {
			UtilityClass.captureSS(driver, TCID);
		}

		home.clickSwagLabHomePageMenuBtn();

		Thread.sleep(3000);

		menu.clickSwagLabMenuPageLogout();

		Thread.sleep(3000);

	}

	@AfterClass
	public void CloseBrowser() {
		driver.close();

	}
}
