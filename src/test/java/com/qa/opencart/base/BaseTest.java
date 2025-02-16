package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchPage;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	
	protected Properties prop;
	
	protected LoginPage loginPage;//protected variable can access from child class with in the same package
								//and child class in outside the package
	protected AccountPage accountPage;
	protected SearchPage searchPage;
	protected ProductInfoPage productInfoPage;
	protected RegisterPage registerPage;
	
	protected SoftAssert softAssert ;
	
	
	@BeforeTest
	public void setup() {
		df= new DriverFactory();//To create driver factory obj. and then to access method in it
		prop=df.initProp();//to read the property file via driver factory
		//driver=df.initDriver(prop.getProperty("browser"));//To initialize browser from property file[direct use "chrome"]
		driver=df.initDriver(prop);//--->if supply prop here, all the properties should be available in DF,where we can use it
		loginPage=new LoginPage(driver);//To create obj of login page and then access all method in it
		                                //along with call constructor and maintain the session ID by avoiding unnecessary extends/inheritance
		softAssert= new SoftAssert();
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
