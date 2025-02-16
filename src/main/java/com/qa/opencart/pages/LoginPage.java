package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//1. private locators
	By userName= By.id("input-email");
	By password=By.name("password");
	By loginBtn=By.xpath("//input[@value='Login']");
	By forgotPassword=By.linkText("Forgotten Password");
	
	By register =By.linkText("Register");
	
	//2. public constructor
	public LoginPage(WebDriver driver) {//will call when obj. is created in baseTest- and will pass webdriver value and maintain the session id
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		
	}
	
	//3.Methods or actions
	public String getLoginPageTitle() {
		String acTitle=eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIMEOUT,AppConstants.LOGIN_PAGE_TITLE_VALUE);
		System.out.println(acTitle);
		return acTitle;		
	}
		
	public String getLoginPageURL() {
		String url=eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIMEOUT, AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE);
		System.out.println(url);
		return url;		
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.waitForElementVisible(forgotPassword, AppConstants.DEFAULT_MEDIUM_TIMEOUT).isDisplayed();
	}
	
	public AccountPage doLogin(String un,String pwd) {
		eleUtil.waitForElementVisible(userName,AppConstants.DEFAULT_MEDIUM_TIMEOUT).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		
		return new AccountPage(driver);//here we are creating a obj. of a/c page with parameter so we have to write the constructor in same structure
		
	}
	
	public RegisterPage navigateToRegPage() {
		eleUtil.doClick(register);
		return new RegisterPage(driver);
	}
		
	
	
	
	
	

}
