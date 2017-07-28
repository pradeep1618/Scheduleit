package admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Scheduler {

	private static WebDriver driver;
	Details ds;
	static WebElement row;

	public static void main(String arg[]) throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Scheduler sched = new Scheduler();
		SharedData.getInstance().setDriver(driver);
		sched.userpage(driver);
		sched.create_schedular();
		sched.edit_schedular();
		sched.delete_schedular(driver);
		
	}

	void userpage(WebDriver driver) {
		try {
			// Here user gets login
			System.out.println("userpage");
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
			String text = "Dashboard";
			// It will check the view of User
			if (driver.getPageSource().contains(text) == true) {
				System.out.print("Logged In");
			} else {
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
			}
			System.out.println("userpage Completed");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void create_schedular() {
		try

		{
			System.out.println("create_schedular Started");
			ds = new Details();
			driver.findElement(By.xpath(ds.click_manage_user)).click();
			Thread.sleep(2000);
			// Click at Schedulers under Manage users option
			driver.findElement(By.xpath(Details.click_scheduler)).click();
			Thread.sleep(2000);
			row = getRowFounderValue("example1", Details.s_first_name_value);
			if (row != null) {
				delete_schedular(driver);
			}
			// Add a new Scheduler 'sarvjeet'
			driver.findElement(By.xpath(Details.add_new_scheduler)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Details.s_first_name)).sendKeys(
					Details.s_first_name_value);
			driver.findElement(By.xpath(Details.s_last_name)).sendKeys(
					Details.s_last_name_value);
			driver.findElement(By.xpath(Details.s_address)).sendKeys(
					Details.s_address_value);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.s_city)).sendKeys(Details.s_city_value);
			Select dropdown1 = new Select(driver.findElement(By
					.xpath(Details.s_state)));
			dropdown1.selectByValue(ds.state_value);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.s_zipcode)).sendKeys(
					Details.s_zipcode_value);
			driver.findElement(By.xpath(Details.s_phoneno)).clear();
			driver.findElement(By.xpath(Details.s_phoneno)).click();
			driver.findElement(By.xpath(Details.s_phoneno)).sendKeys(
					Details.s_phoneno_value);
			driver.findElement(By.xpath(Details.s_personal_emailid)).sendKeys(
					Details.s_personal_emailid_value);
			Thread.sleep(1000);
//			driver.findElement(By.xpath(ds.s_schedule_emailid)).sendKeys(
//					ds.s_schedule_emailid_value);
			driver.findElement(By.xpath(Details.s_password)).sendKeys(
					Details.s_password_value);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.s_confirm_password)).sendKeys(
					Details.s_confirm_password_value);
			Thread.sleep(2000);
			driver.findElement(By.xpath(Details.s_submit_button)).click();
			
			System.out.println("create_schedular Completed");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void edit_schedular() {
		try {
			System.out.println("edit_schedular Started");
			ds = new Details();
			Thread.sleep(4000);
			row = getRowFounderValue("example1",Details.s_first_name_value);
			if (row != null ) {
				row.findElement(By.xpath("//a[@title='Edit User']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(Details.s_last_name)).clear();
				driver.findElement(By.xpath(Details.s_last_name)).sendKeys(
						ds.update_last_name_value);
				driver.findElement(By.xpath(Details.s_phoneno)).clear();
				driver.findElement(By.xpath(Details.s_phoneno)).click();
				driver.findElement(By.xpath(Details.s_phoneno)).sendKeys(
						Details.s_phoneno_value);
				Thread.sleep(2000);
				driver.findElement(By.xpath(ds.click_submit_button)).click();
				System.out.println("edit_schedular Completed");
				
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	void delete_schedular(WebDriver driver) {
		try {
			System.out.println("delete_schedular Started");

			ds = new Details();
			Thread.sleep(4000);
			// This will get the table and delete the scheduler
			WebElement table1 = driver.findElement(By.id("example1"));
			List<WebElement> rowCollection = table1.findElements(By
					.tagName("tr"));
			System.out.println("====================== rowCollection "
					+ rowCollection.size());

			int i_RowNum = 1;
			int rowFound = 0;
			for (WebElement rowElement : rowCollection) {
				List<WebElement> colCollection = rowElement.findElements(By
						.xpath("td"));
				int i_ColNum = 1;
				for (WebElement colElement : colCollection) {
					System.out.println("Row " + i_RowNum + " Column "
							+ i_ColNum + " Data " + colElement.getText());
					i_ColNum = i_ColNum + 1;
					if (colElement.getText().contains(Details.s_first_name_value)) {
						rowFound = i_RowNum;
						break;
					}
				}
				i_RowNum = i_RowNum + 1;
			}

			System.out.println("====================== rowFound " + rowFound);
			if (rowFound != 0) {

				row = rowCollection.get(rowFound - 1);
				row.findElement(By.xpath(".//a[@title='Delete User']")).click();
				driver.switchTo().alert().accept();
				System.out.println("delete_schedular Completed");

			}
		} catch (Exception e)

		{
			e.printStackTrace();
		}

	}
	public WebElement getRowFounderValue(String tableName, String keyword) {
		WebElement row = null;
		WebElement table1 = SharedData.getInstance().getDriver()
				.findElement(By.id(tableName));
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
