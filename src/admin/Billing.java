package admin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Billing {
//	This test case was prepared by Mr Pradeep
	public static WebDriver driver;
	static Details ds;
		
	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		SharedData.getInstance().setDriver(driver);
		System.out.println("app.pradeep.test.scheduleit.io");
		driver.get("https://app.pradeep.test.scheduleit.io");
		Login.getlogin(driver);
		System.out.println("Logged in as Admin");
		Billing bill=new Billing();
		bill.billing();
	}
	public void billing()
	{
			driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[contains(.,'Billing Issue Tracker')]")).click();
		    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		   
		    WebElement table = driver.findElement(By.xpath("//table[@id='data-table']"));
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
		  	  boolean element = driver.findElement(By.xpath
		    			("//td[contains(.,'Schedulewithdebbie@gmail.com')]//following::a[contains(.,'Edit Submission')][1]")).getSize()!=null;
		  	  	if(element==true)
		  	  	{
		  	  		driver.findElement(By.xpath
	    			("//td[contains(.,'sarvjeets@smartdatainc.net')]//following::a[contains(.,'Edit Submission')][1]")).click();
		  	  			break;
		  	  	}
		     }
//		    driver.close();
		    driver.switchTo().window(tabs2.get(0));
//		    driver.findElement(By.xpath
//		    			("//td[contains(.,'sarvjeets@smartdatainc.net')]//following::a[contains(.,'Edit Submission')][1]")).click();
		    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		    System.out.println("tab 1 ");
		    driver.close();
//		    driver.switchTo().window(tabs2.get(0));
		    System.out.println("Tab 2 ");
		    ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs3.get(1));
		    System.out.println("Tab 3 ");
		    System.out.println("Searching Button");
		    driver.findElement(By.xpath("//button[@id='input_2']")).click();
		    System.out.println("Submit Button Clicked");
		    driver.close();
		    driver.switchTo().window(tabs3.get(0));
		    driver.close();
//		    driver.findElement(By.id("input_2")).click();
	}

}
