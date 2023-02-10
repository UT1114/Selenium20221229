package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final int DEFAULT_TIME_OUT = 10;

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_HEADER = "";
	public static final String PRODUCT_HEADER = "MacBook Pro";

	public static final int IMAC_IMAGE_COUNT = 3;
	public static final int MACBOOKPRO_IMAGE_COUNT = 4;

	public static final String LOGIN_ERROR_MESG = "No match for E-Mail Address and/or";

	public static final String REGISTRATION_PAGE_TITLE = "Register Account";

	public static final String REGISTRATION_SUCCESS_MESSG = "Created";
	public static final String EXCEL_SHEET_NAME="register";

	public static final String EXCEL_PRODUCTSEARCH_SHEET_NAME = "product";
	public static final String EXCEL_ADDRESS_SHEET_NAME = "address";


	public static final String ADDRESS_BOOK_PAGE_TITLE_FRACTION = "Book";
	public static final String ADDRESS_BOOK_PAGE_TITLE = "Address Book";

	public static final String ADDRESS_BOOK_PAGE_HEADER = "Address Book Entries";

	public static final String NEW_ADDRESS_PAGE_TITLE_FRACTION = "Address Bo";
	public static final String NEW_ADDRESS_PAGE_TITLE = "Address Book";

	public static final String NEW_ADDRESS_PAGE_HEADER = "Add Address";

	public static final String NEW_ADDRESS_ADDED_SUCCESS_MSG = "Your address has been successfully added";

	public static final String DELETE_ADDRESS_MESSG = " Your address has been successfully deleted";




	public static List<String> getExpAccSecList() {
		List<String> expSecList = new ArrayList<String>();
		expSecList.add("My Account");
		expSecList.add("My Orders");
		expSecList.add("My Affiliate Account");
		expSecList.add("Newsletter");

		return expSecList;

	}

}
