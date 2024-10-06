package com.qc.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.qc.utils.Testutil;

public class BaseIntegration {
	
	WebDriver driver;
	Testutil test = new Testutil();
	Properties prop ;
	WebElement email, pass, sigin, logout;
	
	@BeforeSuite
	public void doSetup() throws IOException{
		
		
		prop = test.readProp();
		if (prop.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
			
		}else if(prop.getProperty("browser").equals("edge")) {
			driver = new EdgeDriver();
			
		}else {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("siteUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			
		
		
		
		
	}
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	

}
