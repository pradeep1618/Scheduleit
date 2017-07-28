package admin;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Syncdata {
	static Details ds;
	static WebDriver driver;
	static WebElement row;

	
	public static void main(String []arg)
	{
		driver= new FirefoxDriver();
		ds=new Details();
		driver.get(ds.basicURl);
		SharedData.getInstance().setDriver(driver);
		System.out.println("Step 1 started");
		open_adjuster(driver);
		System.out.println("Step 2 started");
		Syncdata.newtab();
	}
	
	static void open_adjuster(WebDriver driver)
	{
		try
		{
			Scheduler sche = new Scheduler();
			sche.userpage(driver);  // Login
			//	goo.search_adjuster(driver);
			Adjuster adjust = new Adjuster();  //- open adjuster page
			adjust.open_adjuster(driver); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Syncdata scan = new Syncdata();
			scan.adjust_login1(driver);
			scan.adjust_section_sync_with_google1();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			newtab();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	 void adjust_login1(WebDriver driver) {
		try {
			Thread.sleep(2000);
			// Accepting Terms and condition

			row = getRowFounderValue("list-adjusters", "sarvjeet");
			if (row != null) {
				row.findElement(By.xpath(".//i[@class='fa fa-sign-in']"))
						.click();
			}
			else if(row==null){
			Adjuster adj = new Adjuster();
			adj.create_adjuster(driver);
			row = getRowFounderValue("list-adjusters", "sarvjeet");
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
	 void adjust_section_sync_with_google1() {
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
				Thread.sleep(6000);
				ds.findx(ds.click_allow_button).click();
				Thread.sleep(3000);
				}
				System.out.print("Already configured");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 
	static void newtab()
	{
		try{
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND + "t");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://calendar.google.com/calendar/");
		Thread.sleep(3000);
		Boolean button_present=driver.findElements(By.xpath(ds.login_google)).size()>0;
		if(button_present)		
		{
			ds.findx(ds.login_google).clear();
			ds.findx(ds.login_google).sendKeys(ds.login_google_value);
			ds.findx(ds.click_next_google).click();
			Thread.sleep(2000);
			ds.findx(ds.password_google).clear();
			ds.findx(ds.password_google).sendKeys(ds.password_google_data);
			ds.findx(ds.login_button).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.get("https://calendar.google.com/calendar/");
			
		}
					//SharedData.getInstance().getDriver().findElement(By.xpath(ds.click_menu_button)).click();
		//SharedData.getInstance().getDriver().findElement(By.xpath(ds.click_at_calendar)).click();
		
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + ""+ Keys.TAB);
		}
		catch(Exception e)
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
