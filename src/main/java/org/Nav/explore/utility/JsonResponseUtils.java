package org.Nav.explore.utility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class JsonResponseUtils {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static <T> T deseriliaze(Response response, Class<T> targetClass) {
		
		try {
			return mapper.readValue(response.getBody().asString(), targetClass);
		} catch (Exception e) {
			throw new RuntimeException("deseriliazation is failed");
		} 
		
		
		/*
		try {
			return mapper.readValue(response.getBody().asString(), targetClass);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		*/
	}
}
