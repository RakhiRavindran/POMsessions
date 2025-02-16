package com.qa.opencart.pages;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By prodHeader= By.cssSelector("div.btn-group+h1");
	//private By prodPrice = By .cssSelector("li h2");
	private By img =By.cssSelector("");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");

	private By quantity = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");
	private By cartSuccessMessg = By.cssSelector("div.alert.alert-success");
	private By cart = By.id("cart");
	
	
	private Map<String,String>productInfoMap;
	//private HashMap productInfoMap;
	//private LinkedHashMap productInfoMap;

	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	public String  getProdInfoPageTitle() {
		String actTitle=eleUtil.waitForTitleContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT,AppConstants.PRODINFO_PAGE_TITLE_VALUE );
		
		return actTitle;
		
	}
	// to verify product header values
	public String getProdHeader() {
		return eleUtil.doElementGetText(prodHeader);
	}
	/*
	public int getProdPrice() {
		String priceText= eleUtil.doElementGetText(prodPrice);
		int price = Integer.parseInt(priceText.split("$")[1]);
		return price;
	}*/
	
	public int imgCount() {
		return eleUtil.waitForElementsVisible(img, AppConstants.DEFAULT_LONG_TIMEOUT).size();
	}
	
	public Map<String, String> getProductInfo() {
		// productInfoMap = new HashMap<String, String>();
		productInfoMap = new LinkedHashMap<String, String>();
		// productInfoMap = new TreeMap<String, String>();

		// header:
		productInfoMap.put("productname", getProdHeader());
		getProductMetaData();
		getProdPrice();
		System.out.println(productInfoMap);
		return productInfoMap;
	}

	// fetching meta data:
	private void getProductMetaData() {
		// meta data:
		List<WebElement> metaList = eleUtil.getElements(productMetaData);
		for (WebElement e : metaList) {
			String meta = e.getText();// Brand: Apple
			String metaInfo[] = meta.split(":");
			String key = metaInfo[0].trim();
			String value = metaInfo[1].trim();
			productInfoMap.put(key, value);
		}
	}
	
	// fetching price data:
	private void getProdPrice() {
		// price:
		List<WebElement> priceList = eleUtil.getElements(productPriceData);
		String price = priceList.get(0).getText();
		String exTax = priceList.get(1).getText();
		String extaxVal = exTax.split(":")[1].trim();

		productInfoMap.put("productprice", price);
		productInfoMap.put("exTax", extaxVal);
	}


	public void enterQuantity(int qty) {
		System.out.println("Product Quantity: " + qty);
		eleUtil.doSendKeys(quantity, String.valueOf(qty));
	}
	
	public String addProductToCart() {
		eleUtil.doClick(addToCartBtn);
		String successMessg = eleUtil.waitForElementVisible(cartSuccessMessg, AppConstants.DEFAULT_MEDIUM_TIMEOUT).getText();
		StringBuilder sb = new StringBuilder(successMessg);//for String manupulation it is better to use builder and later convert into toString()
		String mesg = sb.substring(0, successMessg.length()-1).replace("\n", "").toString();//substring used bcz in message some extra thing is there.To remove the last index of it
																							//After message cursor showing in new line	.to avoid that replace used							
		
		System.out.println("Cart Success Mesg: " + mesg);
		return mesg;
	}


	public ViewCartPopUpPage openCart() {
		eleUtil.doClick(cart);
		return new ViewCartPopUpPage(driver);
	}

}
