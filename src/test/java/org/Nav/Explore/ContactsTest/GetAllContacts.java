package org.Nav.Explore.ContactsTest;

import java.net.URL;

import org.Nav.Explore.base.BaseTest;
import org.Nav.explore.constants.AuthType;
import org.Nav.explore.manager.ConfigManager;
import org.Nav.explore.utility.Utils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllContacts extends BaseTest{

	
	private String token;
	private String id;
	
	@BeforeMethod
	public void generateToken() {
		// URL url = ConfigManager.class.getClassLoader().getResource("configuration/config.properties");
		// System.out.println("File URL in Jenkinsssssss: " + url);
		token = Utils.createToken();
	}
	
	@Test
	public void getAllContactsTest() {
		
		ConfigManager.setProperties("bearertoken", token);
		Response getAllUsers = restclient.get(CONTACTS_BASEURL, CONTACTS_USER_ENDPOINT, AuthType.BEARER_TOKEN, ContentType.JSON);
		id = getAllUsers.jsonPath().getString("[1]._id");
		System.out.println("The is is :"+ id);
		Assert.assertEquals(getAllUsers.statusCode(), 200);
		
	}
}
