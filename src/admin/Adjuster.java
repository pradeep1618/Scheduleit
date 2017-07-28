package admin;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Adjuster {
	public static WebDriver driver;
	static Details ds;
	public static Scheduler sche;
	static WebElement row;
	
	public static void main(String[] arg) {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		SharedData.getInstance().setDriver(driver);
		Adjuster adjust = new Adjuster();
		adjust.open_new_adjuster(driver);
		adjust.create_adjuster(driver);
		adjust.edit_adjuster();
		adjust.set_password();
	/*	adjust.set_password(); 
		adjust.set_password();
		adjust.set_password();
		adjust.set_password();*/
	}
	public void open_adjuster(WebDriver driver) {
		try {
			System.out.println("open_adjuster started");
			ds = new Details();
			WebDriverWait wait1 = new WebDriverWait(driver,30);
		    WebElement element1 = wait1.until(
		                        ExpectedConditions.elementToBeClickable(By.xpath(ds.click_manage_user)));	
		    element1.click();
			Thread.sleep(2000);
			ds.findx(ds.a_click_adjuster).click();
			Thread.sleep(1000);
		
			System.out.println("open_adjuster Completed");
		} catch (Exception e) {   
			e.printStackTrace();
		}
	}
		// Login then open Adjuster section
		void open_new_adjuster(WebDriver driver) {
			try {
				System.out.println("open_New_adjuster started");
				ds = new Details();
				Scheduler sch=new Scheduler();
				sch.userpage(driver);
				Thread.sleep(2000);
				open_adjuster(driver);
				System.out.println("open_New_adjuster complted");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
// Create New Adjuster and activate the account and Google Sync
	public void create_adjuster(WebDriver driver) {
		try {
			System.out.println("create_adjuster started");
			ds = new Details();
			ds.findx(ds.a_add_adjuster).click();
			ds.findx(ds.a_first_name).sendKeys(Details.a_first_name_value);
			System.out.println(Details.a_first_name_value);
			ds.findx(ds.a_last_name).sendKeys(Details.a_last_name_value);
			System.out.println(Details.a_last_name_value);
			Thread.sleep(2000);
			ds.findx(ds.a_email).sendKeys(Details.a_email_value);
			System.out.println(Details.a_email_value);
			ds.findx(ds.a_mobile).clear();
			ds.findx(ds.a_mobile).click();
			ds.findx(ds.a_mobile).sendKeys(ds.a_mobile_value);
			ds.findx(ds.a_address).sendKeys(ds.a_address_value);
			Thread.sleep(1000);
			ds.findx(ds.a_city).sendKeys(ds.a_city_value);
			Select dropdown1 = new Select(ds.findx(ds.a_state));
			dropdown1.selectByValue(ds.a_state_value);
			ds.findx(ds.a_postal_code).sendKeys(ds.a_postal_code_value);
			Thread.sleep(1000);
			//ds.findx(ds.a_deploy_info).click();
			ds.findx(ds.a_team_info).click();
			Thread.sleep(2000);
			Select dropdown2 = new Select(ds.findx(ds.a_choose_schedule));
			dropdown2.selectByVisibleText(ds.a_choose_schedule_value);
			Thread.sleep(2000);
			ds.findx(ds.a_account_activation).click();
			Select drop = new Select(ds.findx(ds.a_input_send_sms));
			drop.selectByVisibleText(ds.a_input_sms);
			ds.findx(ds.a_submit_button).click();
			System.out.println("Clicked on Submit Button");
			Thread.sleep(4000);
			String Succ= driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
			Assert.assertEquals("Passed", "The adjuster has been sent an email to complete the process.", Succ);
			if (driver
					.getPageSource()
					.contains(
							"Something went wrong. ERROR: A user already exists with this email address.")) {
				Thread.sleep(2000);
				ds.findx(ds.a_account_button).click();
				ds.findx(ds.a_email).clear();
				ds.findx(ds.a_email).sendKeys("herrp@qchome.com");
				ds.findx(ds.a_submit_button).click();
			} else {
				System.out.print("No such text");
			}
			Thread.sleep(3000);
			WebDriverWait wait1 = new WebDriverWait(driver,30);
		    WebElement element1 = wait1.until(
		                        ExpectedConditions.elementToBeClickable(By.xpath(ds.click_manage_user)));	
		    element1.click();
			Thread.sleep(3000);
			ds.findx(ds.a_click_adjuster).click();
			Thread.sleep(3000);
			row = getRowFounderValue("list-adjusters", Details.a_first_name_value );
			if (row != null) {
				// row.findElement(By.xpath(".//a[@title='Change Role']")).click();
				Thread.sleep(2000);
				Boolean googlesyncing = row.findElements(
						By.xpath(".//a[@title='Deactive']")).size() > 0;
				if (googlesyncing) {
					Thread.sleep(2000);
					row.findElement(By.xpath(ds.deactive_status)).click();
					System.out.println("Account active successfull");
					Thread.sleep(2000);
		}
			}
				row = getRowFounderValue("list-adjusters", ds.a_first_name);
				if (row != null) {
					Boolean acc_status = row.findElements(
						By.xpath(".//a[@title='Deactive']")).size() > 0;
				if (acc_status) {
					Thread.sleep(3000);
					ds.findx(ds.deactive_status).click();
					System.out.println("create_adjuster Completed");		
			}
				}
				//	driver.findElement(By.className(".//a[@class='btn btn-primary']")).click();
					
		}	
		 catch (Exception e) {
			e.printStackTrace();
		}
	}

	void edit_adjuster() {
		try {
			System.out.println("edit_adjuster started");
			ds = new Details();
			Thread.sleep(4000);
			row = getRowFounderValue("list-adjusters", Details.a_first_name_value);
			System.out.println(Details.a_first_name_value);
			if (row != null) {
				row.findElement(By.xpath("//a[@title='Edit User']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(ds.a_e_last_name)).clear();
				driver.findElement(By.xpath(ds.a_e_last_name)).sendKeys(
						ds.update_last_name_value);
				driver.findElement(By.xpath(ds.a_e_mobile)).clear();
				driver.findElement(By.xpath(ds.a_e_mobile)).click();
				driver.findElement(By.xpath(ds.a_e_mobile)).sendKeys(
						Details.s_phoneno_value);
				driver.findElement(By.id("XactwareAccountNumber")).clear();
				driver.findElement(By.id("XactwareAccountNumber")).sendKeys("1234546");
				Thread.sleep(2000);
				ds.findx(ds.a_e_submit_button).click();
				System.out.println("edit_adjuster Completed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void set_password() {
		try {
			System.out.println("set_password started");
			ds = new Details();
			Thread.sleep(4000);
			row = getRowFounderValue("list-adjusters", "sarvjeet");
			if (row != null) {
				row.findElement(By.xpath(".//a[@title='Set Password']"))
						.click();
				Thread.sleep(2000);
				ds.findx(ds.a_set_password).clear();
				ds.findx(ds.a_set_password).sendKeys(ds.a_set_password_value);
				Thread.sleep(2000);
				ds.findx(ds.a_confirm_password).clear();
				ds.findx(ds.a_confirm_password).sendKeys(
						ds.a_confirm_password_value);
				Thread.sleep(2000);
				ds.findx(ds.a_e_submit_button).click();
				System.out.println("set_password Completed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	void Rcreate_adjuster(WebDriver driver) {
		try {
			System.out.println("Rcreate_adjuster started");
			ds = new Details();
			ds.findx(ds.a_add_adjuster).click();
			ds.findx(ds.a_first_name).sendKeys(ds.ra_first_name_value);
			ds.findx(ds.a_last_name).sendKeys(ds.ra_last_name_value);
			Thread.sleep(2000);
			ds.findx(ds.a_email).sendKeys(ds.ra_email_value);
			ds.findx(ds.a_mobile).clear();
			ds.findx(ds.a_mobile).click();
			ds.findx(ds.a_mobile).sendKeys(ds.ra_mobile_value);
			ds.findx(ds.a_address).sendKeys(ds.ra_address_value);
			Thread.sleep(1000);
			ds.findx(ds.a_city).sendKeys(ds.ra_city_value);
			Select dropdown1 = new Select(ds.findx(ds.a_state));
			dropdown1.selectByValue(ds.ra_state_value);
			ds.findx(ds.a_postal_code).sendKeys(ds.ra_postal_code_value);
			Thread.sleep(1000);
			ds.findx(ds.a_deploy_info).click();
			ds.findx(ds.a_team_info).click();
			Thread.sleep(2000);
			Select dropdown2 = new Select(ds.findx(ds.a_choose_schedule));
			dropdown2.selectByVisibleText(ds.a_choose_schedule_value);
			Thread.sleep(2000);
			ds.findx(ds.a_submit_button).click();
			Thread.sleep(4000);
			if (driver
					.getPageSource()
					.contains(
							"Something went wrong. ERROR: A user already exists with this email address.")) {
				Thread.sleep(2000);
				ds.findx(ds.a_account_button).click();
				ds.findx(ds.a_email).clear();
				ds.findx(ds.a_email).sendKeys("her@qc54c.com");
				ds.findx(ds.a_submit_button).click();
			} else {
				System.out.print("No such text");
			}
			Thread.sleep(3000);
			WebDriverWait wait1 = new WebDriverWait(driver,30);
		    WebElement element1 = wait1.until(
		                        ExpectedConditions.elementToBeClickable(By.xpath(ds.click_manage_user)));	
		    element1.click();
			Thread.sleep(3000);
			ds.findx(ds.a_click_adjuster).click();
			Thread.sleep(3000);
			row = getRowFounderValue("list-adjusters", "Rebecca");
			if (row != null) {
				// row.findElement(By.xpath(".//a[@title='Change Role']")).click();
				Thread.sleep(2000);
				Boolean googlesyncing = row.findElements(
						By.xpath(".//a[@title='Deactive']")).size() > 0;
				if (googlesyncing) {
					Thread.sleep(2000);
					row.findElement(By.xpath(ds.deactive_status)).click();
					System.out.println("Account active successfull");
					Thread.sleep(2000);
		}
			}
				row = getRowFounderValue("list-adjusters", "Rebecca");
				if (row != null) {
					Boolean acc_status = row.findElements(
						By.xpath(".//a[@title='Deactive']")).size() > 0;
				if (acc_status) {
					Thread.sleep(3000);
					ds.findx(ds.deactive_status).click();
					
			}
				}
				//	driver.findElement(By.className(".//a[@class='btn btn-primary']")).click();
				System.out.println("Rcreate_adjuster Completed");	
		}	
		 catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebElement getRowFounderValue(String tableName, String keyword) {
		WebElement row = null;
		WebElement table1 = SharedData.getInstance().getDriver().findElement(By.id(tableName));
		List<WebElement> rowCollection = table1.findElements(By.tagName("tr"));
		System.out.println("====================== rowCollection "+ rowCollection.size());
		int i_RowNum = 1;
		int rowFound = 0;
		for (WebElement rowElement : rowCollection) 
		{
			List<WebElement> colCollection = rowElement.findElements(By.xpath("td"));
			int i_ColNum = 1;
			for (WebElement colElement : colCollection) 
			{
				System.out.println("Row " + i_RowNum + " Column " + i_ColNum
						+ " Data " + colElement.getText());
				i_ColNum = i_ColNum + 1;
				if (colElement.getText().contains(keyword))
				{
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
