package org.Nav.Explore.BasicAuth;

import org.Nav.Explore.base.BaseTest;
import org.Nav.explore.constants.AuthType;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BasicAuthTest extends BaseTest{

	@Test
	public void basicAuthTest() {
		
		Response response = restclient.get(BASE_URL_BASIC_AUTH, BASIC_AUTH_ENDPOINT, AuthType.BASIC_AUTH, ContentType.ANY);
		Assert.assertTrue(response.getBody().asString().contains("Congratulations! You must have the proper credentials."));
	}
}
