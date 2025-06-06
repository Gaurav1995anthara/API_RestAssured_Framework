package org.Nav.Explore.xml;

import java.util.List;

import org.Nav.Explore.base.BaseTest;
import org.Nav.explore.constants.AuthType;
import org.Nav.explore.utility.XpathUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CircuitAPIWithXMLTest extends BaseTest{

	@Test
	public void getCircuitInfoTest() {
		Response response = 
					restclient.get(BASE_URL_ERGAST_CIRCUIT, ERGAST_CIRCUIT_ENDPOINT, AuthType.NO_AUTH, ContentType.ANY);
	
		List<String> circuitNames = XpathUtils.readList(response, "MRData.CircuitTable.Circuit.CircuitName");
		System.out.println(circuitNames);
		
		for(String e : circuitNames) {
			Assert.assertNotNull(e);
		}
		
		
		String americaLoc = XpathUtils.read(response, "**.find{ it.@circuitId == 'americas' }.Location.Locality");
		System.out.println("americas location--->"+ americaLoc);
		Assert.assertEquals(americaLoc, "Austin");
	
	}
}
