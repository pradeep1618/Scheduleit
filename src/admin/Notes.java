package admin;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Notes {
	//This code is from Pradeep
	public static WebDriver driver;
	static Details ds;
	static boolean deployment =true;
	
	public static void main(String[] args) throws Exception {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		 Robot r = new Robot();
	     r.keyPress(KeyEvent.VK_WINDOWS);
	     r.keyPress(KeyEvent.VK_RIGHT);
	     r.keyRelease(KeyEvent.VK_WINDOWS);
	     r.keyRelease(KeyEvent.VK_RIGHT);
		SharedData.getInstance().setDriver(driver);
		driver.get("https://app.pradeep.test.scheduleit.io");
		driver.manage().window().maximize();
		Login.getlogin(driver);
		System.out.println("Adjuster Module Execution Started");
		Notes adjuster = new Notes();
		adjuster.create_Adjuster(driver);
//		adjuster.assertionOfDeploymentAddress();
		adjuster.tableofadjusters(driver);
		adjuster.edit_adjuster(driver);
		adjuster.set_password(driver);
		adjuster.delete_Adjuster(driver);
		adjuster.close();
	
	}
	public void create_Adjuster(WebDriver driver)throws Exception{
		ds = new Details();
		Thread.sleep(1000);
		System.out.println("Creating a new Adjuster in Admin");
		driver.findElement(By.xpath(ds.click_manage_user)).click();
		System.out.println("Manage User link operated");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Adjusters Link Clicked");
		driver.findElement(By.xpath(ds.a_click_adjuster)).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ds.a_add_adjuster)).click();
		System.out.println("Add Adjuster Button Clicked");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ds.a_first_name)).clear();
		driver.findElement(By.xpath(ds.a_first_name)).sendKeys(Details.a_first_name_value);
		System.out.println("Admin first name is " +Details.a_first_name_value);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ds.a_last_name)).clear();
		driver.findElement(By.xpath(ds.a_last_name)).sendKeys(Details.a_last_name_value);
		System.out.println("Admin last name is "+Details.a_last_name_value );
		driver.findElement(By.xpath(ds.a_email)).clear();
		driver.findElement(By.xpath(ds.a_email)).sendKeys(Details.a_email_value);
		System.out.println("Adjuster Email " +Details.a_email_value);
		driver.findElement(By.xpath(ds.a_mobile)).sendKeys(ds.a_mobile_value);
		System.out.println("Adjuster mobile numer " +ds.a_mobile_value);
		driver.findElement(By.xpath(ds.a_address)).sendKeys(ds.a_address_value);
		driver.findElement(By.xpath(ds.a_city)).sendKeys(ds.a_city_value);
		System.out.println("Adjuster is from "+ds.a_city_value+  " city" );
		Thread.sleep(1000);
		
//		String country="Canada";
//		driver.findElement(By.xpath("//select[@id='UserCountry']")).click();
		/*Select sel_cou = new Select(driver.findElement(By.xpath("//select[@id='UserCountry']")));
		sel_cou.selectByValue(country);
		System.out.println(country);
		Thread.sleep(1000);
		if(country=="United States")
		{
		Thread.sleep(1000);
		System.out.println("Selecting State From US");
		Select stat_sel =new Select(driver.findElement(By.xpath(ds.a_state_can)));
		stat_sel.selectByVisibleText("NY");
		System.out.println("Adjuster is from ____state");
		}
		else
		{
			Thread.sleep(1000);
			System.out.println("Selecting State From CANADA");
			Select stat_sel =new Select(driver.findElement(By.xpath(ds.a_state_can)));
			stat_sel.selectByVisibleText("PR");
			System.out.println("Adjuster is from ____state");
		}
		Thread.sleep(1000);*/
		
		System.out.println("Selecting State From US");
		if(driver.findElement(By.xpath("//select[@id='state']")).isEnabled())
		{
			Select stat_sel =new Select(driver.findElement(By.xpath("//select[@id='state']")));
			stat_sel.selectByValue("New York");	
		}
		else 
		{
		Select stat_sel =new Select(driver.findElement(By.xpath(ds.a_us_state)));
		stat_sel.selectByValue("New York");
		}
//		stat_sel.selectByVisibleText("NY");
		System.out.println("Adjuster is from ____state");
		driver.findElement(By.xpath(ds.a_postal_code)).sendKeys(ds.a_postal_code_value);
		System.out.println("Adjuster city postal code "+ds.a_postal_code_value);
		Thread.sleep(1000);
		if(deployment==true){
			driver.findElement(By.xpath(ds.a_deploy_info)).click();
			System.out.println("Deployment Address Needed");
			Thread.sleep(1000);
			driver.findElement(Repositories.a_deop_chck).click();
			Thread.sleep(1000);
			driver.findElement(Repositories.a_deop_address).clear();
			driver.findElement(Repositories.a_deop_address).sendKeys(ds.a_deploy_address);
			System.out.println("Deployment is " +ds.a_deploy_address);
			Thread.sleep(1000);
			driver.findElement(Repositories.a_deop_city).clear();
			driver.findElement(Repositories.a_deop_city).sendKeys(Details.a_deploy_city);
			System.out.println("Deployment city is "+Details.a_deploy_city);
			Thread.sleep(1000);
			
//		Please use below code if Deployment address and adjuster address have a country field.	
			/*String dep_country="Canada";
			Select selC = new Select(driver.findElement(By.xpath("//select[@id='deployment_country']")));
			selC.selectByValue(dep_country);
			if(dep_country.equals("United State")){
				Thread.sleep(500);
				Select sel = new Select(driver.findElement(Repositories.a_deop_state));
				sel.selectByVisibleText("NJ");
			}
			else
			{
				Thread.sleep(1000);
				driver.findElement(Repositories.a_deop_city).clear();
				driver.findElement(Repositories.a_deop_city).sendKeys(Details.a_deploy_city1);
				Select sel = new Select(driver.findElement(Repositories.a_deop_state_cana));
				sel.selectByVisibleText("AB");
				
			}
			*/
			
			Thread.sleep(1000);
			driver.findElement(Repositories.a_deop_post_code).clear();
			driver.findElement(Repositories.a_deop_post_code).sendKeys(ds.a_postal_code_value);
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("No Need of Deployment Address");
			driver.findElement(By.xpath(ds.a_deploy_info)).click();
			System.out.println("Deployment Information done");
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(ds.a_team_info)).click();
		System.out.println("Team Information Done");
		Thread.sleep(1000);
		Select sche_sell = new Select(driver.findElement(By.xpath(ds.a_choose_schedule)));
		sche_sell.selectByVisibleText(ds.a_choose_schedule_value);
		System.out.println("We have selected "+ds.a_choose_schedule_value+" as our team");
		Thread.sleep(1000);
		driver.findElement(By.xpath(ds.a_account_activation)).click();
		Thread.sleep(1000);
		Select acc_acti = new Select(driver.findElement(By.xpath(ds.a_input_send_sms)));
		acc_acti.selectByVisibleText(ds.a_input_sms);
		System.out.println("We choose to send information through " +ds.a_input_sms);
		Thread.sleep(1000);
		driver.findElement(By.xpath(ds.a_submit_button)).click();
		System.out.println("Just Submited information for creating a adjuster");
		System.out.println("Completed Adjuster Creation");
		}
	public void edit_adjuster(WebDriver driver)throws Exception{
		ds = new Details();
		Thread.sleep(1000);
		System.out.println("Editing a Adjuster in Admin");
		driver.findElement(By.xpath(ds.click_manage_user)).click();
		System.out.println("Manage User link operated");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Adjusters Link Clicked");
		Thread.sleep(1000);
		driver.findElement(By.xpath(ds.a_click_adjuster)).click();
		Thread.sleep(1000);
//here we need some loop
		Select redord = new Select(driver.findElement(By.xpath(".//select[@aria-controls='list-adjusters']")));
		redord.selectByVisibleText("100");
		driver.findElement
		(By.xpath(".//td[contains(.,'"+Details.a_first_name_value+ " " +Details.a_last_name_value+"')]//following::a[@title='Edit User'][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(ds.enter_address)).sendKeys("Main Street New York");
		driver.findElement(By.xpath(ds.city)).clear();
		driver.findElement(By.xpath(ds.city)).sendKeys("New York");
		Select city_e = new Select(driver.findElement(By.xpath(".//select[@id='us_state']")));
		city_e.selectByVisibleText("NY");
		driver.findElement(By.xpath(ds.a_e_mobile)).click();
		driver.findElement(By.xpath(ds.a_e_mobile)).sendKeys(Details.s_phoneno_value);
		driver.findElement(By.id("XactwareAccountNumber")).clear();
		driver.findElement(By.id("XactwareAccountNumber")).sendKeys("1234546");
		Thread.sleep(1000);
		ds.findx(ds.a_e_submit_button).click();
		System.out.println("Editing Adjuster Completed");
	
	}
	public void set_password(WebDriver driver)throws Exception{
		ds = new Details();
		System.out.println("Setting Password for Adjuster");
		Thread.sleep(1000);
		Select redord = new Select(driver.findElement(By.xpath(".//select[@aria-controls='list-adjusters']")));
		redord.selectByVisibleText("100");
		driver.findElement(By.xpath(".//td[contains(.,'"+Details.a_first_name_value+ " " +Details.a_last_name_value+"')]//following::a[@title='Set Password'][1]")).click();
		Thread.sleep(1000);
		ds.findx(ds.a_set_password).clear();
		ds.findx(ds.a_set_password).sendKeys(ds.a_set_password_value);
		Thread.sleep(1000);
		ds.findx(ds.a_confirm_password).clear();
		ds.findx(ds.a_confirm_password).sendKeys(ds.a_confirm_password_value);
		Thread.sleep(1000);
		ds.findx(ds.a_e_submit_button).click();
		System.out.println("Setting Password for Adjuster Completed");
	}
	public void delete_Adjuster (WebDriver driver)throws Exception{
//		Delete User
		ds = new Details();
		System.out.println("Deleting Adjuster to save space");
		Thread.sleep(1000);
		Select redord = new Select(driver.findElement(By.xpath(".//select[@aria-controls='list-adjusters']")));
		redord.selectByVisibleText("100");
		driver.findElement(By.xpath(".//td[contains(.,'"+Details.a_first_name_value+ " " +Details.a_last_name_value+"')]//following::a[@title='Delete User'][1]")).click();
		driver.switchTo().alert();
		driver.switchTo().alert().accept();
		System.out.println("Adjuster deleted successfully");
		
	}
	public void close(){
		driver.manage().deleteAllCookies();
		System.out.println("Congratulations");
		System.out.println("You Have ");
		System.out.println("Successfully Completed Operations on Adjuster Module");
		driver.close();
	}
	public void tableofadjusters(WebDriver driver)throws Exception{
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			Thread.sleep(1000);
			driver.findElement(By.xpath(ds.click_manage_user)).click();
			System.out.println("Manage User link operated");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			System.out.println("Adjusters Link Clicked");
			Thread.sleep(1000);
			driver.findElement(By.xpath(ds.a_click_adjuster)).click();
			Thread.sleep(1000);
			WebElement table = driver.findElement(By.xpath("//table[@id='list-adjusters']"));
		    List <WebElement> rows = table.findElements(By.tagName("tr"));
		    int row_Count = rows.size();
		    System.out.println("No Of Rows Found " +row_Count);
		    for(int row=0;row<row_Count;row++)
		    {
		    	int row2=row+1;
		    	List<WebElement> colum = table.findElements(By.tagName("td"));
		    	int colum_Count=colum.size();
		    	System.out.println("No of Cell's found " +colum_Count);
		    	System.out.println("we have "+colum_Count+"th Cell in Row No "+row2);
		    	
		    	for (int column=0; column<colum_Count; column++)
		    	{
		    		 String celtext = colum.get(column).getText();
		    		  int column2=column+1; 
		    		 System.out.println("The text present in Row No "+row2+" and in Cell No "+column2+" is "+celtext+"");
		    	}
		  	 /* boolean element = driver.findElement(Repositories.a_Edit_btn).getSize()!=null;
		  	  	if(element==true)
		  	  	{
		  	  		driver.findElement(Repositories.a_Edit_btn).click();
		  	  			break;
		  	  	}*/
		     }
	}
	
	public void waste(){
		//it is a loop for edit element
		/*		boolean iselementpresent = driver.findElement(By.xpath(".//td[contains(.,'"+Details.a_first_name_value+ " " +Details.a_last_name_value+"')]//following::a[@title='Edit User'][1]")).getSize()!= null;
		if(iselementpresent==false){
		do	{
			if(driver.findElement(By.xpath(".//a[contains(.,'Next')]")).isEnabled())
			{
				driver.findElement(By.xpath(".//a[contains(.,'Next')]")).click();
			}
		else
		{
				boolean iselementpresent1 = driver.findElement(By.xpath(".//td[contains(.,'"+Details.a_first_name_value+ " " +Details.a_last_name_value+"')]//following::a[@title='Edit User'][1]"))
						.getSize()!= null;
				if(iselementpresent1==true){
					break;
			}
				}
		}
		while(iselementpresent==false);	
		}*/
		
		
	}
	public void assertionOfDeploymentAddress()throws Exception{
		ds = new Details();
		Thread.sleep(1000);
		driver.findElement(Repositories.a_deop_switch_sh_lk).click();
		System.out.println("Swithching to scheduler");
		Thread.sleep(1000);
		driver.findElement(Repositories.a_search_adjuster).clear();
		driver.findElement(Repositories.a_search_adjuster).sendKeys("  ");
		Thread.sleep(500);
		driver.findElement(Repositories.f_Adjuster_Ser_Btn).click();
		Thread.sleep(1000);
		driver.findElement(Repositories.a_Adjuster_Choose_Btn).click();
		Thread.sleep(1000);
		driver.findElement(Repositories.a_Manage_adjuster_Btn).click();
		System.out.println("Manage Adjuster Button clicked");
		driver.findElement(Repositories.a_Deploy_Address_linl).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
		Assert.assertEquals("Deploymeny Address Present", ds.a_deploy_address, driver.findElement(Repositories.a_deop_add_bloc).getText());
		Assert.assertEquals("Deploymeny City Present", Details.a_deploy_city, driver.findElement(Repositories.a_deop_city_bloc).getText());
		Assert.assertEquals("Deploymeny City ZIP Code Present", ds.a_postal_code_value, driver.findElement(Repositories.a_deop_zip_bloc).getText());
		Thread.sleep(1000);
		driver.findElement(Repositories.a_user_account).click();
		Thread.sleep(1000);
		driver.findElement(Repositories.a_admin_role_bk).click();
		
		
		
	}
	public void note(){
		
	}
	
}


