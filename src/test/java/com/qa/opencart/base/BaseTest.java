package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	
	protected Properties prop;
	
	protected LoginPage loginPage;//protected variable can access from child class with in the same package and outside the package
	protected AccountPage accountPage;
	
	
	@BeforeTest
	public void setup() {
		df= new DriverFactory();//To create driver factory obj. and then to access method in it
		prop=df.initProp();//to read the property file via driver factory
		driver=df.initDriver(prop.getProperty("browser"));//To initialize browser from property file[direct use "chrome"]
		loginPage=new LoginPage(driver);//To create obj of login page and then access all method in it
		                                //along with call constructor and maintain the session ID by avoiding unnecessary extends/inheritance
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
