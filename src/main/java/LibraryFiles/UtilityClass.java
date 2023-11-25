package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass {
public static String getTD(int rowindex,int colindex) throws EncryptedDocumentException, IOException
{
	//FileInputStream file=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Selenium\\TestData\\03Oct2023.xlsx");
	
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\203Oct2023.xlsx");

	Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
	
	String value = sh.getRow(rowindex).getCell(colindex).getStringCellValue();
	return value;

}
public static void captureSS(WebDriver driver, String TCID) throws IOException 
{
File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

// File dest=new File("D:\\workspace\\24th June Selenium\\FailedTCesSS\\TestCaseID" +TCID+ ".jpg");

File dest=new File(System.getProperty("user.dir")+"\\FailedTCesSS\\TestCaseID" +TCID+ ".jpg");

FileHelper.copyFile(src, dest);
}
public static String getDataFromPF(String Kay) throws IOException
{
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\propertyfile.properties");
	
	Properties p=new Properties();
	
	p.load(file);
	
	String value = p.getProperty(Kay);
	
	return value;
	
}

}
