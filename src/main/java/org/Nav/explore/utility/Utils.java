package org.Nav.explore.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.Nav.explore.client.RestClient;
import org.Nav.explore.constants.AuthType;
import org.Nav.explore.constants.URLconstants;
import org.Nav.explore.manager.ConfigManager;
import org.Nav.explore.pojos.ContactsLogin;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Utils {

	private static RestClient restclient;
	
	public static String getRandomEmailID() {
		return "gvAPI"+System.currentTimeMillis()+"@openmail.com";
	}
	
	
	public static String getRandomEmailForJsonValue() throws IOException {
		
		String randomEmail = Utils.getRandomEmailID();
		String rawJson = new String(Files.readAllBytes(Paths.get("./src/test/resource/json/user.json")));
		String updatedjson = rawJson.replace("<<<RANDOM_EMAIL>>>", randomEmail);
		return updatedjson;
	}
	
	
	public static String createToken() {
		restclient = new RestClient();
		ContactsLogin login = new ContactsLogin(ConfigManager.getProperties("email"), ConfigManager.getProperties("password"));
		Response response = restclient.post(URLconstants.getContactsBaseurl(), URLconstants.getContactsLoginUserEndpoint(), AuthType.NO_AUTH, ContentType.JSON, login);
		String token = response.jsonPath().getString("token");
		System.out.println("TOKEN : "+token);
		return token;
	}
	
	
	public static String generateBasicAuth() {
		
		String credentials = ConfigManager.getProperties("basicauthusername") + ":" + ConfigManager.getProperties("basicauthpassword");
		return Base64.getEncoder().encodeToString(credentials.getBytes());
	}
}
