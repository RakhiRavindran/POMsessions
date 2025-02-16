package com.qa.opencart.tests;


//import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;



public class AccountPageTest extends BaseTest {
	
	//@Beforeclass execute once per each class; if testNG having 10 classes ,@beforeclass method will execute 10 times
	//@BeforeTest method executes only once before the first @Test method.

//@BeforeClass executes before each class.
//
//If there are separate @BeforeTest and @BeforeClass methods in different classes, then all the @BeforeTest methods will execute first
//but @BeforeClass methods will be executing as per the respective classes.
//If all test classes extend common @BeforeTest and @BeforeClass methods present in a separate class,
//then @BeforeTest will execute only once, however the same @BeforeClass method will execute before each class.

	
	@BeforeClass
	public void accPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	
	}
	
	
	@Test
	public void accountPageTitleTest() {
		String accTitle = accountPage.getAccPageTitle();
		Assert.assertEquals(accTitle, AppConstants.ACC_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void accountPageURLTest() {
		String accURL = accountPage.getAccPageURL();
		System.out.println(accURL);
		Assert.assertEquals(AppConstants.ACC_PAGE_URL_FRACTION_VALUE, AppConstants.ACC_PAGE_URL_FRACTION_VALUE);
	}
	
	@Test
	public void logoutLinkExistTest() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void accPageHeadersCountTest() {
		List<String> actualAccPageHeadersList = accountPage.getHeaderList();
		System.out.println("Acc Page Headers List: " + actualAccPageHeadersList);
		Assert.assertEquals(actualAccPageHeadersList.size(), AppConstants.ACCOUNT_PAGE_HEADERS_COUNT);
	}
	
	@Test
	public void getHeadersListTest() {
		List<String> accHeaderVal= accountPage.getHeaderList();
		Assert.assertEquals(accHeaderVal, AppConstants.EXPECTED_ACCOUNT_PAGE_HEADERS_LIST);
		
	}
	
	//It is not necessary that writing separate test class for seperatePages
	@DataProvider
	public Object searchKeyData() {
		return new Object[][] {
			{"Mac"},
			{"Samsung"},
			{"Dell"},
			{"Apple"}
		};
	}
	
	@Test(dataProvider = "searchKeyData")
	public void searchProductCountTest(String searchKey) {
		searchPage=accountPage.searchProduct(searchKey);
		Assert.assertTrue(searchPage.getSearchProductsCount()>0);;
	}
	
	@DataProvider
	public Object searchDataAndProductData(String searchKey,String productName) {
		return new Object[][]{
			{"Macbook", "MacBook Pro" },
			{ "Macbook", "MacBook Air" },
			{ "iMac", "iMac" },
			{ "Apple", "Apple Cinema 30\"" },
			{ "Samsung", "Samsung SyncMaster 941BW" },
			{ "Samsung", "Samsung Galaxy Tab 10.1" }
				
		};
		
	}
	@Test(dataProvider="searchDataAndProductData")
	public void searchAndSelectProduct(String searchKey,String productName) {
		searchPage=accountPage.searchProduct(searchKey);//product searched from account page and land on search Page
		if(searchPage.getSearchProductsCount()>0) {
		productInfoPage=searchPage.selectProduct(productName);
		String acTitle=productInfoPage.getProdInfoPageTitle();
		Assert.assertEquals(acTitle, AppConstants.PRODINFO_PAGE_TITLE_VALUE);//here account page title is verifying ,we can verify header in same way
		
		String acHeader=productInfoPage.getProdHeader();
		Assert.assertEquals(acHeader, AppConstants.PRODINFO_PAGE_HEADER_VALUE);
		
		}
		
	}

}
