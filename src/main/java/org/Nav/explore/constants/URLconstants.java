package org.Nav.explore.constants;

public class URLconstants {

	private final static String CONTACTS_BASEURL = "https://thinking-tester-contact-list.herokuapp.com";
	private final static String CONTACTS_LOGIN_USER_ENDPOINT = "/users/login";
	private final static String CONTACTS_USER_ENDPOINT = "/contacts";
	
	
	public static String getContactsBaseurl() {
		return CONTACTS_BASEURL;
	}
	
	public static String getContactsLoginUserEndpoint() {
		return CONTACTS_LOGIN_USER_ENDPOINT;
	}
}
