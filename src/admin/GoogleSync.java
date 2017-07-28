package admin;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GoogleSync {

	public static Details ds;
	public static WebDriver driver;
	static Adjuster adjust;
	static WebElement row;
	Scheduler sche;

	public static void main(String[] args) throws InterruptedException {

		ds = new Details();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//driver.get(ds.basicURl);
		SharedData.getInstance().setDriver(driver);
		Thread.sleep(2000);
		GoogleSync gsyn = new GoogleSync();
		//gsyn.open_new_tab();
		 gsyn.search_adjuster(driver); //  search adjuster if not found then create new Adjuster named sarvjeet
		 gsyn.check_adjuster(driver);  // This will verify account status and Google Sync is enabled or not
		 gsyn.adjust_login(driver);  // Accept terms and conditions 
		 gsyn.adjust_section_sync_with_google();
	}

	// Here Adjuster is login as Adjuster not as self scheduler adjuster.

	void check_adjuster(WebDriver driver) {
		try {
			ds=new Details();
			ds.findx(ds.click_myaccount).click();
			Thread.sleep(3000);
			ds.findx(ds.click_return_to_admin_role).click();
			Thread.sleep(2000);
			Adjuster adjus = new Adjuster();
			adjus.open_adjuster(driver);
			Thread.sleep(3000);
			row = getRowFounderValue("list-adjusters", "sarvjeet");
			if (row != null) 
			{
				// row.findElement(By.xpath(".//a[@title='Change Role']")).click();
				Thread.sleep(2000);
				Boolean googlesyncing = row.findElements(
						By.xpath(".//a[@title='Deactive']")).size() > 0;
				if (googlesyncing) 
				{
					Thread.sleep(2000);
					ds.findx(ds.deactive_status).click();
					System.out.println("Account active successfull");
					Thread.sleep(2000);
				}
			}
				row = getRowFounderValue("list-adjusters", "sarvjeet");
				if (row != null) {
				Boolean acc_status = row.findElements(
						By.xpath(".//a[@title='Deactive']")).size() > 0;
				if (acc_status) {
					Thread.sleep(2000);
					ds.findx(ds.deactive_status).click();
					System.out.println("Account active successfull");
					Thread.sleep(1000);
				}
			}
		}
	catch (Exception e) {
			e.printStackTrace();
		}
	}

	void adjust_login(WebDriver driver) {
		try {
			Thread.sleep(2000);
			// Accepting Terms and condition

			row = getRowFounderValue("list-adjusters", "sarvjeet");
			if (row != null) {
				row.findElement(By.xpath(".//i[@class='fa fa-sign-in']"))
						.click();
			}
			Thread.sleep(4000);
			Boolean acc_status = SharedData.getInstance().getDriver().findElements(By.xpath(ds.terms)).size() > 0;
			if (acc_status) {
				SharedData.getInstance().getDriver().findElement(By.xpath(ds.i_agree_checkbox)).click();
				SharedData.getInstance().getDriver().findElement(By.xpath(ds.sign)).clear();
				Thread.sleep(2000);
				SharedData.getInstance().getDriver().findElement(By.xpath(ds.sign)).sendKeys(ds.sign_value);
				SharedData.getInstance().getDriver().findElement(By.xpath(ds.agree_button)).click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void adjust_section_sync_with_google() {
		try {

			// Configuring Adjuster account with Google Calendar
			Thread.sleep(2000);
			SharedData.getInstance().getDriver().findElement(By.xpath(ds.click_show_schedule)).click();
			Boolean buttonpresent=driver.findElements(By.xpath(ds.click_sync_button)).size()>0;
			if(buttonpresent)
			{
			ds.findx(ds.click_sync_button).click();
			Thread.sleep(5000);
			ds.findx(ds.login_google).clear();
			ds.findx(ds.login_google).sendKeys(ds.login_google_value);
			ds.findx(ds.click_next_google).click();
			Thread.sleep(2000);
			ds.findx(ds.password_google).clear();
			ds.findx(ds.password_google).sendKeys(ds.password_google_data);
			ds.findx(ds.login_button).click();
			// Click at allow button
			ds.findx(ds.click_allow_button).click();
			Thread.sleep(9000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	// Here Admin clicks at Swtich role, search for adjuster, if not found then
	// creates new adjuster.

	void search_adjuster(WebDriver driver) {
		try {
			ds = new Details();
			sche = new Scheduler();
			// call login method -------------
			sche.userpage(driver);
			Thread.sleep(2000);
			// This feature is updated ----------------------------------- updated to switch_scheduler
		//	ds.findx(ds.switche_role).click();
			//ds.findx(ds.click_scheduler_for_role_change).click();
			ds.findx(ds.switch_scheduler).click();
			Thread.sleep(3000);
			Boolean acc_status = driver.findElements(By.xpath(ds.terms)).size() > 0;
			if (acc_status) {
				ds.findx(ds.i_agree_checkbox).click();
				ds.findx(ds.sign).clear();
				Thread.sleep(2000);
				ds.findx(ds.sign).sendKeys(ds.sign_value);
				ds.findx(ds.agree_button).click();
				Thread.sleep(2000);
			}
			ds.findx(ds.search_adjuster).clear();
			ds.findx(ds.search_adjuster).sendKeys(ds.search_adjuster_value);
			Thread.sleep(1000);
			ds.findx(ds.click_search_button).click();
			Thread.sleep(4000);
			String text = "No Records Available";
			// Here System is checking that sarvjeet adjuster is available or
			// not.

			if (driver.getPageSource().contains(text)) {
				// sarvjeet is not available, now system will create new
				// adjuster named sarvjeet.
				ds.findx(ds.click_myaccount).click();
				Thread.sleep(2000);
				ds.findx(ds.click_return_to_admin_role).click();
				WebDriverWait wait1 = new WebDriverWait(driver,30);
			    WebElement element1 = wait1.until(
			                        ExpectedConditions.elementToBeClickable(By.xpath(ds.click_manage_user)));	
			    element1.click();
				Thread.sleep(2000);
				ds.findx(ds.a_click_adjuster).click();
				Thread.sleep(1000);

				// Creates new Adjuster

				Adjuster adjust = new Adjuster();
				adjust.create_adjuster(driver);
				//extra
				
				
			}
			// if system founds the adjuster then it will redirect to NewClaim.java file to click choose button.
			
			
				
			/*	WebDriverWait wait = new WebDriverWait(driver,30);
			    WebElement element = wait.until(
			                        ExpectedConditions.elementToBeClickable(By.xpath(ds.switche_role)));	
			    element.click();
				System.out.println("Account active successfull");
				Thread.sleep(10000);
			//	driver.findElement(By.xpath(ds.switche_role)).click();
				Thread.sleep(3000);
				ds.findx(ds.click_scheduler_for_role_change).click();
				Thread.sleep(4000);
				ds.findx(ds.search_adjuster).clear();
				ds.findx(ds.search_adjuster).sendKeys(ds.search_adjuster_value);
				Thread.sleep(1000);
				ds.findx(ds.click_search_button).click();
				Thread.sleep(5000);*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		void nsearch_adjuster(WebDriver driver)
		{
			try{
				search_adjuster(driver);
				Thread.sleep(6000);
			//-- lets check	driver.findElement(By.xpath(ds.switche_role)).click();
				/*WebDriverWait wait1 = new WebDriverWait(driver,30);
			    WebElement element1 = wait1.until(
			                        ExpectedConditions.elementToBeClickable(By.xpath(ds.click_scheduler_for_role_change)));	
			    element1.click();*/
				//ds.findx(ds.click_scheduler_for_role_change).click();
				//Thread.sleep(4000);
				//ds.findx(ds.search_adjuster).clear();
				//ds.findx(ds.search_adjuster).sendKeys(ds.search_adjuster_value);
				//Thread.sleep(1000);
				//ds.findx(ds.click_search_button).click();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	

	public WebElement getRowFounderValue(String tableName, String keyword) {
		WebElement row = null;
		WebElement table1 = SharedData.getInstance().getDriver().findElement(By.id(tableName));
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
