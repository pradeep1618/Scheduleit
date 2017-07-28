package admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Users {
	private static WebDriver driver;
	Details ds;
	public static Scheduler sche;

	public static void main(String[] arg) {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		Users ur = new Users();
		ur.userpage(driver);
		ur.createuser();
		ur.modifyuser();
		ur.deleteuser();
	}

	void userpage(WebDriver driver) {
		try {
			sche = new Scheduler();
			sche.userpage(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void createuser() {
		try {
			System.out.println("create user process started");
			// here user will click on add new admin button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(.,'Manage Users')]")).click();
//			driver.findElement(By.xpath(ds.click_manage_user)).click();
			System.out.println("clicked on Manager User link");
			Thread.sleep(2000);
//			driver.findElement(By.xpath(ds.click_admin_user)).click();
			driver.findElement(By.xpath("//a[contains(.,'Admin Users')]")).click();
			System.out.println("clicked on admin user");
//			driver.findElement(By.xpath(ds.add_new_admin)).click();
			driver.findElement(By.xpath("//a[contains(.,'Add admin user']")).click();
			System.out.println("clicked on add new admin button");
			Thread.sleep(2000);
			driver.findElement(By.xpath(ds.first_name)).sendKeys(
					ds.first_name_value);
			System.out.println("Admin first name entered" +ds.first_name_value+ "");
			driver.findElement(By.xpath(ds.last_name)).sendKeys(
					ds.last_name_value);
			System.out.println("Admin first name "+ds.last_name_value+ "");
			System.out.println("Admin last name entered");
			driver.findElement(By.xpath(ds.enter_email_id)).sendKeys(
					ds.enter_email_value);
			System.out.println("Admin email has passed");
			Thread.sleep(1000);
			driver.findElement(By.xpath(ds.enter_password)).sendKeys(
					ds.enter_confirm_password_value);
			System.out.println("password" + ds.enter_confirm_password_value);
			driver.findElement(By.xpath(ds.enter_confirm_passoword)).sendKeys(
					ds.enter_confirm_password_value);
			
			System.out.println("Confirmed password" + ds.enter_confirm_password_value );
			
			driver.findElement(By.xpath(ds.enter_address)).sendKeys(
					ds.enter_address_value);
			driver.findElement(By.xpath(ds.city)).sendKeys(ds.city_value);
			Select dropdown1 = new Select(
					driver.findElement(By.xpath(ds.state)));
			dropdown1.selectByValue(ds.state_value);
			Thread.sleep(2000);
			driver.findElement(By.xpath(ds.zip_code)).sendKeys(
					ds.zip_code_value);
			driver.findElement(By.xpath(ds.enter_phone_no)).clear();
			driver.findElement(By.xpath(ds.enter_phone_no)).click();
			driver.findElement(By.xpath(ds.enter_phone_no)).sendKeys(
					ds.enter_phone_no_value);
			Thread.sleep(5000);
			driver.findElement(By.xpath(ds.click_submit_button)).click();
			Thread.sleep(5000);
			if (driver.getPageSource().contains(
					"* This email address already exist")) {
				driver.findElement(By.xpath(ds.enter_email_id)).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath(ds.enter_email_id)).sendKeys(
						"demo@demo.com");
				Thread.sleep(2000);
				driver.findElement(By.xpath(ds.click_submit_button)).click();
				driver.findElement(By.xpath(ds.enter_email_id)).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath(ds.enter_email_id)).sendKeys(
						"demo1@demo.com");
				Thread.sleep(2000);
				driver.findElement(By.xpath(ds.click_submit_button)).click();
				System.out.println("Data submitted");
			}
			else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void modifyuser() {
		try {
			ds = new Details();
			Thread.sleep(4000);
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
					if (colElement.getText().contains("Sarvjeet")) {
						rowFound = i_RowNum;
						break;
					}
				}
				i_RowNum = i_RowNum + 1;
			}
			System.out.println("====================== rowFound " + rowFound);

			WebElement row = rowCollection.get(rowFound - 1);
			row.findElement(By.xpath(".//a[@title='Edit User']")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath(ds.last_name)).clear();
			driver.findElement(By.xpath(ds.last_name)).sendKeys(
					ds.update_last_name_value);
			driver.findElement(By.xpath(ds.enter_phone_no)).clear();
			driver.findElement(By.xpath(ds.enter_phone_no)).click();
			driver.findElement(By.xpath(ds.enter_phone_no)).sendKeys(
					ds.update_enter_phone_no_value);
			Thread.sleep(2000);
			driver.findElement(By.xpath(ds.click_submit_button)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void deleteuser() {
		try {
			ds = new Details();

			Thread.sleep(4000);

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
					if (colElement.getText().contains("Sarvjeet")) {
						rowFound = i_RowNum;
						break;
					}
				}
				i_RowNum = i_RowNum + 1;
			}

			System.out.println("====================== rowFound " + rowFound);

			WebElement row = rowCollection.get(rowFound-1);
			row.findElement(By.xpath(".//a[@title='Delete User']")).click();
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
