package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Sip300 {
	
	// creating a new claim, routing it, 
	//and then immediately changing the status of the appointment 
	//to Confirmed Appt. When you re-open the event modal, you should see two notes: one for Contact made, and
	//one for Confirmed Appt.
	
	static WebDriver driver;
	static Details ds;
	static Scheduler sche;
	static Newclaim clam;
	
	public static void main(String [] arg)
	{
		ds = new Details();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(ds.basicURl);
		SharedData.getInstance().setDriver(driver);	
		
	}

	
	void loggin()
	{
		try{
			sche = new Scheduler();
			// call login method -------------
			sche.userpage(driver);
			Thread.sleep(2000);
			clam= new Newclaim();
			clam.check_firms(driver);
			
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
	}
	
	void insert_claim2() {
		try {
			// Here user is adding another new claim
			Thread.sleep(3000);
			Select dropdown = new Select(driver.findElement(By
					.id(Details.schedule_type)));
			dropdown.selectByVisibleText(Details.schedule_type_value);
			Thread.sleep(2000);
			Select dropdown1 = new Select(driver.findElement(By
					.id(Details.Schedule_claim_id)));
			dropdown1.selectByVisibleText(Details.Schedule_claim_id_value);
			Thread.sleep(2000);
			Select dropdown2 = new Select(driver.findElement(By
					.id(Details.Schedule_insured_country)));
			dropdown2.selectByVisibleText(Details.Schedule_insured_country_value);
			Thread.sleep(2000);
			Select dropdown3 = new Select(driver.findElement(By
					.id(Details.Scheduling_Firm_Id)));
			dropdown3.selectByVisibleText(Details.Scheduling_Firm_Id_value);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.IA_Firm_Number)).sendKeys(
					Details.IA_Firm_Number_value2);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.Insured_first_name)).sendKeys(
					Details.Insured_first_name_value1);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.Insured_last_name)).sendKeys(
					Details.Insured_last_name_value1);
			Thread.sleep(1000);
			// Checking Business text field is present
			WebElement element = driver.findElement(By.xpath(Details.Business_name));
			if (element.getText().equals("Business Name ")) {
				driver.findElement(By.xpath(Details.Business_name)).sendKeys(
						"New Jonson");
			}
			ds.findx(Details.Scheduling_Insured_Address).sendKeys(
					Details.Scheduling_Insured_Address_value);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.Scheduling_Insured_City)).sendKeys(
					Details.Scheduling_Insured_City_value);
			Thread.sleep(2000);
			Select dropdown4 = new Select(driver.findElement(By
					.id(Details.Scheduling_Insured_StateName)));
			dropdown4
					.selectByVisibleText(Details.Scheduling_Insured_StateName_value);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.postal_code)).sendKeys(
					Details.postal_code_value);
			driver.findElement(By.xpath(Details.Scheduling_Insured_Phone1)).clear();
			driver.findElement(By.xpath(Details.Scheduling_Insured_Phone1)).click();
			driver.findElement(By.xpath(Details.Scheduling_Insured_Phone1))
					.sendKeys(Details.Scheduling_Additional_phone1_value);
			driver.findElement(By.xpath(Details.Scheduling_Insured_Phone2)).clear();
			driver.findElement(By.xpath(Details.Scheduling_Insured_Phone2)).click();
			driver.findElement(By.xpath(Details.Scheduling_Insured_Phone2))
					.sendKeys(Details.Scheduling_Insured_Phone2_value);
			
			// Removes read only property
			/*List<WebElement> inputs = driver.findElements(By
					.xpath(ds.Scheduling_Date_Received));
			for (WebElement input : inputs) {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].removeAttribute('readonly','readonly')",
						input);
			}
			driver.findElement(By.xpath(ds.Scheduling_Date_Received)).clear();
			driver.findElement(By.xpath(ds.Scheduling_Date_Received)).sendKeys(
					"2016-09-28");
			driver.findElement(By.xpath(ds.Scheduling_Time_Received)).clear();
			driver.findElement(By.xpath(ds.Scheduling_Time_Received)).sendKeys(
					ds.Scheduling_Time_Received_value);*/
			//-------------------------------------------------------
			driver.findElement(By.xpath(Details.Scheduling_Additional_phone1)).clear();
			driver.findElement(By.xpath(Details.Scheduling_Additional_phone1)).click();
			driver.findElement(By.xpath(Details.Scheduling_Additional_phone1))
					.sendKeys(Details.Scheduling_Additional_phone1_value);
			driver.findElement(By.xpath(Details.Scheduling_Additional_phone2)).clear();
			driver.findElement(By.xpath(Details.Scheduling_Additional_phone2)).click();
			driver.findElement(By.xpath(Details.Scheduling_Additional_phone2))
					.sendKeys(Details.Scheduling_Additional_phone2_value);
			driver.findElement(By.xpath(Details.Scheduling_insured_email_Id)).clear();
			driver.findElement(By.xpath(Details.Scheduling_insured_email_Id)).sendKeys(Details.Scheduling_insured_email_Id_value);
			driver.findElement(By.xpath(Details.Scheduling_Insured_mortgage)).clear();
			driver.findElement(By.xpath(Details.Scheduling_Insured_mortgage)).sendKeys(Details.Scheduling_Insured_mortgage_value);
			
			driver.findElement(By.xpath(Details.Scheduling_Loss_Notice_Instruction))
					.sendKeys(Details.Scheduling_Loss_Notice_Instruction_value);
			Thread.sleep(2000);
			Select dropdown5 = new Select(driver.findElement(By
					.id(Details.Scheduling_Insurance_Company_id)));
			dropdown5
					.selectByVisibleText(Details.Scheduling_Insurance_Company_id_value);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.Scheduling_Claim_No)).sendKeys(
					Details.Scheduling_Claim_No_value1);
			Thread.sleep(1000);
			SharedData.getInstance().driver.findElement(
					By.xpath(".//span[text()='Submit and Route']")).click();
			// driver.findElement(By.xpath(".//input[@class='btn btn-success']")).click();
			Thread.sleep(2000);
			ds.findx(ds.schedular_name).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='collapse99']/li[2]/a"))
			.click();			
			Thread.sleep(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void fill_question_tab() {
		try {
			Thread.sleep(7000);
			ds.findx(ds.insured_tab).click();
			ds.findx(ds.Question_tab).click();
			clean_area();
			ds.findx(ds.edit_i_spoke_to).sendKeys(ds.edit_i_spoke_to_value);
			ds.findx(ds.edit_i_age_of_house).sendKeys(
					ds.edit_i_age_of_house_value);
			Thread.sleep(2000);
			Select dropdown = new Select(ds.findx(ds.edit_basement));
			dropdown.selectByValue(ds.edit_basement_value);
			Thread.sleep(2000);
			Select dropdown1 = new Select(ds.findx(ds.edit_i_ishouselivable));
			dropdown1.selectByValue(ds.edit_i_ishouselivable_value);
			ds.findx(ds.edit_i_damage).sendKeys(ds.edit_i_damage_value);
			Select dropdown2 = new Select(ds.findx(ds.edit_i_content));
			dropdown2.selectByValue(ds.edit_i_content_value);
			Thread.sleep(2000);
			Select dropdown3 = new Select(ds.findx(ds.edit_i_will_ho_home));
			dropdown3.selectByValue(ds.edit_i_will_ho_home_value);
			Thread.sleep(1000);
			ds.findx(ds.edit_mortage).sendKeys(ds.edit_mortge_value);
			ds.findx(ds.edit_email).sendKeys(ds.edit_email_value);
			ds.findx(ds.edit_i_onway).click();
			ds.findx(ds.edit_contact_name).sendKeys(ds.edit_contact_name_value);
			Thread.sleep(2000);
			ds.findx(ds.edit_contact_number).clear();
			ds.findx(ds.edit_contact_number).click();
			ds.findx(ds.edit_contact_number).sendKeys(
					ds.edit_contact_number_vale);
			ds.findx(ds.edit_comm).sendKeys(ds.edit_comm_value);
			ds.findx(ds.click_update_button).click();
			System.out.println("done");
			ds.findx(ds.close_button).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void clean_area() {
		ds.findx(ds.edit_comm).clear();
		ds.findx(ds.edit_email).clear();
		ds.findx(ds.edit_i_spoke_to).clear();
		ds.findx(ds.edit_mortage).clear();
		ds.findx(ds.edit_i_damage).clear();
		ds.findx(ds.edit_i_age_of_house).clear();
	}



}
