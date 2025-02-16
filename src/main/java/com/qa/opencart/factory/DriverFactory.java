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
	
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	public static String highlight;
	
	
	public WebDriver initDriver(Properties prop) {//browser name is passing then it should be an string parameter 
		
		optionsManager=new OptionsManager(prop);
		highlight= prop.getProperty("highlight");
		
		String browserName =prop.getProperty("browser").toLowerCase().trim();
		if(browserName.equalsIgnoreCase("chrome")) {
			//driver=new ChromeDriver();
			driver=new ChromeDriver(optionsManager.getChromeOptions());//reading config file and passing headless/incognito
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			//driver=new FirefoxDriver();
			driver=new FirefoxDriver(optionsManager.getFirefoxOptions());
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			//driver=new EdgeDriver();
			driver=new EdgeDriver(optionsManager.getEdgeOptions());
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		return driver;
		
	}
	
	/**
	 * this method is initializing the driver on the basis of given browser name
	 * 
	 * @param browserName
	 * @return this returns the driver
	 */
	 
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
