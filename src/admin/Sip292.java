package admin;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
// Reorder claims in "Claims to be scheduled" section
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Sip292 {
	private static WebDriver driver;
	Details ds;
	static Sheet sh;
	static int currentRow = 1;
	static int totalNoOfRows;
	static int totalNoOfCols;
	

	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		SharedData.getInstance().setDriver(driver);
		try {
			readExcel();
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		Details ds = new Details();
		driver.get(ds.basicURl);
		Sip292 sip1=new Sip292();
		sip1.login();
		sip1.add_claims(driver, currentRow);
		
		
	}
	

	void login()
		{
		try{
			// Login 
			ds = new Details();
			driver.get(ds.basicURl);
			Thread.sleep(2000);
			driver.findElement(By.xpath(ds.email_id)).sendKeys(
					ds.admin_email_id_data);
			driver.findElement(By.xpath(ds.password)).clear();
			driver.findElement(By.xpath(ds.password)).sendKeys(
					ds.admin_password_data);
			driver.findElement(By.xpath(ds.click_Sign_in_button)).click();
			Thread.sleep(2000);
			System.out.println("Login Successfull");
			String text = "Dashboard";
			// It will check the view of User
			if (driver.getPageSource().contains(text) == true) {
				System.out.println("Login Successfull");
				System.out.println("");
			} else {
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
			}
			Thread.sleep(3000);
			//-----------------------------------------------------------------------
			ds.findx(ds.switch_scheduler).click();
			ds.findx(ds.search_adjuster).clear();
			ds.findx(ds.search_adjuster).sendKeys(ds.search_adjuster_value);
			Thread.sleep(1000);
			ds.findx(ds.click_search_button).click();
			System.out.println("Searching Adjuster");
			Thread.sleep(4000);
			String text1 = "No Records Available";
			System.out.println("No Records Available");
			// Here System is checking that sarvjeet adjuster is available or
			// not.

			if (driver.getPageSource().contains(text1)) {
				// sarvjeet is not available, now system will create new
				// adjuster named sarvjeet.
				ds.findx(ds.click_myaccount).click();
				Thread.sleep(2000);
				System.out.println("click_myaccount was Successfull");
				ds.findx(ds.click_return_to_admin_role).click();
				WebDriverWait wait1 = new WebDriverWait(driver,30);
			    WebElement element1 = wait1.until(
			                        ExpectedConditions.elementToBeClickable(By.xpath(ds.click_manage_user)));	
			    element1.click();
				Thread.sleep(2000);
				ds.findx(ds.a_click_adjuster).click();
				System.out.println("click_on_Adjuster was Successfull");
				Thread.sleep(1000);

				// Creates new Adjuster

				Adjuster adjust = new Adjuster();
				adjust.create_adjuster(driver);
				ds.findx(ds.switch_scheduler).click();
				ds.findx(ds.search_adjuster).clear();
				ds.findx(ds.search_adjuster).sendKeys(ds.search_adjuster_value);
				Thread.sleep(1000);
				ds.findx(ds.click_search_button).click();
				System.out.println("search_adjuster_was Successfull");
				
		}
			WebDriverWait wait2 = new WebDriverWait(driver, 50);
			WebElement element2 = wait2.until(ExpectedConditions
					.elementToBeClickable(By.xpath(".//a[text()='Choose']")));
			element2.click();
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			WebElement element1 = wait1.until(ExpectedConditions
					.elementToBeClickable(By.xpath(ds.schedular_name)));
			element1.click();
			WebDriverWait wait3 = new WebDriverWait(driver, 50);
			WebElement element3 = wait3.until(ExpectedConditions
					.elementToBeClickable(By.xpath(".//a[@id='navigation-link_enter_new_claim']")));
			element3.click();
			Thread.sleep(6000);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		}
	
	void add_claims(WebDriver driver, int currentRow)
		{
		ds = new Details();
			try {
				Sheet sheet = Sip292.getExcelSheet();
				if (sheet != null) {
					System.out
							.println("Received ======================== currentRow "
									+ currentRow);
					Thread.sleep(2000);
					Select dropdown = new Select(driver.findElement(By
							.id(Details.schedule_type)));
					dropdown.selectByVisibleText(sheet.getCell(0, currentRow)
							.getContents());
					Thread.sleep(2000);
					Select dropdown1 = new Select(driver.findElement(By
							.id(Details.Schedule_claim_id)));
					dropdown1.selectByVisibleText(sheet.getCell(1, currentRow)
							.getContents());
					Thread.sleep(2000);
					Select dropdown2 = new Select(driver.findElement(By
							.id(Details.Schedule_insured_country)));
					dropdown2.selectByVisibleText(sheet.getCell(2, currentRow)
							.getContents());
					Thread.sleep(2000);
					Select dropdown3 = new Select(driver.findElement(By
							.id(Details.Scheduling_Firm_Id)));
					dropdown3.selectByVisibleText(sheet.getCell(3, currentRow)
							.getContents());
					Thread.sleep(1000);
					driver.findElement(By.xpath(Details.IA_Firm_Number)).sendKeys(
							sheet.getCell(4, currentRow).getContents());
					Thread.sleep(1000);
					driver.findElement(By.xpath(Details.Insured_first_name)).sendKeys(
							sheet.getCell(5, currentRow).getContents());
					Thread.sleep(1000);
					driver.findElement(By.xpath(Details.Insured_last_name)).sendKeys(
							sheet.getCell(6, currentRow).getContents());
					Thread.sleep(1000); // need to add condition ---------------
				//	driver.findElement(By.xpath(ds.Business_name)).sendKeys(
				//			sheet.getCell(7, currentRow).getContents());
					driver.findElement(By.xpath(Details.Scheduling_Insured_Address))
						.sendKeys(sheet.getCell(7, currentRow).getContents());
				Thread.sleep(1000);
					// 9 Number is for Unit
					driver.findElement(By.xpath(Details.Scheduling_Insured_City))
							.sendKeys(sheet.getCell(9, currentRow).getContents());
					Thread.sleep(2000);
					Select dropdown4 = new Select(driver.findElement(By
							.id(Details.Scheduling_Insured_StateName)));
					dropdown4.selectByVisibleText(sheet.getCell(10, currentRow)
							.getContents());
					Thread.sleep(1000);
					driver.findElement(By.xpath(Details.postal_code)).sendKeys(
							sheet.getCell(11, currentRow).getContents());
					driver.findElement(By.xpath(Details.Scheduling_Insured_Phone1))
							.clear();
					driver.findElement(By.xpath(Details.Scheduling_Insured_Phone1))
							.click();
					driver.findElement(By.xpath(Details.Scheduling_Insured_Phone1))
							.sendKeys(sheet.getCell(12, currentRow).getContents());
					driver.findElement(By.xpath(Details.Scheduling_Insured_Phone2))
							.clear();
					driver.findElement(By.xpath(Details.Scheduling_Insured_Phone2))
							.click();
					driver.findElement(By.xpath(Details.Scheduling_Insured_Phone2))
							.sendKeys(sheet.getCell(13, currentRow).getContents());
					//--
					driver.findElement(By.xpath(Details.Scheduling_Additional_phone1))
					.clear();
					driver.findElement(By.xpath(Details.Scheduling_Additional_phone1))
					.click();
					driver.findElement(By.xpath(Details.Scheduling_Additional_phone1))
					.sendKeys(sheet.getCell(14, currentRow).getContents());
					driver.findElement(By.xpath(Details.Scheduling_Additional_phone2))
					.clear();
					driver.findElement(By.xpath(Details.Scheduling_Additional_phone2))
					.click();
					driver.findElement(By.xpath(Details.Scheduling_Additional_phone2))
					.sendKeys(sheet.getCell(15, currentRow).getContents());
					driver.findElement(By.xpath(Details.Scheduling_insured_email_Id)).sendKeys(
							sheet.getCell(16, currentRow).getContents());
					Thread.sleep(1000);
					driver.findElement(By.xpath(Details.Scheduling_Insured_mortgage)).sendKeys(
							sheet.getCell(17, currentRow).getContents());
					Thread.sleep(1000);
					driver.findElement(
							By.xpath(Details.Scheduling_Loss_Notice_Instruction))
							.sendKeys(sheet.getCell(18, currentRow).getContents());
					Thread.sleep(2000);
					Select dropdown5 = new Select(driver.findElement(By
							.id(Details.Scheduling_Insurance_Company_id)));
					dropdown5.selectByVisibleText(sheet.getCell(19, currentRow)
							.getContents());
					Thread.sleep(1000);
					driver.findElement(By.xpath(Details.Scheduling_Claim_No)).sendKeys(
							sheet.getCell(20, currentRow).getContents());
					Thread.sleep(1000);
					driver.findElement(
							By.xpath(".//input[@class='btn btn-success']")).click();
					Thread.sleep(2000);
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		}
			Sip292.sheetCaller();
		}
	void verify_order()
		{
		try{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	
	public static void readExcel() throws BiffException, IOException {
		String FilePath = "D:/SC/SForce/Schedule_It/src/testdata/usadress1.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		sh = wb.getSheet("Sheet1");
		totalNoOfRows = sh.getRows();
		totalNoOfCols = sh.getColumns();
	}

	public static Sheet getExcelSheet() {
		return sh;
	}

	public static void sheetCaller() {
		while (currentRow < totalNoOfRows) {
			if(currentRow <= 7)
			{
				break;
			}
			currentRow = currentRow + 1;
			Sip292 sip=new Sip292();
			sip.add_claims(driver, currentRow);
			
			
				
		}
	}
}
