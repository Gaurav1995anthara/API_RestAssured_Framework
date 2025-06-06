package org.Nav.Explore.base;

import java.util.List;

import org.Nav.explore.client.RestClient;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;

public class BaseTest {

	protected RestClient restclient;
	
	//baseURL
	protected final static String BASE_URL_GOREST = "https://gorest.co.in";
	protected final static String CONTACTS_BASEURL = "https://thinking-tester-contact-list.herokuapp.com";
	protected final static String BASE_URL_BASIC_AUTH = "https://the-internet.herokuapp.com";
	protected final static String PRODUCTS_BASEURL = "https://fakestoreapi.com";
	protected final static String BASE_URL_OAUTH2_AMADEUS = "https://test.api.amadeus.com";
	protected final static String BASE_URL_ERGAST_CIRCUIT = "http://ergast.com";
	
	//endpoints
	protected final static String GOREST_USERS_ENDPOINT = "/public/v2/users";
	protected final static String CONTACTS_LOGIN_USER_ENDPOINT = "/users/logi";
	protected final static String CONTACTS_USER_ENDPOINT = "/contacts";
	protected final static String BASIC_AUTH_ENDPOINT = "/basic_auth";
	protected final static String PRODUCTS_ENDPOINT = "/products";
	protected final static String AMADEUS_OATUH2_TOKEN_ENDPOINT = "/v1/security/oauth2/token";
	protected final static String AMADEUS_FLIGHT_DEST_ENDPOINT = "/v1/shopping/flight-destinations";
	protected final static String ERGAST_CIRCUIT_ENDPOINT = "/api/f1/2017/circuits.xml";
	
	@BeforeSuite
	public void setupAllureResport() {
		RestAssured.filters(new AllureRestAssured());
		RestAssured.filters((List<Filter>) new AllureTestNg());
	}
	
	@BeforeTest
	public void setUp() {
		
		restclient = new RestClient();
	}
	
}
