package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest{	
	
	@BeforeClass
	public void productInfoPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	
	@DataProvider
	public Object[][] getProductImagesPageTitleTestData() {
		return new Object[][] {
			{"Macbook", "MacBook Pro", "MacBook Pro"},
			{"iMac", "iMac", "iMac"},
			{"Apple", "Apple Cinema 30\"", "Apple Cinema 30\""},
			{"Samsung", "Samsung SyncMaster 941BW", "Samsung SyncMaster 941BW"},
		};
	}
	@Test(dataProvider="getProductImagesPageTitleTestData")
	public void prodInfoPageTitleTest(String searchKey,String prodName,String pTitle) {
		accountPage.searchProduct(searchKey);
		searchPage.selectProduct(prodName);
		String actTitle=productInfoPage.getProdInfoPageTitle();
		Assert.assertEquals(actTitle, pTitle);
	}
	
	@DataProvider
	public Object[][] getProductImagesTestData() {
		return new Object[][] {
			{"Macbook", "MacBook Pro", 4},
			{"iMac", "iMac", "iMac"},
			{"Apple", "Apple Cinema 30\"", 2},
			{"Samsung", "Samsung SyncMaster 941BW", 3},
		};
	}
	@Test(dataProvider="getProductImagesTestData")
	public void prodInfoPageTitleTest(String searchKey,String prodName,int imgCount) {
		accountPage.searchProduct(searchKey);
		searchPage.selectProduct(prodName);
		int acCount=productInfoPage.imgCount();
		Assert.assertEquals(acCount, imgCount);
	}
	
	

}
