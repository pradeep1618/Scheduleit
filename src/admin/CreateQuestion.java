package admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//This test was prepared by Mr Pradeep
public class CreateQuestion {
	public static WebDriver driver;
	static Details ds;
	//Please change boolean value of dependent TRUE / FALSE 
	boolean dependent =true;
	int noRadioOptions =3;
	int noOfQuestions=1;
	String claimType="Foreclosure";
	public static void main(String[] args) throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		SharedData.getInstance().setDriver(driver);
		System.out.println("app.pradeep.test.scheduleit.io");
		driver.get("https://app.pradeep.test.scheduleit.io");
		Login.getlogin(driver);
		System.out.println("Logged in as Admin");
		CreateQuestion question = new CreateQuestion();
		question.ManageQuestion(driver);
		question.setQuestions(driver);
		question.deleteQuestions(driver);
		driver.manage().deleteAllCookies();
		driver.close();
		
	}
	public void ManageQuestion(WebDriver driver) throws Exception
{
		System.out.println("Manage Questions section started");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.findElement(Repositories.q_Manage_Claim_Questions).click();
		System.out.println("Clicked on Manage Claim Questions link");
		for(int j=0; j<=noOfQuestions; j++)
	{ 
		int k =j+1;
		
		System.out.println("Creating set no "+k +" & it's Questions");
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.findElement(Repositories.q_Manage_questions).click();
		System.out.println("Clicked in manage questions link");
		driver.findElement(Repositories.q_Add_a_question).click();
		System.out.println("Add a question button clicked");
		if(dependent==true)
		{
		System.out.println("we are creating a dependent question. Please change dependent value if, dependent question is not required");
		driver.findElement(Repositories.q_drop_down).click();
		String type=driver.findElement(Repositories.q_drop_down).getAttribute("value");
		System.out.println("Index of question type is "+type);
//		String type =driver.findElement(By.xpath(".//input[@id='ClaimQuestionClaimQuestionTypeId6']")).getAttribute("");
		System.out.println("Radio type of question selected");
		driver.findElement(Repositories.q_Next_Button).click();
		System.out.println("Next button clicked");
		driver.findElement(Repositories.q_schedulers_question).sendKeys(Details.q_schedulers_question);
		System.out.println("Scheduler question is" +Details.q_schedulers_question);
		driver.findElement(Repositories.q_adjuster_question).sendKeys(Details.q_adjuster_question);
		System.out.println("Adjuster question as " +Details.q_adjuster_question);
		driver.findElement(Repositories.q_insured_question).sendKeys(Details.q_insured_question);
		System.out.println("Insured question is " +Details.q_insured_question);
		driver.findElement(Repositories.q_google_question).sendKeys(Details.q_google_question);
		System.out.println("Google Question as" +Details.q_google_question);
		driver.findElement(Repositories.q_radio_option_type).sendKeys("Yes");
		System.out.println("First oprion is Yes");
		driver.findElement(Repositories.q_radio_option_type1).sendKeys("No");
		System.out.println("Second option is No");
		for(int i=3;i<=noRadioOptions;i++)
		{
			if(i<=noRadioOptions){
				driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
				driver.findElement(Repositories.q_Add_Another_Option).click();
				Thread.sleep(1000);
			}
		if(i<=noRadioOptions)
		{
			//it is a dynamic element 
			driver.findElement
				(By.xpath("//div[@id='question-option-box-0']//following::input[@name='data[ClaimQuestionOption]["+i+"][value]']"))
					.sendKeys(i + " " + Details.uuid);
			System.out.println("Option no " +i+ " is " +i+ " " +Details.uuid);
		}
		}
		driver.findElement(Repositories.q_Submit_Button).click();
		System.out.println("Submit Button Clicked");
		System.out.println("Creating Simple Question");
		String type1=driver.findElement(Repositories.q_type_of_question_text).getText();
		driver.findElement(Repositories.q_type_of_question_option).click();
		System.out.println("Clicked in" + type1);
		driver.findElement(Repositories.q_Next_Button).click();
		driver.findElement(Repositories.q_schedulers_question).sendKeys(Details.q_schedulers_question2);
		System.out.println("Scheduler question is" +Details.q_schedulers_question2);
		driver.findElement(Repositories.q_adjuster_question).sendKeys(Details.q_adjuster_question2);
		System.out.println("Adjuster question as " +Details.q_adjuster_question2);
		driver.findElement(Repositories.q_insured_question).sendKeys(Details.q_insured_question2);
		System.out.println("Insured question is " +Details.q_insured_question2);
		driver.findElement(Repositories.q_google_question).sendKeys(Details.q_google_question2);
		System.out.println("Google Question as" +Details.q_google_question2);
		driver.findElement(Repositories.q_Submit_Button).click();
		System.out.println("Submit Button Clicked");
		}
		
		else
		{
			System.out.println("Creating Simple Question");
			String type1=driver.findElement(Repositories.q_type_of_question_option).getText();
			driver.findElement(Repositories.q_type_of_question_text).click();
			System.out.println("Clicked in" + type1);
			driver.findElement(Repositories.q_Next_Button).click();
			driver.findElement(Repositories.q_schedulers_question).sendKeys(Details.q_schedulers_question);
			System.out.println("Scheduler question is" +Details.q_schedulers_question);
			driver.findElement(Repositories.q_adjuster_question).sendKeys(Details.q_adjuster_question2);
			System.out.println("Adjuster question as " +Details.q_adjuster_question2);
			driver.findElement(Repositories.q_insured_question).sendKeys(Details.q_insured_question2);
			System.out.println("Insured question is " +Details.q_insured_question2);
			driver.findElement(Repositories.q_google_question).sendKeys(Details.q_google_question2);
			System.out.println("Google Question as" +Details.q_google_question2);
			driver.findElement(Repositories.q_Submit_Button).click();
			System.out.println("Submit Button Clicked");
					
		}
	}
	
}
	public void setQuestions(WebDriver driver) throws Exception{
//		driver.findElement(By.xpath(".//li[contains(.,'Manage Claim Questions')]")).click();
		Thread.sleep(1000);
//		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.findElement(Repositories.q_Manage_Set_Questions).click();
		System.out.println("Clicked on MANAGE QUESTIONS SETS");
//		dynamic Element 
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//td[contains(.,'"+claimType+"')]//following::a[contains(.,'Manage')][1]")).click();
		System.out.println("Clicked on "+claimType+" to manage questions");
		Thread.sleep(2000);
		driver.findElement(Repositories.q_Add_set_question_button).click();
		Thread.sleep(1000);
		System.out.println("Clicked on Add questions to set");
		Thread.sleep(2000);
		Select sel1 = new Select(driver.findElement(Repositories.q_Set_Question_dropDown));
		sel1.selectByVisibleText(Details.q_schedulers_question);
		System.out.println("Selected " + Details.q_schedulers_question);
//		driver.findElement(By.xpath(".//select[@id='ClaimTypesToClaimQuestionClaimQuestionId']"));
		Thread.sleep(1000);
		if(dependent){
		driver.findElement(Repositories.q_Has_Child_Question).click();
		driver.findElement(Repositories.q_question_order).sendKeys("1");
		driver.findElement(Repositories.q_Submit_Button).click();
		}
		else{
		driver.findElement(Repositories.q_question_order).sendKeys("1");
		Thread.sleep(1000);
		driver.findElement(Repositories.q_Submit_Button).click();
		System.out.println("Setting Question completed");
		System.out.println("SUCCESS");
		}
		if(dependent)
		{
			System.out.println("Creating a child question for " + Details.q_schedulers_question);
			Thread.sleep(2000);
			driver.findElement(Repositories.q_Add_set_question_button).click();
			Thread.sleep(1000);
			System.out.println("Clicked on Add questions to set");
			Select sel2 = new Select(driver.findElement(Repositories.q_Set_Question_dropDown));
			sel2.selectByVisibleText(Details.q_schedulers_question2);
			driver.findElement(Repositories.q_parent_question_check).click();
			Thread.sleep(1000);
			driver.findElement(Repositories.q_Has_Child_Question).click();
			System.out.println("Clicked on Child question check box");
			driver.findElement(Repositories.q_Set_Question_dropDown);
			driver.findElement(Repositories.q_question_order).sendKeys("2");
			Thread.sleep(1000);
			driver.findElement(Repositories.q_Submit_Button).click();
			Thread.sleep(3000);
//			Boolean iselementpresent = driver.findElements(Repositories.q_Manage_question_img).size()!= 0;
//			if(iselementpresent==false)	{
//			do{
//					driver.findElement(By.xpath(".//a[contains(.,'Next')]")).click();
//					Boolean iselementpresent1 = driver.findElements(Repositories.q_Manage_question_img).size()!= 0;
//					if(iselementpresent1==true){
//						break;
//					}
//			}
//			while(iselementpresent==false);	
//			}
			Select sel3 = new Select(driver.findElement(Repositories.q_noOf_questions_per_Page));
			sel3.selectByValue("100");
			Thread.sleep(1000);
			//Dynamic Element 
			driver.findElement(Repositories.q_Manage_question_img).click();
			Thread.sleep(1000);
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver.findElement(Repositories.q_Add_Dependency_button).click();
			driver.findElement(Repositories.q_dependency_Ans_Type).sendKeys("Yes");
			Thread.sleep(1000);
			Select sel5 = new Select (driver.findElement(Repositories.q_dependency_to_which_ques));
			sel5.selectByIndex(1);
			Thread.sleep(1000);
			driver.findElement(Repositories.q_Submit_Button).click();
			Thread.sleep(2000);                                                                               
			driver.findElement(Repositories.q_Go_back_to_manage_set_questions).click();
			System.out.println("Setting Questions is completed");
			System.out.println("Success");
		}
//		1-04-1970
		/*else
		{
			driver.findElement(By.xpath(".//a[contains(.,'Add questions to set')]")).click();
			Thread.sleep(1000);
			System.out.println("Clicked on Add questions to set");
			Select sel3 = new Select(driver.findElement(By.xpath(".//select[@id='ClaimTypesToClaimQuestionClaimQuestionId']")));
			sel3.selectByVisibleText(Details.q_schedulers_question);
//			sel1.selectByVisibleText(Details.q_schedulers_question);
			driver.findElement(By.xpath(".//select[@id='ClaimTypesToClaimQuestionClaimQuestionId']"));
			driver.findElement(By.xpath(".//input[@id='ClaimTypesToClaimQuestionOrder']")).sendKeys("1");
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//button[contains(.,'Submit')]")).click();
		}*/
		
	}
	public void deleteQuestions(WebDriver driver)throws Exception
	{
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.findElement(Repositories.q_Manage_Set_Questions).click();
		System.out.println("Clicked on MANAGE QUESTIONS SETS");
//		dynamic Element 
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//td[contains(.,'"+claimType+"')]//following::a[contains(.,'Manage')][1]")).click();
		System.out.println("Clicked on "+claimType+" to manage questions");
		Thread.sleep(2000);
		System.out.println("Deleting question from Claim Type");
		
		boolean sizeofele=driver.findElement(By.xpath(".//td[contains(.,'"+Details.q_schedulers_question+"')]//following::a[@title='Remove question from set'][1]")).getSize()!=null;
		
		do
		{
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//td[contains(.,'"+Details.q_schedulers_question+"')]//following::a[@title='Remove question from set'][1]")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform(); 
		if(dependent==true){
			Thread.sleep(2000);
			System.out.println("Deleting dependent question from claim type");
			driver.findElement(By.xpath(".//td[contains(.,'"+Details.q_schedulers_question2+"')]//following::a[@title='Remove question from set'][1]")).click();
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			Thread.sleep(2000);
			act.sendKeys(Keys.ENTER).build().perform();
			
		}
			
	}
		while (sizeofele==false);
	}
}
