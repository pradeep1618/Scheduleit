package admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;

public class NewClass {
	public static WebDriver driver;
	static Details ds;
	public static Scheduler sche;
	static WebElement row;
	public static void main(String[] args) throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://app.pradeep.test.scheduleit.io");
		SharedData.getInstance().setDriver(driver);
		Login.getlogin(driver);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'Manage Users')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//a[text()='Adjusters']")).click();
		NewClass testi=new NewClass();
		testi.test();
		
	}
		
		public void loopforTest() throws Exception{
		
		Boolean iselementpresent = driver.findElements(By.xpath("//td[contains(.,'testeroftest897@amail.club')]//following::a[@title='Edit User'][1]")).size()!= 0;
		if(iselementpresent==false)
		{
		do{
				driver.findElement(By.xpath(".//a[contains(.,'Next')]")).click();
				Boolean iselementpresent1 = driver.findElements(By.xpath("//td[contains(.,'testeroftest897@amail.club')]//following::a[@title='Edit User'][1]")).size()!= 0;
				if(iselementpresent1==true){
					break;
				}
		}
		while(iselementpresent==false);	
		}
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//td[contains(.,'"+Details.a_email_value+"')]//following::a[@title='Edit User'][1]")).click();
		
	}
		
		public void excelsheetaccess(String pathoffile, String sheetNo) throws IOException, JXLException
		{
			String FilePath =pathoffile; //"C:\\Users\\pradeepkumar\\Desktop\\Address.xlsx";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// TO get the access to the sheet
			Sheet sh = wb.getSheet(sheetNo);

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();

			for (int row = 0; row < totalNoOfRows; row++)
			{
				for (int col = 0; col < totalNoOfCols; col++)
				{
					System.out.print(sh.getCell(col, row).getContents() + "\t");
				}
				System.out.println();
			}
		}
public void test()throws Exception{
	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	Thread.sleep(1000);
	NewClass exceloperations = new NewClass();
	exceloperations.excelsheetaccess("D:\\Address.xlt", "Sheet1");
	
	
}
		

}
	






























