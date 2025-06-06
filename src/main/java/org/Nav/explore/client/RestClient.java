package org.Nav.explore.client;

import java.io.File;
import java.util.Map;

import org.Nav.explore.constants.AuthType;
import org.Nav.explore.exceptions.ApiExceptions;
import org.Nav.explore.manager.ConfigManager;
import org.Nav.explore.utility.Utils;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

	private RequestSpecification setupRequest(String baseurl, AuthType authType, ContentType contentType) {

		RequestSpecification request = RestAssured.given().log().all().baseUri(baseurl).contentType(contentType)
				.accept(contentType);

		switch (authType) {
		case BASIC_AUTH: {
			request.header("Authorization", "Basic "+Utils.generateBasicAuth());
			//or
			//request.auth().basic(ConfigManager.getProperties("basicauthusername"), ConfigManager.getProperties("basicauthpassword"));
			break;
		}
		case API_TOKE: {
			request.header("", "");
			break;
		}
		case BEARER_TOKEN: {
			request.header("Authorization", "Bearer " +ConfigManager.getProperties("bearertoken"));
			break;
		}
		case OAUTH1: {
			request.header("", "");
			break;
		}
		case OAUTH2: {
			request.formParam("client_id", ConfigManager.getProperties("clientId"));
			request.formParam("client_secret", ConfigManager.getProperties("clientSecret"));
			request.formParam("grant_type", ConfigManager.getProperties("grantType"));
			break;
		}
		case NO_AUTH: {
			System.out.println("No auth present");
			break;
		}
		default:
			throw new ApiExceptions("Wrong auth type provided, please check...");
		}

		return request;

	}

	private void pathAndQueryParams(RequestSpecification request, Map<String, String> pathParams,
			Map<String, String> queryParams) {

		if (pathParams != null) {
			request.pathParams(pathParams);
		}

		if (queryParams != null) {
			request.queryParams(queryParams);
		}

	}

	// GET without path and query params
	public Response get(String baseurl, String endpoint, AuthType authType, ContentType contentType) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		Response response = request.when().get(endpoint).then().log().all().extract().response();
		return response;
	}

	// GET with pathParams
	public Response get(String baseurl, String endpoint, AuthType authType, ContentType contentType,
			Map<String, String> pathParams) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, pathParams, null);
		Response response = request.when().get(endpoint).then().log().all().extract().response();
		return response;
	}

	// GET with QueryParams
	public Response get(String baseurl, String endpoint, Map<String, String> queryParams, AuthType authType,
			ContentType contentType) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, null, queryParams);
		Response response = request.when().get(endpoint).then().log().all().extract().response();
		return response;
	}

	// GET with path and Query params
	public Response get(String baseurl, String endpoint, AuthType authType, ContentType contentType,
			Map<String, String> pathParams, Map<String, String> queryParams) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, pathParams, queryParams);
		Response response = request.when().get(endpoint).then().log().all().extract().response();
		return response;
	}
	
	//POST without body (used in OAUTH2 to generate token)
	public Response post(String baseurl, String endpoint, ContentType contentType, AuthType authType) {
		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		Response response = request.when().post(endpoint).then().log().all().extract().response();
		return response;
		
	}

	// POST with <T>body without path and query params
	public  <T> Response post(String baseurl, String endpoint, AuthType authType, ContentType contentType, T body) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		Response response = request.body(body).when().post(endpoint).then().log().all().extract().response();
		return response;

	}

	// POST with <T>body and path and query params
	public <T> Response post(String baseurl, String endpoint, AuthType authType, ContentType contentType, T body,
			Map<String, String> pathParams, Map<String, String> queryParams) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, pathParams, queryParams);
		Response response = request.body(body).when().post(endpoint).then().log().all().extract().response();
		return response;
	}

	// POST with File as a body and path and query params
	public Response post(String baseurl, String endpoint, AuthType authType, ContentType contentType, File body,
			Map<String, String> pathParams, Map<String, String> queryParams) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, pathParams, queryParams);
		Response response = request.body(body).when().post(endpoint).then().log().all().extract().response();
		return response;
	}

	// POST with <T>body and path params
	public <T> Response post(String baseurl, String endpoint, AuthType authType, ContentType contentType, T body,
			Map<String, String> pathParams) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, pathParams, null);
		Response response = request.body(body).when().post(endpoint).then().log().all().extract().response();
		return response;
	}

	// POST with <T>body and query params
	public <T> Response post(String baseurl, String endpoint, AuthType authType, Map<String, String> queryParams,
			ContentType contentType, T body) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, null, queryParams);
		Response response = request.body(body).when().post(endpoint).then().log().all().extract().response();
		return response;
	}

	// PUT with <T>body without path and query params
	public <T> Response put(String baseurl, String endpoint, AuthType authType, ContentType contentType, T body) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		Response response = request.body(body).when().put(endpoint).then().log().all().extract().response();
		return response;

	}

	// PUT with <T>body and path and query params
	public <T> Response put(String baseurl, String endpoint, AuthType authType, ContentType contentType, T body,
			Map<String, String> pathParams, Map<String, String> queryParams) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, pathParams, queryParams);
		Response response = request.body(body).when().put(endpoint).then().log().all().extract().response();
		return response;
	}

	// PUT with File as a body and path and query params
	public Response put(String baseurl, String endpoint, AuthType authType, ContentType contentType, File body,
			Map<String, String> pathParams, Map<String, String> queryParams) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, pathParams, queryParams);
		Response response = request.body(body).when().put(endpoint).then().log().all().extract().response();
		return response;
	}

	// PUT with <T>body and path params
	public <T> Response put(String baseurl, String endpoint, AuthType authType, ContentType contentType, T body,
			Map<String, String> pathParams) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, pathParams, null);
		Response response = request.body(body).when().put(endpoint).then().log().all().extract().response();
		return response;
	}

	// PUT with <T>body and query params
	public <T> Response put(String baseurl, String endpoint, AuthType authType, Map<String, String> queryParams,
			ContentType contentType, T body) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, null, queryParams);
		Response response = request.body(body).when().put(endpoint).then().log().all().extract().response();
		return response;
	}

	// DELETE without path and query params
	public Response delete(String baseurl, String endpoint, AuthType authType, ContentType contentType) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		Response response = request.when().delete(endpoint).then().log().all().extract().response();
		return response;
	}

	// DELETE without query params
	public Response delete(String baseurl, String endpoint, AuthType authType, ContentType contentType,
			Map<String, String> pathparama) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, pathparama, null);
		Response response = request.when().delete(endpoint).then().log().all().extract().response();
		return response;
	}

	// DELETE without path params
	public Response delete(String baseurl, String endpoint, AuthType authType, Map<String, String> queryParam,
			ContentType contentType) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, null, queryParam);
		Response response = request.when().delete(endpoint).then().log().all().extract().response();
		return response;
	}

	// DELETE with path and query params
	public Response delete(String baseurl, String endpoint, AuthType authType, ContentType contentType,
			Map<String, String> pathparama, Map<String, String> queryparams) {

		RequestSpecification request = setupRequest(baseurl, authType, contentType);
		pathAndQueryParams(request, pathparama, queryparams);
		Response response = request.when().delete(endpoint).then().log().all().extract().response();
		return response;
	}

}
