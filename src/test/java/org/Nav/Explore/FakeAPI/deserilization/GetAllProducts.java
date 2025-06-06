package org.Nav.Explore.FakeAPI.deserilization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.Nav.Explore.base.BaseTest;
import org.Nav.explore.constants.AuthType;
import org.Nav.explore.pojos.Products;
import org.Nav.explore.utility.JsonResponseUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllProducts extends BaseTest{
	
	private Response response;
	
	@Test
	public void getProducts() {
		
		response = restclient.get(PRODUCTS_BASEURL, PRODUCTS_ENDPOINT, AuthType.NO_AUTH, ContentType.ANY);
		
		Products[] productResponse = JsonResponseUtils.deseriliaze(response, Products[].class);
		
		List<String> expectedTitles = Arrays.asList(
			    "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
			    "Mens Casual Premium Slim Fit T-Shirts ",
			    "Mens Cotton Jacket",
			    "Mens Casual Slim Fit",
			    "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet",
			    "Solid Gold Petite Micropave ",
			    "White Gold Plated Princess",
			    "Pierced Owl Rose Gold Plated Stainless Steel Double",
			    "WD 2TB Elements Portable External Hard Drive - USB 3.0 ",
			    "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s",
			    "Silicon Power 256GB SSD 3D NAND A55 SLC Cache Performance Boost SATA III 2.5",
			    "WD 4TB Gaming Drive Works with Playstation 4 Portable External Hard Drive",
			    "Acer SB220Q bi 21.5 inches Full HD (1920 x 1080) IPS Ultra-Thin",
			    "Samsung 49-Inch CHG90 144Hz Curved Gaming Monitor (LC49HG90DMNXZA) – Super Ultrawide Screen QLED ",
			    "BIYLACLESEN Women's 3-in-1 Snowboard Jacket Winter Coats",
			    "Lock and Love Women's Removable Hooded Faux Leather Moto Biker Jacket",
			    "Rain Jacket Women Windbreaker Striped Climbing Raincoats",
			    "MBJ Women's Solid Short Sleeve Boat Neck V ",
			    "Opna Women's Short Sleeve Moisture",
			    "DANVOUY Womens T Shirt Casual Cotton Short"
			);
		
		List<String> actualTitles = new ArrayList<>();
		for (Products p : productResponse) {
		    actualTitles.add(p.getTitle());
		}
		
		Assert.assertEquals(actualTitles, expectedTitles);
	}
	
	
	@Test
	public void getALLProducts() {
		
		response = restclient.get(PRODUCTS_BASEURL, PRODUCTS_ENDPOINT, AuthType.NO_AUTH, ContentType.ANY);
		
		Products[] productResponse = JsonResponseUtils.deseriliaze(response, Products[].class);
		
		List<String> expectedTitles = Arrays.asList(
			    "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
			    "Mens Casual Premium Slim Fit T-Shirts ",
			    "Mens Cotton Jacket",
			    "Mens Casual Slim Fit",
			    "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet",
			    "Solid Gold Petite Micropave ",
			    "White Gold Plated Princess",
			    "Pierced Owl Rose Gold Plated Stainless Steel Double",
			    "WD 2TB Elements Portable External Hard Drive - USB 3.0 ",
			    "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s",
			    "Silicon Power 256GB SSD 3D NAND A55 SLC Cache Performance Boost SATA III 2.5",
			    "WD 4TB Gaming Drive Works with Playstation 4 Portable External Hard Drive",
			    "Acer SB220Q bi 21.5 inches Full HD (1920 x 1080) IPS Ultra-Thin",
			    "Samsung 49-Inch CHG90 144Hz Curved Gaming Monitor (LC49HG90DMNXZA) – Super Ultrawide Screen QLED ",
			    "BIYLACLESEN Women's 3-in-1 Snowboard Jacket Winter Coats",
			    "Lock and Love Women's Removable Hooded Faux Leather Moto Biker Jacket",
			    "Rain Jacket Women Windbreaker Striped Climbing Raincoats",
			    "MBJ Women's Solid Short Sleeve Boat Neck V ",
			    "Opna Women's Short Sleeve Moisture",
			    "DANVOUY Womens T Shirt Casual Cotton Short"
			);
		
		List<String> actualTitles = new ArrayList<>();
		for (Products p : productResponse) {
		    actualTitles.add(p.getTitle());
		}
		
		Assert.assertEquals(actualTitles, expectedTitles);
	}

}
