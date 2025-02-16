package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	By logoutLink=By.linkText("Logout");
	By acPageHeader=By.xpath("//div[@id='content']//h2");
	By searchBox=By.xpath("//div[@id='search']//input[@name='search']");
	By searchBtn=By.cssSelector(".btn.btn-default.btn-lg");
	

	//As we returning the obj. of login page with driver parameter ,we have to create constructor with same parameter structure
	public AccountPage(WebDriver driver) {//this will call when obj is created in loginpage's do login test. And maintain the session id 
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
	
	public List<String> getHeaderList() {
		List<WebElement> accHeadersList= eleUtil.waitForElementsVisible(acPageHeader, AppConstants.DEFAULT_SHORT_TIMEOUT);
		List<String> headerValList= new ArrayList<String>();
		for (WebElement e : accHeadersList) {
			headerValList.add(e.getText());
			
		}
		return headerValList;
	}

	public boolean isSearchExist() {
		return eleUtil.waitForElementPresence(searchBox, AppConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();
	}
	
	public SearchPage searchProduct(String searchKey) {
		
		if(isSearchExist()) {
			eleUtil.doSendKeys(searchBox, searchKey);
			eleUtil.doClick(searchBtn);
			return new SearchPage(driver);
		}
		else {
			System.out.println("search is not exists");
			return null;
		}
		
		
	}
	
	
	

}

