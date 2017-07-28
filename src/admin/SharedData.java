package admin;

import org.openqa.selenium.WebDriver;

public class SharedData {

	private static SharedData sharedData = null;

	public WebDriver driver;

	public static SharedData getInstance() {
		if (sharedData == null) {
			sharedData = new SharedData();
		}
		return sharedData;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
