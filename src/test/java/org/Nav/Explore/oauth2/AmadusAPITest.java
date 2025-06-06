package org.Nav.Explore.oauth2;

import java.util.HashMap;
import java.util.Map;

import org.Nav.Explore.base.BaseTest;
import org.Nav.explore.constants.AuthType;
import org.Nav.explore.manager.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AmadusAPITest extends BaseTest{
	
	private String accessToken;
	
	@BeforeMethod
	public void getOauth2Token() {
		
		Response response = restclient.post(BASE_URL_OAUTH2_AMADEUS, AMADEUS_OATUH2_TOKEN_ENDPOINT, ContentType.URLENC, AuthType.OAUTH2);
		accessToken = response.jsonPath().getString("access_token");
		System.out.println(accessToken);
	}

	
	@Test
	public void getFlightDetailsTest() {
		
		ConfigManager.setProperties("bearertoken", accessToken);
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("origin", "PAR");
		queryParams.put("maxPrice", "200");
		
		Response getResponse = restclient.get(BASE_URL_OAUTH2_AMADEUS, AMADEUS_FLIGHT_DEST_ENDPOINT, queryParams, AuthType.BEARER_TOKEN, ContentType.URLENC);
		Assert.assertEquals(getResponse.statusCode(), 200);
	}
}
