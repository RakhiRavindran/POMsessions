package com.qa.opencart.constants;


import java.util.Arrays;
import java.util.List;

public class AppConstants {
	
	public static final int DEFAULT_LONG_TIMEOUT=20;
	public static final int DEFAULT_MEDIUM_TIMEOUT=10;
	public static final int DEFAULT_SHORT_TIMEOUT=5;
	
	public static final String LOGIN_PAGE_TITLE_VALUE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION_VALUE = "route=account/login";
	
	public static final String ACC_PAGE_TITLE_VALUE = "My Account";
	public static final String ACC_PAGE_URL_FRACTION_VALUE = "route=account/account";
	
	public static final List<String> EXPECTED_ACC_PAGE_HEADER_LIST = Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	
	public static final List<String> EXPECTED_ACCOUNT_PAGE_HEADERS_LIST = Arrays.asList("My Account", "My Orders", 
			"My Affiliate Account", "Newsletter");
	public static final int ACCOUNT_PAGE_HEADERS_COUNT = 2;
	
	
	public static final String PRODINFO_PAGE_TITLE_VALUE ="Product info";
	public static final String PRODINFO_PAGE_HEADER_VALUE ="aSDDFFGFD";
	public static final CharSequence USER_REG_SUCCESS_MESSG = "Your Account Has Been Created";
	
	/***************sheet Names*********************/
	public static final String REGISTER_SHEET_NAME = "register";
	
}
