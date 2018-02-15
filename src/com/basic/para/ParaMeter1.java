package com.basic.para;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParaMeter1 
{
	public WebDriver driver;
	@Test
	public void useMe() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("abhishek");
		driver.findElement(By.id("pass")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		Thread.sleep(5000);
		driver.close();
	}

}
