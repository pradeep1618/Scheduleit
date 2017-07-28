package admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Newclaim {

	static WebDriver driver;
	static WebElement row;
	static Details ds;
	
	static GoogleSync gosync;

	public static void main(String[] args) {
		ds = new Details();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(ds.basicURl);
		SharedData.getInstance().setDriver(driver);
		Newclaim claim = new Newclaim();
		claim.check_firms(driver);
		// claim.insert_claim();
		claim.update_appointment_status();
		claim.update_appointment_notes();
	}

	void check_firms(WebDriver driver) {
		try {
			System.out.println("check_firms Started");
			gosync = new GoogleSync();
			// Here user will search adjuster(sarvjeet), if not found then
			// s ystem will create new adjuster
			gosync.nsearch_adjuster(driver);
			Thread.sleep(3000);
			WebDriverWait wait2 = new WebDriverWait(driver, 50);
			WebElement element2 = wait2.until(ExpectedConditions
					.elementToBeClickable(By.xpath(".//a[text()='Choose']")));
			element2.click();
			
			Thread.sleep(7000);
			
			// Here system will check if there is any existing claim present, if
			// not then system will create.
			// click at Show Schedule
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			WebElement element1 = wait1.until(ExpectedConditions
					.elementToBeClickable(By.xpath(ds.schedular_name)));
			element1.click();
			
			driver.findElement(By.xpath(".//*[@id='collapse99']/li[2]/a"))
					.click();
			boolean textpresent = driver.findElements(
					By.xpath(ds.No_claim_available)).size() > 0;
			if (textpresent) {
				// Claim not found9988799310
				Newclaim claims = new Newclaim();
				claims.add_firm_carrier();
			}
			Thread.sleep(6000);
			SharedData.getInstance().driver.findElement(
					By.xpath(ds.click_claim)).click();
			Thread.sleep(5000);
			Boolean registertext = driver.findElements(
					By.xpath(ds.register_text)).size() > 0;
			if (registertext) {
				// claim is present, now fill the question tab
				fill_question_tab();
			} else {
				// Sets the date for appointment, then fill the questing tab
				ds.findx(ds.selet_date_for_appointment).clear();
				ds.findx(ds.selet_date_for_appointment).sendKeys(
						ds.select_date_for_appointment_value);
				ds.findx(ds.select_time).clear();
				ds.findx(ds.select_time).sendKeys(ds.select_time_value);
				Thread.sleep(2000);
				ds.findx(ds.select_endtime).clear();
				ds.findx(ds.select_endtime).sendKeys(ds.select_endtime_value);
				Thread.sleep(2000);
				Select dropdown1 = new Select(
						ds.findx(ds.select_appointment_status));
				dropdown1.selectByValue(ds.select_appoitment_value);
				ds.findx(ds.submit_appointment).click();
				Thread.sleep(6000);
				SharedData.getInstance().driver.findElement(
						By.xpath(ds.click_claim)).click();
				fill_question_tab();
			}
			Thread.sleep(3000);
			another_claim_for_appointment();
			System.out.println("check_firms Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Adding another claim named singh, sarvjeet
	public void another_claim_for_appointment() {
		try {
			System.out.println("another_claim_for_appointment Started");
			Boolean presenttext = driver
					.findElements(By.xpath(ds.click_claim1)).size() > 0;
			if (presenttext) {
				SharedData.getInstance().driver.findElement(
						By.xpath(ds.click_claim1)).click();
			} else {
				ds.findx(ds.schedular_name).click();
				ds.findx(ds.click_at_new_claim).click();
				insert_claim2();
				another_claim_for_appointment();
			}
			Thread.sleep(5000);
			Boolean registertext = driver.findElements(
					By.xpath(ds.register_text)).size() > 0;
			if (registertext) {
				Newclaim claim = new Newclaim();
				claim.fill_question_tab();
			} else {
				ds.findx(ds.selet_date_for_appointment).clear();
				ds.findx(ds.selet_date_for_appointment).sendKeys(
						ds.select_date_for_appoitment_value1);
				ds.findx(ds.select_time).clear();
				ds.findx(ds.select_time).sendKeys(ds.select_time_value);
				Thread.sleep(2000);
				ds.findx(ds.select_endtime).clear();
				ds.findx(ds.select_endtime).sendKeys(ds.select_endtime_value);
				Thread.sleep(2000);
				Select dropdown1 = new Select(
						ds.findx(ds.select_appointment_status));
				dropdown1.selectByValue(ds.select_appoitment_value);
				ds.findx(ds.submit_appointment).click();
				Thread.sleep(5000);
				SharedData.getInstance().driver.findElement(
						By.xpath(ds.click_claim1)).click();
				fill_question_tab();
				System.out.println("another_claim_for_appointment Completed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add_firm_carrier() {
		try {
			System.out.println("add_firm_carrier Started");
			// Here system is adding new firms and carriers.
			ds.findx(ds.schedular_name).click();
			Thread.sleep(2000);
			ds.findx(ds.click_manage_adjuster).click();
			ds.findx(ds.click_firms).click();
			Thread.sleep(2000);
			Select dropdown = new Select(ds.findx(ds.select_firm));
			dropdown.selectByValue(ds.select_firm_value);
			ds.findx(ds.submit_firm_value).click();
			Thread.sleep(2000);
			Select dropdown1 = new Select(ds.findx(ds.select_firm2));
			dropdown1.selectByValue(ds.select_firm2_value);
			ds.findx(ds.submit_firm_value).click();
			Thread.sleep(2000);
			ds.findx(
					"html/body/div[1]/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr[2]/td[4]/h2")
					.click();
			Thread.sleep(5000);
			Select dropdown3 = new Select(
					ds.findx(ds.select_insurance_companines));
			dropdown3.selectByValue(ds.select_insurance_companines_value);
			ds.findx(ds.add_carrier).click();
			Thread.sleep(3000);
			ds.findx(ds.close_button).click();
			Thread.sleep(3000);
			ds.findx(
					"html/body/div[1]/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr[1]/td[4]/h2")
					.click();
			Thread.sleep(7000);
			Select dropdown4 = new Select(
					ds.findx(ds.select_insurance_companines));
			dropdown4.selectByValue(ds.select_insurance_companines_value);
			ds.findx(ds.add_carrier).click();
			Thread.sleep(3000);
			ds.findx(ds.close_button).click();
			Thread.sleep(3000);
			ds.findx(ds.schedular_name).click();
			ds.findx(ds.click_at_new_claim).click();
			// Here claims gets added
			insert_claim();
			Thread.sleep(2000);
			ds.findx(ds.schedular_name).click();
			ds.findx(ds.click_at_new_claim).click();
			// Another claim is added
			insert_claim2();
			Thread.sleep(2000);
			System.out.println("add_firm_carrier Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert_claim() {
		try {
			System.out.println("insert_claim Started");
			// Here user is adding New Claims
			Thread.sleep(100);
			Select dropdown = new Select(driver.findElement(By
					.id("SchedulingType")));
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
					Details.IA_Firm_Number_value);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.Insured_first_name)).sendKeys(
					Details.Insured_first_name_value);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.Insured_last_name)).sendKeys(
					Details.Insured_last_name_value);
			Thread.sleep(1000);
			// Checking Business text field is present
			WebElement element = driver.findElement(By.xpath(Details.Business_name));
			if (element.getText().equals("Business Name ")) {
				driver.findElement(By.xpath(Details.Business_name)).sendKeys("t");
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
			//----------------------------------------------------------------------
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
			
			// This fields are removed for the forms.
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
			driver.findElement(By.xpath(Details.Scheduling_Loss_Notice_Instruction))
					.sendKeys(Details.Scheduling_Loss_Notice_Instruction_value);
			Thread.sleep(2000);
			Select dropdown5 = new Select(driver.findElement(By
					.id(Details.Scheduling_Insurance_Company_id)));
			dropdown5
					.selectByVisibleText(Details.Scheduling_Insurance_Company_id_value);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Details.Scheduling_Claim_No)).sendKeys(
					Details.Scheduling_Claim_No_value);
			Thread.sleep(1000);
			SharedData.getInstance().driver.findElement(
					By.xpath(".//span[text()='Submit and Route']")).click();
			// driver.findElement(By.xpath(".//input[@class='btn btn-success']")).click();
			Thread.sleep(2000);
			System.out.println("insert_claim Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void insert_claim2() {
		try {
			System.out.println("insert_claim2 Started");
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
			System.out.println("insert_claim2 Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void fill_question_tab() {
		try {
			System.out.println("fill_question_tab Started");
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
			System.out.println("fill_question_tab Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void clean_area() {
		System.out.println("clean_area Started");
		ds.findx(ds.edit_comm).clear();
		ds.findx(ds.edit_email).clear();
		ds.findx(ds.edit_i_spoke_to).clear();
		ds.findx(ds.edit_mortage).clear();
		ds.findx(ds.edit_i_damage).clear();
		ds.findx(ds.edit_i_age_of_house).clear();
		System.out.println("clean_area Completed");
	}

	void update_appointment_status() {
		try {
			System.out.println("update_appointment_status Started");
			// updating status for sarvjeet claim
			Thread.sleep(3000);
			Boolean presenttext = driver
					.findElements(By.xpath(ds.click_claim1)).size() > 0;
			if (presenttext) {
				SharedData.getInstance().driver.findElement(
						By.xpath(ds.click_claim1)).click();
			}
			Boolean registertext = driver.findElements(
					By.xpath(ds.register_text)).size() > 0;
			if (registertext) {
			}
			Thread.sleep(2000);
			Select dropdown4 = new Select(driver.findElement(By
					.xpath(".//select[@id='AppointmentStatus']")));
			Thread.sleep(2000);
			dropdown4.selectByValue(ds.select_appoitment_value1);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//input[@class='btn btn-primary']"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//button[text()='close']")).click();
			// updating status for demo claim
			Thread.sleep(3000);
			Boolean presenttext1 = driver
					.findElements(By.xpath(ds.click_claim)).size() > 0;
			if (presenttext1) {
				SharedData.getInstance().driver.findElement(
						By.xpath(ds.click_claim)).click();
			}
			Boolean registertext1 = driver.findElements(
					By.xpath(ds.register_text)).size() > 0;
			if (registertext1) {
			}
			Thread.sleep(2000);
			Select dropdown5 = new Select(driver.findElement(By
					.xpath(".//select[@id='AppointmentStatus']")));
			Thread.sleep(2000);
			dropdown5.selectByValue(ds.select_appoitment_value1);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//input[@class='btn btn-primary']"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//button[text()='close']")).click();
			System.out.println("update_appointment_status Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void update_appointment_notes() {
		try {
			System.out.println("update_appointment_notes Started");
			// update the note for demo claim
			ds = new Details();
			Thread.sleep(3000);
			Boolean presenttext = driver.findElements(By.xpath(ds.click_claim))
					.size() > 0;
			if (presenttext) {
				SharedData.getInstance().driver.findElement(
						By.xpath(ds.click_claim)).click();
			}
			Boolean registertext = driver.findElements(
					By.xpath(ds.register_text)).size() > 0;
			if (registertext) {
			}
			Thread.sleep(2000);
			ds.findx(ds.note_tab).click();
			Select dropdown6 = new Select(ds.findx(ds.add_a_note));
			Thread.sleep(2000);
			dropdown6.selectByValue(ds.add_a_note_value);
			Thread.sleep(2000);
			ds.findx(ds.click_at_add_button).click();
			Thread.sleep(2000);
			// update appointment status from Notes tab\
			Select dropdown11 = new Select(driver.findElement(By
					.xpath(".//select[@id='appoint_status']")));
			String data = "12";
			dropdown11.selectByValue(data);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//button[@id='updatebutton']"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//button[text()='close']")).click();
			// Update for another claim
			Thread.sleep(3000);
			Boolean presenttext1 = driver.findElements(
					By.xpath(ds.click_claim1)).size() > 0;
			if (presenttext1) {
				SharedData.getInstance().driver.findElement(
						By.xpath(ds.click_claim1)).click();
			}
			Boolean registertext1 = driver.findElements(
					By.xpath(ds.register_text)).size() > 0;
			if (registertext1) {
			}
			Thread.sleep(2000);
			ds.findx(ds.note_tab).click();
			Select dropdown7 = new Select(ds.findx(ds.add_a_note));
			dropdown7.selectByValue(ds.add_a_note_value);
			ds.findx(ds.click_at_add_button).click();
			Thread.sleep(2000);
			// update appointment status from Notes tab\
			Select dropdown8 = new Select(driver.findElement(By
					.xpath(".//select[@id='appoint_status']")));
			String data1 = "12";
			dropdown8.selectByValue(data1);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//button[@id='updatebutton']"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//button[text()='close']")).click();
			System.out.println("update_appointment_notes Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public WebElement getRowFounderValue(String tableName, String keyword) {
		WebElement row = null;
		WebElement table1 = driver.findElement(By.className(tableName));
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
