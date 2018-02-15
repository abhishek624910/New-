package com.basic.para;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Para2 
{
	public WebDriver driver;
	
	@Parameters({"nodeurl","browser","appurl"})
	@BeforeMethod
	public void preCondition(String nodeurl, String browser, String appurl)throws MalformedURLException 
	{
		URL url = new URL(nodeurl);
		
       DesiredCapabilities dc= new DesiredCapabilities();
       dc.setBrowserName(browser);
	   driver = new RemoteWebDriver(url, dc);
	   driver.get(appurl);
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}	
	
	@Test
	public void m1()
	{
		if(driver.getTitle().equalsIgnoreCase("Actitime"))
		{
			Reporter.log("Hello",true);
		}
		else
		{
			Reporter.log("Hiii",true);
		}
	}

	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}

}
