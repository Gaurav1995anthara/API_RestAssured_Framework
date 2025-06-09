package org.Nav.Explore.mockTests;

import org.Nav.Explore.base.BaseTest;
import org.Nav.explore.constants.AuthType;
import org.Nav.explore.mocking.APIMocks;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MockCreateUserAPITest extends BaseTest{

	@Test
	public void createAFakeUserTest() {
		
		APIMocks.defineCreateUserMock();
		
		String dummyUserJson = "{\n"
				+ "    \"name\": \"tom\"\n"
				+ "}";
		Response response = restclient.post(BASE_URL_MOCK_SERVER, "/api/users", AuthType.NO_AUTH, ContentType.JSON, dummyUserJson);
		response.then().assertThat().statusCode(201);
		
	}
}
