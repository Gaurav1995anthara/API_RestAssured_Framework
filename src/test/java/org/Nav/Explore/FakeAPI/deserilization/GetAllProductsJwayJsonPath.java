package org.Nav.Explore.FakeAPI.deserilization;

import java.util.List;

import org.Nav.Explore.base.BaseTest;
import org.Nav.explore.constants.AuthType;
import org.Nav.explore.utility.JwayJsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllProductsJwayJsonPath extends BaseTest{

	private Response response;
	
	@Test
	public void getProductsJsonPath() {
		
		response = restclient.get(PRODUCTS_BASEURL, PRODUCTS_ENDPOINT, AuthType.NO_AUTH, ContentType.ANY);
	
		Assert.assertEquals(response.statusCode(), 200);
		
		List<Number> prices = JwayJsonPath.responseJwayPathWithList(response, "$[?(@.price > 50)].price");
		System.out.println(prices);

		List<Number> ids = JwayJsonPath.responseJwayPathWithList(response, "$[?(@.price > 50)].id");
		System.out.println(ids);

		List<Number> rates = JwayJsonPath.responseJwayPathWithList(response, "$[?(@.price > 50)].rating.rate");
		System.out.println(rates);
	}
}
