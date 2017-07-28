package admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

	private static WebDriver driver;
	static Details ds;
	static Dashboard dash;
	static Sheet sh;
	static int currentRow = 1;
	static int totalNoOfRows;
	static int totalNoOfCols;

	public  void main(String[] args) {
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
		getlogin(driver);
	}

	public static void getlogin(WebDriver driver) {
		try {
			ds = new Details();
			System.out.println("Welcome to ScheduleIT Web Appliation");
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath(ds.email_id))
					.sendKeys(ds.email_id_data);
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath(ds.password)).clear();
			driver.findElement(By.xpath(ds.password))
					.sendKeys(ds.password_data);
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath(ds.click_Sign_in_button)).click();
			System.out.println("      Login Successfull      ");
		/*	Thread.sleep(5000);
			dash = new Dashboard();
			dash.add_claims(driver);
			if (currentRow < totalNoOfRows) {
				dash.fill_claims(driver, currentRow);
				currentRow = currentRow + 1;
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readExcel() throws BiffException, IOException {
		String FilePath = "D:/SC/SForce/Schedule_It/src/testdata/usadress.xls";
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
		if (currentRow < totalNoOfRows) {
			currentRow = currentRow + 1;
			dash.fill_claims(driver, currentRow);
		}
	}
}
