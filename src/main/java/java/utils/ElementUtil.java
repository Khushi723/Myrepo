package java.utils;

import org.openqa.selenium.WebDriver;

import java.driversetup.DriverSetup;

public class ElementUtil {
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
}
