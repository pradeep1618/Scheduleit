package admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IAfirm {
	static WebDriver driver;
	static Details ds;
	Scheduler sche;
	static WebElement row;

	public static void main(String[] arg) throws InterruptedException {
		driver = new FirefoxDriver();
		ds = new Details();
		driver.get(ds.basicURl);
		SharedData.getInstance().setDriver(driver);
		driver.manage().window().maximize();
		IAfirm firm = new IAfirm();
		System.out.println("Step 1 Started");
		firm.add_firm();
		System.out.println("Step 2 Started");
		firm.edit_firm();
		System.out.println("Step 3 Started");
		firm.delete_firm();
		System.out.println("Module execution completed");
		System.out.println(" :) SUCESS :)");
		driver.close();
	}

	void add_firm() {
		try {
			System.out.println("Adding firm started");
			ds = new Details();
			sche = new Scheduler();
			sche.userpage(driver);
			ds.findx(ds.click_manage_IA_firm).click();
			Thread.sleep(2000);
			ds.findx(ds.click_firm_name).sendKeys(ds.click_firm_name_value);
			System.out.println("Entered Firm name --");
			System.out.println(ds.click_firm_name_value);
			Thread.sleep(1000);
			ds.findx(ds.click_submit_firm_button).click();
			System.out.println("Data Submitted  "  +ds.click_firm_name_value+"" );
			String dumytxt = "Couldn't add this firm";
			if (driver.getPageSource().contains(dumytxt)) {
				ds.findx(ds.click_firm_name).clear();
				Thread.sleep(2000);
				ds.findx(ds.click_firm_name).sendKeys(ds.click_firm_name_value);
				Thread.sleep(2000);
				ds.findx(ds.click_submit_firm_button).click();
				System.out.println("Adding firm Completed");
			}
	/*		Thread.sleep(3000);
			System.out.println("Step 2 started");
			edit_firm();
			Thread.sleep(3000);
			System.out.println("Step 3 Started");
			delete_firm();*/
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void edit_firm() throws InterruptedException {
		try {
			System.out.println("edit_firm started");
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ds.search_IA_firm)));
			ds.findx(ds.search_IA_firm).clear();
			ds.findx(ds.search_IA_firm).sendKeys(ds.click_firm_name_value);
			System.out.println("Firm name we are searching is " +ds.click_firm_name_value+"");
			Thread.sleep(2000);
			row = getRowFounderValue("firm-listing", ds.click_firm_name_value);
			if (row != null) {
				System.out.println("Firm name found " +ds.click_firm_name_value+"");
				row.findElement(By.xpath(ds.click_on_edit_button)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ds.edit_carrier_id)));
				ds.findx(ds.edit_carrier_id).clear();
				ds.findx(ds.edit_carrier_id).sendKeys("123456");
				System.out.println("We are edting firm name "+ds.click_firm_name_value+"");
				Thread.sleep(2000);
				ds.findx(ds.edit_submit_button).click();
				System.out.println("edit_firm Completed");
			}
		}
		finally {
		}
	}

	void delete_firm() throws InterruptedException {
		try {
			System.out.println("delete_firm started");
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ds.search_IA_firm)));
			ds.findx(ds.search_IA_firm).clear();
			ds.findx(ds.search_IA_firm).sendKeys(ds.click_firm_name_value);
			System.out.println("Searching firm name " +ds.click_firm_name_value+ "  for deleting");
			Thread.sleep(2000);
			row = getRowFounderValue("firm-listing", ds.click_firm_name_value);
			if (row != null) {
				System.out.println("Firm name "+ds.click_firm_name_value+" found ");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Delete Firm']")));
				row.findElement(By.xpath("//a[@title='Delete Firm']")).click();
				System.out.println("Firm name " +ds.click_firm_name_value+ " Deleted");
				System.out.println("Success");
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
				System.out.println(""+ds.click_firm_name_value+ "  firm deletion Completed sucessfully");

			}
		}
		finally {
		}
	}

	public WebElement getRowFounderValue(String tableName, String keyword) {
		WebElement row = null;
		WebElement table1 = driver.findElement(By.id(tableName));
		List<WebElement> rowCollection = table1.findElements(By.tagName("tr"));
		System.out.println("====================== rowCollection "
				+ rowCollection.size());
		int i_RowNum = 1;
		int rowFound = 0;
		for (WebElement rowElement : rowCollection) {
			List<WebElement> colCollection = rowElement.findElements(By
					.xpath("td"));
			int i_ColNum = 1;
			for (WebElement colElement : colCollection) {
				System.out.println("Row " + i_RowNum + " Column " + i_ColNum
						+ " Data " + colElement.getText());
				i_ColNum = i_ColNum + 1;
				if (colElement.getText().contains(keyword)) {
					rowFound = i_RowNum;
					break;
				}
			}
			i_RowNum = i_RowNum + 1;
		}
		System.out.println("====================== rowFound " + rowFound);

		if (rowFound != 0)
			row = rowCollection.get(rowFound - 1);

		return row;
	}

}
