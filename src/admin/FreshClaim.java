package admin;

import java.awt.AWTException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FreshClaim {
//This test case was prepared by Mr Pradeep
	public static WebDriver driver;
	static Details ds;
	public static void main(String[] args) throws Exception {
//   	Creating single appointment 
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		SharedData.getInstance().setDriver(driver);
		driver.get("https://app.sarvjeet.test.scheduleit.io");
		Login.getlogin(driver);
		FreshClaim create = new FreshClaim();
		Adjuster_new adjuster = new Adjuster_new();
		adjuster.create_Adjuster(driver);
		Adjuster adjust = new Adjuster();
		adjust.open_adjuster(driver);
		adjust.create_adjuster(driver);
		Thread.sleep(3000);
		create.Switch_to_Scheduler();
		create.insert_claim();
		create.schedule_Appontment(driver);
		create.setQuestion();
		create.close();
		}		
	
	
	public void Switch_to_Scheduler() throws InterruptedException, AWTException{
		System.out.println("Scheduler activity initiated");
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		driver.findElement(Repositories.f_Switch_to_Scheduler).click();
		driver.findElement(Repositories.f_Adjuster_Search).clear();
		System.out.println("Searching for Adjuster");
		driver.findElement(Repositories.f_Adjuster_Search).sendKeys("  ");
		driver.findElement(Repositories.f_Adjuster_Ser_Btn).click();
		Thread.sleep(2000);
		System.out.println("Searcing by this email  "  +Details.a_email_value+"");
/*		boolean iselementpresent = driver.findElements(Repositories.f_Adjuster_Ser_Btn).size()!= 0;
		if(iselementpresent==false)
		{
		do{
			if(driver.findElement(By.xpath(".//a[contains(.,'Next')]")).isEnabled()){
				driver.findElement(By.xpath(".//a[contains(.,'Next')]")).click();
			}
			else{
				Boolean iselementpresent1 = driver.findElements(Repositories.f_Adjuster_Ser_Btn).size()!= 0;
				if(iselementpresent1==true){
					break;
				}
				}

		}
		while(iselementpresent==false);	
		}*/
		driver.findElement(Repositories.f_Adjuster_Choose_Btn).click();
		System.out.println("Initiating Manager Adjuster operation");
		driver.findElement(Repositories.f_Manage_adjuster_Btn).click();
		System.out.println("Manager Adjuster operation started");
		driver.findElement(Repositories.f_Firm_Adjuster_linl).click();
		System.out.println("Setting Firm & Carriers");
		/*Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='suggest_firm']")).click();*/
		Thread.sleep(2000);
		Select sel = new Select(driver.findElement(Repositories.f_Firm_drop));
		sel.selectByValue("148");
		sel.selectByValue("148");
		System.out.println("Firm Selected");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
//		sel.deselectByVisibleText("AAN");
		driver.findElement(Repositories.f_Associate_btn).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(Repositories.f_Firm_Adjuster_linl).click();
		Thread.sleep(1000);
		System.out.println("Selected Firms & Carriers for seletiong insurance company");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		Thread.sleep(2000);
		driver.findElement(Repositories.f_Insurance_Comp_Asso).click();
		driver.switchTo().activeElement();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Select sel2=new Select(driver.findElement(Repositories.f_Insurance_comp_drop));
		sel2.selectByIndex(1);
		driver.findElement(Repositories.f_Add_Insurance_Comp).click();
		System.out.println("Insurance company assigned to the firm successfully");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
//		driver.findElement(By.xpath("//div/a[contains(.,'Show Schedule')]")).click();
		System.out.println(Details.a_first_name_value + Details.a_last_name_value);
		Thread.sleep(2000);	
		driver.findElement(Repositories.f_Adjuster_lnk).click();
//	creating a new claim through Adjuster
		System.out.println("Ready to enter new claim");
		Thread.sleep(2000);	
		driver.findElement(Repositories.f_Enter_new_Claim_btn).click();
		
	}
	
	public void insert_claim() {
		try {
			System.out.println("New claim creation initiated ");
			// Here user is adding New Claims
			Thread.sleep(1000);
			Select dropdown = new Select(driver.findElement(Repositories.f_insurance_type));
			dropdown.deselectByIndex(2);
//			dropdown.selectByVisibleText(Details.schedule_type_value);
			System.out.println(Details.schedule_type_value);
			Thread.sleep(2000);
			Select dropdown1 = new Select(driver.findElement(Repositories.f_scheduler_type));
			dropdown1.selectByVisibleText(Details.Schedule_claim_id_value);
			System.out.println("claim id is" + Details.Schedule_claim_id_value);
			Thread.sleep(2000);
			Select dropdown2 = new Select(driver.findElement(Repositories.f_Insured_Couontry));
			dropdown2.selectByVisibleText(Details.Schedule_insured_country_value);
			System.out.println("Country selected" + Details.Schedule_insured_country_value);
			Thread.sleep(2000);
			Select dropdown3 = new Select(driver.findElement(Repositories.f_Schedule_firm));
			dropdown3.selectByIndex(1);
			System.out.println("Firm name selected successfully by index");
//			dropdown3.selectByVisibleText(Details.Scheduling_Firm_Id_value);
			Thread.sleep(1000);
			driver.findElement(Repositories.f_IA_firm_number).sendKeys(Details.IA_Firm_Number_value);
			System.out.println("IA firm number is "  +Details.IA_Firm_Number_value);
			Thread.sleep(1000);
			driver.findElement(Repositories.f_Insured_Fir_Name).sendKeys(Details.Insured_first_name_value);
			System.out.println("Insured first name" +Details.Insured_first_name_value);
			Thread.sleep(1000);
			driver.findElement(Repositories.f_Insured_las_Name).sendKeys(Details.Insured_last_name_value);
			System.out.println("Insured last name" +Details.Insured_last_name_value);
			Thread.sleep(1000);
			// Checking Business text field is present
			WebElement element = driver.findElement(Repositories.f_business_name);
			if (element.getText().equals("Business Name ")) {
				driver.findElement(Repositories.f_business_name).sendKeys("t");
			}
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Actions acc = new Actions(driver);
			acc.sendKeys(Keys.TAB).build().perform();
			driver.findElement(Repositories.f_Insured_address).sendKeys(Details.Scheduling_Insured_Address_value);
			System.out.println("Insured person address is  "  +Details.Scheduling_Insured_Address_value);
			Thread.sleep(1000);
			driver.findElement(Repositories.f_insured_city).sendKeys(Details.Scheduling_Insured_City_value);
			System.out.println("City " +Details.Scheduling_Insured_City_value);
			Thread.sleep(2000);
			Select dropdown4 = new Select(driver.findElement(Repositories.f_Insured_state));
			dropdown4.selectByVisibleText(Details.Scheduling_Insured_StateName_value);
			System.out.println("State " +Details.Scheduling_Insured_StateName_value);
			Thread.sleep(1000);
			driver.findElement(Repositories.f_Post_Code).sendKeys(Details.postal_code_value);
			System.out.println("Pincode "+Details.postal_code_value);
			
			driver.findElement(Repositories.f_Insured_Phone1).clear();
			driver.findElement(Repositories.f_Insured_Phone1).click();
			driver.findElement(Repositories.f_Insured_Phone1).sendKeys(Details.Scheduling_Additional_phone1_value);
			System.out.println("insured mobile number "  +Details.Scheduling_Additional_phone1_value);
			
			driver.findElement(Repositories.f_Insured_phone2).clear();
			driver.findElement(Repositories.f_Insured_phone2).click();
			driver.findElement(Repositories.f_Insured_phone2).sendKeys(Details.Scheduling_Insured_Phone2_value);
			//----------------------------------------------------------------------
//			driver.findElement(By.xpath(Details.Scheduling_Additional_phone1)).clear();
//			driver.findElement(By.xpath(Details.Scheduling_Additional_phone1)).click();
//			driver.findElement(By.xpath(Details.Scheduling_Additional_phone1))
//					.sendKeys(Details.Scheduling_Additional_phone1_value);
//			driver.findElement(By.xpath(Details.Scheduling_Additional_phone2)).clear();
//			driver.findElement(By.xpath(Details.Scheduling_Additional_phone2)).click();
//			driver.findElement(By.xpath(Details.Scheduling_Additional_phone2))
//					.sendKeys(Details.Scheduling_Additional_phone2_value);
			driver.findElement(Repositories.f_Insured_Email).clear();
			driver.findElement(Repositories.f_Insured_Email).sendKeys(Details.Scheduling_insured_email_Id_value);
			
			driver.findElement(Repositories.f_Mortgage).clear();
			driver.findElement(Repositories.f_Mortgage).sendKeys(Details.Scheduling_Insured_mortgage_value);
			
			driver.findElement(Repositories.f_Loss_Address).sendKeys(Details.Scheduling_Loss_Notice_Instruction_value);
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			
			Select dropdown5 = new Select(driver.findElement(Repositories.f_Insurance_Company_drop));
			dropdown5.selectByIndex(1);
			Thread.sleep(1000);
			
			driver.findElement(Repositories.f_Claim_no).sendKeys(Details.Scheduling_Claim_No_value);
			Thread.sleep(1000);
			
			SharedData.getInstance().driver.findElement(Repositories.f_Submit_route_btn).click();
			// driver.findElement(By.xpath(".//input[@class='btn btn-success']")).click();
			System.out.println("insert_claim Completed");
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close(){
		System.out.println("Test Execution completed successfully");
		driver.close();
	}
	
	public void schedule_Appontment(WebDriver driver) throws Exception{
		System.out.println("Fixing appointment");
		driver.findElement(Repositories.f_Schedulded_lnk).click();
		Thread.sleep(2000);
		driver.findElement(Repositories.f_Show_Schedule_Lnk).click();
		//		Fixing Appointment Starts from here
		String hero = Details.Insured_last_name_value;
		driver.getPageSource().contentEquals(hero);
		if(hero==Details.Insured_last_name_value)
		{
//		This is for operation thats why double entry Please do no delete
		driver.findElement(Repositories.f_claim_Schedule_DIV).click();
		driver.findElement(Repositories.f_claim_Schedule_DIV).click();
		WebElement elm =driver.findElement(Repositories.f_Insured_Person_lnk_schedule);
		elm.click();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.switchTo().activeElement();
		driver.findElement(Repositories.f_Appointment_date).click();
		new WebDriverWait(driver, 60).ignoring(NoSuchElementException.class).until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[@id='ui-datepicker-div']"))));

		String selDate = "22-April-2020";
		
		WebElement curYear = driver.findElement(By.xpath(".//span[@class='ui-datepicker-year']"));
		String currYear = curYear.getText();

		String[] date = selDate.split("-");
		while ((!getYear().getText().equals(date[2]))
				| (!getMon().getText().equals(date[1]))) 
		{
			
			if (Integer.parseInt(currYear) < Integer.parseInt(date[2])) 
			{
				driver.findElement(By.xpath(".//span[text()='Next']")).click();
			} 
			else if (Integer.parseInt(date[2]) < Integer.parseInt(currYear))
			{
				driver.findElement(By.xpath(".//span[text()='Previous']")).click();
			} 
		}

		List<WebElement> tableRow = driver.findElements(By.xpath(".//table[@class='ui-datepicker-calendar']/tbody/tr"));

		for (WebElement row : tableRow) 
		{
			for (WebElement col : row.findElements(By.xpath("td/a"))) 
			{
				if (col.getText().equals(date[0])) 
				{
					col.click();
					break;
				}
			}
		}
	}
		String start_time="13:15";
		String end_time="14:15";
		driver.findElement(Repositories.f_Appointment_Start_Time).sendKeys(start_time);
		Actions act1 = new Actions(driver);
		act1.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
//		driver.findElement(Repositories.f_Appointment_End_Time).sendKeys(end_time);
//		act1.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		Select app_type=new Select(driver.findElement(Repositories.f_Appointment_Type));
		app_type.selectByVisibleText("Routed");
		Thread.sleep(1000);
		System.out.println("Adjuster appointment is booked between " +start_time+ " to " + end_time );
		driver.findElement(Repositories.f_Add_btn_last).click();
		}
	
		
	public void today(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		 Date date = new Date();
		 String date1= dateFormat.format(date);
		 System.out.println(date1);
	}
	public void setQuestion()throws Exception{
		Thread.sleep(2000);
		System.out.println("Going to check wether questions are updating in claim question set");
		driver.findElement(Repositories.f_Schedulded_lnk).click();
		Thread.sleep(1000);
		driver.findElement(Repositories.f_Show_Schedule_Lnk).click();
		String hero = Details.Insured_last_name_value;
		driver.getPageSource().contentEquals(hero);
		if(hero==Details.Insured_last_name_value)
		{
		driver.findElement(Repositories.f_claim_Schedule_DIV).click();
		driver.findElement(Repositories.f_claim_Schedule_DIV).click();
		WebElement elm =driver.findElement(Repositories.f_Insured_Person_lnk_schedule);
		elm.click();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.switchTo().activeElement();
		Thread.sleep(1000);
		Select sel = new Select(driver.findElement(Repositories.f_Schedule_type_drop));
		sel.selectByVisibleText("FastTrack");
		Thread.sleep(1000);
		driver.findElement(Repositories.f_Tab_Questions_lnk).click();
		Thread.sleep(100);
//		If we want to press UPDATE button please un comment below code
//		driver.findElement(Repositories.f_Tab_update_Btn).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).build().perform();
		
		
		
	}
	
	}
	public static WebElement getYear(){
		return driver.findElement(By.xpath(".//span[@class='ui-datepicker-year']"));
	}
	
	public static WebElement getMon(){
		return driver.findElement(By.xpath(".//span[@class='ui-datepicker-month']"));
	}
}
