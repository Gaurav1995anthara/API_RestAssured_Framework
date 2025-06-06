package org.Nav.explore.utility;

import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import io.restassured.response.Response;

public class JwayJsonPath {

	
	public static ReadContext responseAs(Response response) {
		
		String res = response.getBody().asString();
	//	return JsonPath.parse(res);
		ReadContext ctx = JsonPath.parse(res);
		return ctx;
	}
	
	public static <T> T responseJwayPath(Response response, String jsonPath) {
		
		return responseAs(response).read(jsonPath);
	}
	
	
	public static <T> List<T> responseJwayPathWithList(Response response, String jsonPath) {
		
		ReadContext readctx = responseAs(response);
		return readctx.read(jsonPath);
	}
	
	public static <T> List<Map<String, T>> responseJwayPathWithListOfMap(Response response, String jsonPath) {
		
		ReadContext readctx = responseAs(response);
		return readctx.read(jsonPath);
	}
}
