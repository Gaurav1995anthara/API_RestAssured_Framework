package org.Nav.Explore.mockTests;

import java.util.HashMap;
import java.util.Map;

import org.Nav.Explore.base.BaseTest;
import org.Nav.explore.constants.AuthType;
import org.Nav.explore.mocking.APIMocks;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MockGetUserAPITest extends BaseTest{

	@Test
	public void getDummyUserMockAPITest() {		
		APIMocks.defineGetUserMock();
		
		Response response = 
		restclient.get(BASE_URL_MOCK_SERVER, "/api/users", AuthType.NO_AUTH, ContentType.ANY);
		response.then().assertThat().statusCode(200);		
	}
	
	
	@Test
	public void getDummyUserMockAPIWithJsonFileTest() {		
		APIMocks.defineGetUserMockWithJsonFile();
		
		Response response = 
				restclient.get(BASE_URL_MOCK_SERVER, "/api/users", AuthType.NO_AUTH, ContentType.ANY);
		response.then().assertThat().statusCode(200);		
	}
	
	
	@Test
	public void getDummyUserMockAPIWithQueryParamTest() {		
		APIMocks.defineGetUserMockWithQueryParam();
		
		Map<String, String> userQueryMap = new HashMap<String, String>();
		userQueryMap.put("name", "Tom");
		
		Response response = 
				restclient.get(BASE_URL_MOCK_SERVER, "/api/users", userQueryMap, AuthType.NO_AUTH, ContentType.ANY);
		response.then().assertThat().statusCode(200);		
	}
}
