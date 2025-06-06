package org.Nav.Explore.goRes;

import org.Nav.Explore.base.BaseTest;
import org.Nav.explore.constants.AuthType;
import org.Nav.explore.pojos.User;
import org.Nav.explore.utility.JsonResponseUtils;
import org.Nav.explore.utility.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUser extends BaseTest{

protected Response response;
	
	@Test
	public void createUsertest() {
		
		User user = new User(null,"gauravv","male",Utils.getRandomEmailID(),"active");
		response = restclient.post(BASE_URL_GOREST, GOREST_USERS_ENDPOINT, AuthType.BEARER_TOKEN, ContentType.JSON,user);
		Assert.assertEquals(response.statusCode(), 201);
		
		User userResponse = JsonResponseUtils.deseriliaze(response, User.class);
		
		Assert.assertEquals(user.getGender(), userResponse.getGender());
		
	}
}
