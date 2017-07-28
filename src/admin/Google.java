package admin;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Google {
//This test case was prepared by Mr Pradeep
public static WebDriver driver;
static Details ds;
Boolean deployment=false;
	public static void main(String[] args) throws Exception
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		SharedData.getInstance().setDriver(driver);
		driver.get("https://app.sarvjeet.test.scheduleit.io");
		Login.getlogin(driver);
		System.out.println("Google Sync Module Execution Started");
		Google sync = new Google();
		sync.create_Adjuster();
		sync.googlesinc();
		sync.googlesincs();
		sync.delete_adjuster();
		sync.close();
	}
	
public void googlesinc()throws Exception{
	Thread.sleep(1000);
	ds = new Details();
	Thread.sleep(2000);
	System.out.println("Editing a Adjuster in Admin");
	driver.findElement(By.xpath(ds.click_manage_user)).click();
	System.out.println("Manage User link operated");
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	System.out.println("Adjusters Link Clicked");
	Thread.sleep(2000);
	driver.findElement(By.xpath(ds.a_click_adjuster)).click();
	Thread.sleep(2000);
//here we need some loop
	Select redord = new Select(driver.findElement(By.xpath(".//select[@aria-controls='list-adjusters']")));
	redord.selectByVisibleText("100");
	Thread.sleep(1000);
	boolean status = driver.findElement(By.xpath("//td[contains(.,'"+Details.a_email_value+"')]//following::a[@title='Active'][1]")).isEnabled();
	if (status==true) {
		Thread.sleep(2000);
		System.out.println("Already Active");
		Thread.sleep(2000);
	}
	else
	{
		System.out.println("Account Sync is inactive");
		driver.findElement(By.xpath("//td[contains(.,'"+Details.a_email_value+"')]//following::a[@title='Active'][1]")).click();
		Thread.sleep(500);
		System.out.println("Google sync Activated");
	}
	Thread.sleep(1000);
	driver.findElement(By.xpath("//td[contains(.,'"+Details.a_email_value+"')]//following::a[contains(.,'Log in as')][1]")).click();
	Thread.sleep(1000);
	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	if(driver.findElement(By.xpath(".//input[@id='TermCheck']")).getSize()!=null){
		System.out.println("Signing as a adjuster");
		Thread.sleep(500);
		driver.findElement(By.xpath(".//input[@id='TermCheck']")).click();
		System.out.println("Accepted all terms & Conditions");		
		driver.findElement(By.xpath(".//input[@id='TermSignature']")).sendKeys("I accept all terms and coditions as per your policy");
		System.out.println("Signed on digital document");
		Thread.sleep(200);
		driver.findElement(By.xpath(".//input[@id='acceptTerm']")).click();
		System.out.println("Accepted all terms");
		driver.navigate().refresh();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
//		driver.findElement(By.xpath(".//a[contains(.,'Show Schedule')]")).click();
	}
	else {
		System.out.println("Page is not loaded perfectly");
	}
		/*Thread.sleep(5000);
		if(driver.findElement(By.tagName("iframe")).isEnabled()){
			System.out.println("Pop up Avaliable");
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//div[@class='appcues-actions-left']//small")).click();
			System.out.println("Skip all pop ups");
		}
		else
		{
			System.out.println("No Pop ups");
		}*/
		Thread.sleep(5000);
	}
public void delete_adjuster()throws Exception{
	ds = new Details();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath(ds.click_myaccount)).click();
	Thread.sleep(2000);
	ds.findx(ds.click_return_to_admin_role).click();
	System.out.println("Creating a new Adjuster in Admin");
	driver.findElement(By.xpath(ds.click_manage_user)).click();
	System.out.println("Manage User link operated");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	System.out.println("Adjusters Link Clicked");
	driver.findElement(By.xpath(ds.a_click_adjuster)).click();
	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	System.out.println("Deleting Adjuster to save space");
	Thread.sleep(2000);
	Select redord = new Select(driver.findElement(By.xpath(".//select[@aria-controls='list-adjusters']")));
	redord.selectByVisibleText("100");
	driver.findElement(By.xpath(".//td[contains(.,'"+Details.a_email_value+"')]//following::a[@title='Delete User'][1]")).click();
	driver.switchTo().alert();
	driver.switchTo().alert().accept();
	System.out.println("Adjuster deleted successfully");
}

public void googlesincs()throws Exception{
	Thread.sleep(1000);
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath(".//a[contains(.,'Sync')]")).click();
	System.out.println("Sync Link activated");
	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	driver.findElement(By.id("Email")).sendKeys("risklogictest3@gmail.com");
	System.out.println("Email Address Value Passed");
	driver.findElement(By.id("next")).click();
	Thread.sleep(800);
	driver.findElement(By.id("Passwd")).sendKeys("Demo@123");
	System.out.println("Password Value Passed");
	driver.findElement(By.id("signIn")).click();
	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	Thread.sleep(2000);
	do{
	Thread.sleep(3000);
	driver.findElement(By.xpath(".//button[@id='submit_approve_access']")).click();
	System.out.println("Approval Button Operated for Giving Access");
	break;
	}
	while(driver.findElement(By.xpath(".//button[@id='submit_approve_access']")).isDisplayed());
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	Robot r = new Robot();                          
	r.keyPress(KeyEvent.VK_CONTROL); 
	r.keyPress(KeyEvent.VK_T); 
	r.keyRelease(KeyEvent.VK_CONTROL); 
	r.keyRelease(KeyEvent.VK_T);
	driver.navigate().to("http://www.gmail.com");
	Thread.sleep(3000);
	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	boolean inbox=driver.findElement(By.xpath(".//a[contains(.,'Inbox')]")).getSize()!=null;
//	boolean mail =driver.findElement(By.id("Email")).getSize()!=null;
	if(inbox=true)
	{
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//a[@title='Google apps']")).click();
		System.out.println("Entered in to google account ");
		driver.findElement(By.xpath(".//a[@id='gb24']//following::span[contains(.,'Calendar')]")).click();
		System.out.println("Entered in to Google Calander");
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_CONTROL); 
		r.keyPress(KeyEvent.VK_W); 
		r.keyRelease(KeyEvent.VK_CONTROL); 
		r.keyRelease(KeyEvent.VK_W);
	}
	else
	{
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.findElement(By.id("Email")).sendKeys("risklogictest3@gmail.com");
	System.out.println("Email Address Value Passed");
	driver.findElement(By.id("next")).click();
	Thread.sleep(800);
	driver.findElement(By.id("Passwd")).sendKeys("Demo@123");
	System.out.println("Password Value Passed");
	driver.findElement(By.id("signIn")).click();
	}	
	Thread.sleep(2000);
	driver.switchTo().activeElement();
	r.keyPress(KeyEvent.VK_CONTROL); 
	r.keyPress(KeyEvent.VK_W); 
	r.keyRelease(KeyEvent.VK_CONTROL); 
	r.keyRelease(KeyEvent.VK_W);
	Thread.sleep(2000);
	if(driver.findElement(By.tagName("iframe")).isDisplayed()){
		System.out.println("Pop up Avaliable");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class='appcues-actions-left']//small")).click();
		System.out.println("Skip all pop ups");
	}
	else{
		System.out.println("No Pop ups");
	}
}


public void create_Adjuster()throws Exception{
	ds = new Details();
	Thread.sleep(2000);
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
//	String country="Canada";
//	driver.findElement(By.xpath("//select[@id='UserCountry']")).click();
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
//	
	Thread.sleep(1000);*/
	System.out.println("Selecting State From US");
	Select stat_sel =new Select(driver.findElement(By.xpath(ds.a_state)));
	stat_sel.selectByVisibleText("New York");
	System.out.println("Adjuster is from ____state");
	driver.findElement(By.xpath(ds.a_postal_code)).sendKeys(ds.a_postal_code_value);
	System.out.println("Adjuster city postal code "+ds.a_postal_code_value);
	Thread.sleep(2000);
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
//	Please use below code if Deployment address and adjuster address have a country field.	
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
		Thread.sleep(2000);
	}
	driver.findElement(By.xpath(ds.a_team_info)).click();
	System.out.println("Team Information Done");
	Thread.sleep(2000);
	Select sche_sell = new Select(driver.findElement(By.xpath(ds.a_choose_schedule)));
	sche_sell.selectByVisibleText(ds.a_choose_schedule_value);
	System.out.println("We have selected "+ds.a_choose_schedule_value+" as our team");
	Thread.sleep(2000);
	driver.findElement(By.xpath(ds.a_account_activation)).click();
	Thread.sleep(2000);
	Select acc_acti = new Select(driver.findElement(By.xpath(ds.a_input_send_sms)));
	acc_acti.selectByVisibleText(ds.a_input_sms);
	System.out.println("We choose to send information through " +ds.a_input_sms);
	Thread.sleep(2000);
	driver.findElement(By.xpath(ds.a_submit_button)).click();
	System.out.println("Just Submited information for creating a adjuster");
	System.out.println("Completed Adjuster Creation");
	}

public void close(){
	driver.manage().deleteAllCookies();
	System.out.println("Google Sync and Delete of Adjuster process completed");
	System.out.println("Success");
	driver.close();
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
