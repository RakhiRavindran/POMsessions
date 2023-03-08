package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;



public class LoginPageTest extends BaseTest {
	
	
	@Test
	public void loginPageTitleTest() {
		String acTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(acTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void loginPageURLTest() {
		String lpURL=loginPage.getLoginPageURL();
		Assert.assertTrue(lpURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}
	
	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test(priority=1)
	public void doLoginTest() {
		accountPage= loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());//credentials can pass from config.property[Direct use ("username","password")
		
		Assert.assertTrue(accountPage.logOutLinkExist());
	}

}
