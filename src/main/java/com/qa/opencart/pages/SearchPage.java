package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class SearchPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By imgs= By.xpath("//div[contains(@class,'product-layout')]");
	
	

	public SearchPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	
	}
	public int getSearchProductsCount() {
		List<WebElement> searchProductCount=eleUtil.waitForElementsVisible(imgs, AppConstants.DEFAULT_SHORT_TIMEOUT);
		return searchProductCount.size();
	}
	
	public ProductInfoPage selectProduct(String productName) {
		By prodLocator=By.linkText(productName);
		eleUtil.waitForElementVisible(prodLocator, AppConstants.DEFAULT_LONG_TIMEOUT).click();
		return new ProductInfoPage(driver);
		
	}

	
	
	

}
