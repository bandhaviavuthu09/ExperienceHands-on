package com.bestbuyapiplayground.junit.baseURIinit;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class BaseURI {
	
	@BeforeClass
	public static void baseURIIntiliazation()
	{
		RestAssured.baseURI="http://localhost:3030/";
		System.out.println("url 3030 is opened");
	}
	
	

}
