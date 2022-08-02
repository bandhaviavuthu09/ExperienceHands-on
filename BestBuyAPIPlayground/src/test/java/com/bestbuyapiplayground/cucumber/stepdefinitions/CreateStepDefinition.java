package com.bestbuyapiplayground.cucumber.stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

public class CreateStepDefinition {
	
	Response res;
	@Step("url")
	public void get_all_services()
	{
		RestAssured.baseURI = "http://localhost:3030";
	}
	@Step("http reuest")
	public void http_request()
	{
		Response res=given().log().all().
				when().get("services").then().
				assertThat().log().all().statusCode(200).extract().response();
		
		
	}
	@Step("http response")
	public void http_response()
	{
		
		assertEquals(res.getStatusCode(),200);
	
	}

}


