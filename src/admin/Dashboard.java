package admin;

import java.util.concurrent.TimeUnit;
import jxl.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

	static Details ds;
	static WebElement row;
	static WebDriver driver;
//demo

	void add_claims(WebDriver driver) {
		try {
			System.out.println("add_claims started");
			ds = new Details();
			SharedData.getInstance().setDriver(driver);
			Thread.sleep(2000);
			team_condition(driver);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath(ds.click_my_schedule_button)).click();
			Thread.sleep(3000);
			Boolean Have_text = driver.findElements(
					By.xpath(ds.click_profile_schedule_button)).size() > 0;
			if (Have_text) {
				driver.findElement(By.xpath(ds.click_profile_schedule_button))
						.click();
				Thread.sleep(3000);


			} else {
				driver.findElement(By.xpath(ds.click_myaccount)).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(ds.click_at_logout)).click();
				System.out.print("Now You are login page");
				Thread.sleep(3000);
				driver.findElement(By.xpath(ds.email_id)).sendKeys(
						ds.admin_email_id_data);
				driver.findElement(By.xpath(ds.password)).clear();
				driver.findElement(By.xpath(ds.password)).sendKeys(
						ds.admin_password_data);
				driver.findElement(By.xpath(ds.click_Sign_in_button)).click();
				Thread.sleep(2000);
				WebDriverWait wait1 = new WebDriverWait(driver, 30);
				WebElement element1 = wait1.until(ExpectedConditions
						.elementToBeClickable(By.xpath(ds.click_manage_user)));
				element1.click();
				WebDriverWait wait2 = new WebDriverWait(driver, 30);
				WebElement element2 = wait2.until(ExpectedConditions
						.elementToBeClickable(By
								.xpath(".//a[text()='Adjusters']")));
				element2.click();

				check_text(driver);
				driver.findElement(By.xpath(ds.click_profile_schedule_button))
						.click();
				Thread.sleep(3000);
			}

			if (driver.findElement(By.xpath(ds.click_on_new_claim))
					.isDisplayed()) {
				driver.findElement(By.xpath(ds.click_on_new_claim)).click();
			} else {
				System.out.print("not found");
			}
			System.out.println("add_claims Completed");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void check_text(WebDriver driver) {
		try {
			Thread.sleep(3000);
			SharedData.getInstance().setDriver(driver);
			driver.findElement(By.xpath(".//input[@type='text']")).sendKeys(
					"re");
			Thread.sleep(2000);
			String record_text="No matching records found";
			if(driver.getPageSource().contains(record_text))
			{
				Adjuster adj=new Adjuster();
				adj.Rcreate_adjuster(driver);
				Thread.sleep(4000);
				driver.findElement(By.xpath(".//input[@type='text']")).sendKeys(
						"re");
			}
			SharedData.getInstance().getDriver()
					.findElement(By.xpath(".//a[@title='Change Role']"))
					.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//input[@type='text']")).sendKeys(
					"re");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//i[@class='fa fa-sign-in']"))
					.click();
			Thread.sleep(2000);
			team_condition(driver);
			Thread.sleep(2000);
			driver.findElement(By.xpath(ds.click_my_schedule_button)).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void team_condition(WebDriver driver)
	{
		try{
			Boolean acc_status = SharedData.getInstance().getDriver().findElements(By.xpath(ds.terms)).size() > 0;
			if (acc_status) {
		SharedData.getInstance().getDriver().findElement(By.xpath(ds.i_agree_checkbox)).click();
		SharedData.getInstance().getDriver().findElement(By.xpath(ds.sign)).clear();
		Thread.sleep(2000);
		SharedData.getInstance().getDriver().findElement(By.xpath(ds.sign)).sendKeys(ds.sign_value);
		SharedData.getInstance().getDriver().findElement(By.xpath(ds.agree_button)).click();
		Thread.sleep(2000);
	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	void fill_claims(WebDriver driver, int currentRow) {
		ds = new Details();
		try {
			Sheet sheet = Login.getExcelSheet();
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
				driver.findElement(By.xpath(Details.Business_name)).sendKeys(
						sheet.getCell(7, currentRow).getContents());
				driver.findElement(By.xpath(Details.Scheduling_Insured_Address))
						.sendKeys(sheet.getCell(8, currentRow).getContents());
				Thread.sleep(1000);
				// 9 Number is for Unit
				driver.findElement(By.xpath(Details.Scheduling_Insured_City))
						.sendKeys(sheet.getCell(10, currentRow).getContents());
				Thread.sleep(2000);
				Select dropdown4 = new Select(driver.findElement(By
						.id(Details.Scheduling_Insured_StateName)));
				dropdown4.selectByVisibleText(sheet.getCell(11, currentRow)
						.getContents());
				Thread.sleep(1000);
				driver.findElement(By.xpath(Details.postal_code)).sendKeys(
						sheet.getCell(12, currentRow).getContents());
				driver.findElement(By.xpath(Details.Scheduling_Insured_Phone1))
						.clear();
				driver.findElement(By.xpath(Details.Scheduling_Insured_Phone1))
						.click();
				driver.findElement(By.xpath(Details.Scheduling_Insured_Phone1))
						.sendKeys(sheet.getCell(13, currentRow).getContents());
				driver.findElement(By.xpath(Details.Scheduling_Insured_Phone2))
						.clear();
				driver.findElement(By.xpath(Details.Scheduling_Insured_Phone2))
						.click();
				driver.findElement(By.xpath(Details.Scheduling_Insured_Phone2))
						.sendKeys(sheet.getCell(14, currentRow).getContents());
				//--
				driver.findElement(By.xpath(Details.Scheduling_Additional_phone1))
				.clear();
				driver.findElement(By.xpath(Details.Scheduling_Additional_phone1))
				.click();
				driver.findElement(By.xpath(Details.Scheduling_Additional_phone1))
				.sendKeys(sheet.getCell(15, currentRow).getContents());
				driver.findElement(By.xpath(Details.Scheduling_Additional_phone2))
				.clear();
				driver.findElement(By.xpath(Details.Scheduling_Additional_phone2))
				.click();
				driver.findElement(By.xpath(Details.Scheduling_Additional_phone2))
				.sendKeys(sheet.getCell(16, currentRow).getContents());
				driver.findElement(By.xpath(Details.Scheduling_insured_email_Id)).sendKeys(
						sheet.getCell(17, currentRow).getContents());
				Thread.sleep(1000);
				driver.findElement(By.xpath(Details.Scheduling_Insured_mortgage)).sendKeys(
						sheet.getCell(18, currentRow).getContents());
				Thread.sleep(1000);
				
				/*List<WebElement> inputs = driver.findElements(By
						.xpath(ds.Scheduling_Date_Received));
				for (WebElement input : inputs) {
					((JavascriptExecutor) driver)
							.executeScript(
									"arguments[0].removeAttribute('readonly','readonly')",
									input);
				}
				driver.findElement(By.xpath(ds.Scheduling_Date_Received))
						.clear();
				driver.findElement(By.xpath(ds.Scheduling_Date_Received))
						.sendKeys("2016-09-28");	
				driver.findElement(By.xpath(ds.Scheduling_Time_Received))
						.clear();
				driver.findElement(By.xpath(ds.Scheduling_Time_Received))
						.sendKeys(ds.Scheduling_Time_Received_value);*/
				driver.findElement(
						By.xpath(Details.Scheduling_Loss_Notice_Instruction))
						.sendKeys(sheet.getCell(19, currentRow).getContents());
				Thread.sleep(2000);
				Select dropdown5 = new Select(driver.findElement(By
						.id(Details.Scheduling_Insurance_Company_id)));
				dropdown5.selectByVisibleText(sheet.getCell(20, currentRow)
						.getContents());
				Thread.sleep(1000);
				driver.findElement(By.xpath(Details.Scheduling_Claim_No)).sendKeys(
						sheet.getCell(21, currentRow).getContents());
				Thread.sleep(1000);
				driver.findElement(
						By.xpath(".//input[@class='btn btn-success']")).click();
				Thread.sleep(2000);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Login.sheetCaller();
	}

}
