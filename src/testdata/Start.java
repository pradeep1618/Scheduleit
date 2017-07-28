package testdata;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import admin.Login;
import admin.SharedData;

public class Start {
	public WebDriver driver = null;
	public void browser(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		SharedData.getInstance().setDriver(driver);
		driver.get("https://app.pradeep.test.scheduleit.io");
		System.out.println("Test Case by Mr Pradeep");
		Login.getlogin(driver);
		System.out.println("Adjuster Module Execution Started");
	}

}
