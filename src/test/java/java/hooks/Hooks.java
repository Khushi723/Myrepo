package java.hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;
import java.driversetup.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.utils.ConfigReader;

public class Hooks {
	
	//public WebDriver driver;
	private ConfigReader configreader;
	Properties prop;
	
	@Before(order = 0)
    public void getConfigProperty() 
	{
		configreader = new ConfigReader();
		prop = configreader.readProperties();	
	}
	
	@Before(order = 1)
    public void launchBrowser() 
	{
		DriverSetup.initialization(prop.getProperty("browser"));	
	}
	
	@Before(order = 2)
	public void goToURL()
	{
		DriverSetup.driver.navigate().to(prop.getProperty("url"));
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario)
	{
		if (scenario.isFailed())
		{
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			String screenshotBase64 = ((TakesScreenshot)DriverSetup.driver).getScreenshotAs(OutputType.BASE64);
			scenario.attach(screenshotBase64, "image/png", screenshotName);
		}
	}
	
/*	@After(order = 0)
    public void quitBrowser() 
	{
		driver.quit();
	}	*/
}
