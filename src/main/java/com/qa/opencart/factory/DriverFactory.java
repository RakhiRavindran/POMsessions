package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver initDriver(String browserName) {
		if(browserName.trim().equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browserName.trim().equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (browserName.trim().equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		return driver;
		
	}
	 
	public Properties initProp() {
		prop=new Properties();
		try {//. path=> whatever the current project repository  and follow the path upto src folder
			FileInputStream ip=new FileInputStream(".\\src\\test\\resources\\configurationfiles\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
