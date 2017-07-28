package admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Reports {

	static WebDriver driver;
	static Details ds;
	Scheduler sche;

	public static void main(String[] arg) {
		driver = new FirefoxDriver();
		SharedData.getInstance().setDriver(driver);
		driver.manage().window().maximize();
		Reports report = new Reports();
		report.click_report();
	}

	void click_report() {
		try {
			ds = new Details();
			sche = new Scheduler();
			sche.userpage(driver);
			Thread.sleep(3000);
			ds.findx(ds.click_at_report).click();
			Thread.sleep(2000);
			active_adjuster_report();
			Thread.sleep(3000);
			deployment_location_report(driver);
			totalclaim_byIA();
			active_adjuster_report();
			time_spend_on_claim();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void active_adjuster_report() {
		try {
			System.out.println("active_adjuster_report started operation");
			Thread.sleep(2000);
			ds.findx(ds.click_at_active_adjuster_report).click();
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ds.a_select_to_date)));
			ds.findx(ds.a_select_to_date).clear();
			ds.findx(ds.a_select_to_date).click();
			ds.findx(ds.a_select_to_date).sendKeys(ds.a_select_to_date_value);
			System.out.println("start date selected for Adjuster");
			Thread.sleep(2000);
			ds.findx(ds.a_select_from_date).clear();
			ds.findx(ds.a_select_from_date).sendKeys(
					ds.a_select_from_date_value);
			System.out.println("End Date selected for Adjuster");
			driver.findElement(By.id("UserFldName")).sendKeys("First Name");
			System.out.println("Selected First Name");
			ds.findx(ds.click_preview_button).click();
			System.out.println("active_adjuster_report operation going to complete");
			Thread.sleep(2000);
			Boolean textpresent = driver.getPageSource().contains(
					"Page Not Found");
			System.out.println("active_adjuster_report Completed operation");
			if (textpresent) {
				String IR = "https://app.sarvjeet.test.scheduleit.io/reports/adjusterReport";
				driver.get(IR);
				Thread.sleep(2000);
				System.out.println("Starting next process deployment_location_report");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void deployment_location_report(WebDriver driver) {
		try {
			System.out.println("deployment_location_report Initiated");
			Thread.sleep(2000);
			ds.findx(ds.click_at_deployment_location).click();

			List<WebElement> data = driver.findElements(By
					.xpath(ds.click_at_report_start_date));
			for (WebElement input : data) {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].removeAttribute('readonly','readonly')",
						input);
			}
//			Check this field wether it is text field or mouse over
			
//			ds.findx(ds.click_at_report_start_date).clear();
			ds.findx(ds.click_at_report_start_date).click();
			ds.findx(("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
//			ds.findx(ds.click_at_report_start_date).sendKeys(
//					ds.a_select_to_date_value);
			ds.findx(("//a[@class='ui-state-default']//following::a[contains(.,'4')][3]")).click();
			System.out.println("click_at_report_start_date Completed");
			Thread.sleep(2000);
			List<WebElement> data2 = driver.findElements(By
					.xpath(ds.click_at_report_end_date));
			for (WebElement input1 : data2) {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].removeAttribute('readonly','readonly')",
						input1);
			}
//			ds.findx(ds.click_at_report_end_date).clear();
			ds.findx(ds.click_at_report_end_date).click();
			ds.findx(("//a[@class='ui-state-default']")).click();
			System.out.println("click_at_report_end_date Completed");
//			ds.findx(ds.click_at_report_end_date).sendKeys(
//					ds.a_select_from_date_value);
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ds.click_preview_button)));
			ds.findx(ds.click_preview_button).click();
			System.out.println("Preview button clicked");
			Thread.sleep(2000);
			Boolean textpresent = driver.getPageSource().contains(
					"Page Not Found");
			if (textpresent) {
				String IR = "https://app.sarvjeet.test.scheduleit.io/reports/adjusterReport";
				driver.get(IR);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	void totalclaim_byIA()
	{
		try
		{
			System.out.println("totalclaim_byIA process started");
			Thread.sleep(2000);
			ds.findx(ds.click_at_deployment_location).click();
			List<WebElement> data = driver.findElements(By.xpath(ds.click_at_report_start_date));
			for (WebElement input : data) {((JavascriptExecutor) driver).executeScript(
					"arguments[0].removeAttribute('readonly','readonly')",
					input);
			ds.findx(ds.click_at_report_start_date).clear();
			ds.findx(ds.click_at_report_start_date).click();
			ds.findx(ds.click_at_report_start_date).sendKeys(
			ds.a_select_to_date_value);
			Thread.sleep(2000);
			List<WebElement> data2 = driver.findElements(By
			.xpath(ds.click_at_report_end_date));
			for (WebElement input1 : data2) {
			((JavascriptExecutor) driver).executeScript(
			"arguments[0].removeAttribute('readonly','readonly')",
			input1);
		}
			ds.findx(ds.click_at_report_end_date).clear();
			ds.findx(ds.click_at_report_end_date).click();
			ds.findx(ds.click_at_report_end_date).sendKeys(ds.a_select_from_date_value);
			Thread.sleep(2000);
			ds.findx(ds.click_preview_button).click();
			System.out.println("Preview button clicked");
			System.out.println("totalclaim_byIA process going to complete");
			Thread.sleep(2000);
			Boolean textpresent = driver.getPageSource().contains("Page Not Found");
			if (textpresent) {
				String IR = "https://app2.test.scheduleit.io/reports/adjusterReport";
				driver.get(IR);
				Thread.sleep(2000);
						}
			System.out.println("totalclaim_byIA process completed");
	}
}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	void time_spend_on_claim()
	{
		try
		{
			Select dropdown1 = new Select(driver.findElement(By.id(Details.Schedule_claim_id)));
			dropdown1.selectByValue(Details.Schedule_claim_id_value);
			Thread.sleep(2000);
			Select dropdown2 = new Select(driver.findElement(By
					.id(Details.Schedule_insured_country)));
			dropdown2.selectByIndex(2);
			Thread.sleep(2000);
			Select dropdown3 = new Select(driver.findElement(By
					.id(Details.Scheduling_Firm_Id)));
			dropdown3.selectByVisibleText("demo");
					Thread.sleep(1000);
			driver.findElement(By.xpath(Details.IA_Firm_Number)).sendKeys(
					"");
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.Insured_first_name)).sendKeys(
					"");
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.Insured_last_name)).sendKeys(
					"");
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.Business_name)).sendKeys(
					"");
			driver.findElement(By.xpath(Details.Scheduling_Insured_Address))
					.sendKeys("");
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.Scheduling_Insured_City))
					.sendKeys("");
			Thread.sleep(2000);
			Select dropdown4 = new Select(driver.findElement(By
					.id(Details.Scheduling_Insured_StateName)));
			dropdown4.selectByVisibleText("");
					
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.postal_code)).sendKeys(
					"");
			driver.findElement(By.xpath(Details.Scheduling_Insured_Phone1))
					.clear();
			driver.findElement(By.xpath(Details.Scheduling_Insured_Phone1))
					.click();
			driver.findElement(By.xpath(Details.Scheduling_Insured_Phone1))
					.sendKeys("");
			driver.findElement(By.xpath(Details.Scheduling_Insured_Phone2));

			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			
		}
		
	}
	
	
	
	
}


