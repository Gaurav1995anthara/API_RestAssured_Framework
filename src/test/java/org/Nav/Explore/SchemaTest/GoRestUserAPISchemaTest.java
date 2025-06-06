package org.Nav.Explore.SchemaTest;

import org.Nav.Explore.base.BaseTest;
import org.Nav.explore.constants.AuthType;
import org.Nav.explore.pojos.User;
import org.Nav.explore.utility.SchemaValidator;
import org.Nav.explore.utility.Utils;
import org.apache.commons.codec.binary.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GoRestUserAPISchemaTest extends BaseTest{

	@Test
	public void getUsersAPISchemaTest() {	
		
		Response response = restclient.get(BASE_URL_GOREST, GOREST_USERS_ENDPOINT, AuthType.BEARER_TOKEN, ContentType.ANY);
	
		Assert.assertTrue(SchemaValidator.validateSchema(response, "schema/getuserschema.json"));
	
	}
	
	
	@Test
	public void createUserAPISchemaTest() {	
		
		User user = User.builder()
		.name("api")
		.status("active")
		.email(Utils.getRandomEmailID())
		.gender("female")
		.build();
		
		Response response = restclient.post(BASE_URL_GOREST, GOREST_USERS_ENDPOINT,AuthType.BEARER_TOKEN, ContentType.JSON, user);
			
		Assert.assertTrue(SchemaValidator.validateSchema(response, "schema/createuserschema.json"));
	
	}
}
