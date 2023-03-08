package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	By logoutLink=By.linkText("Logout");
	By acPageHeader=By.xpath("//div[@id='content']//h2");
	

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil=new ElementUtil(driver);
	}
	
	public String getAccPageTitle() {
		String acPageTitle=eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIMEOUT, AppConstants.ACC_PAGE_TITLE_VALUE);
		System.out.println(acPageTitle);
		return acPageTitle;
	}
	
	public String getAccPageURL() {
		String acPageURL=eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIMEOUT, AppConstants.ACC_PAGE_URL_FRACTION_VALUE);
		System.out.println(acPageURL);
		return acPageURL;
	}
	
	public boolean logOutLinkExist() {
		
		return eleUtil.waitForElementVisible(logoutLink, AppConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();
	}
	
	

}
