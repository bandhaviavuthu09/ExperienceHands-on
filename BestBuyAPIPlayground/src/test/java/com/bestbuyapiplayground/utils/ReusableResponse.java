package com.bestbuyapiplayground.utils;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class ReusableResponse {
	
	public Response payloadProductResponse(String name, String type,Integer price,int shipping,String upc,String description,
			String manufacturer
			,String model,String url,String image) {
		
		Payload p=new Payload();
		RestAssured.baseURI="http://localhost:3030/";
		Response res=given().log().all().header("Content-Type","application/json").
		body(p.CreateproductPayLoad(name, type, price, shipping, upc, description, 
				manufacturer, model, url, image)).when().
		post("products").then().assertThat().statusCode(201).extract().response();
		
		return res;
		
	}
	
	public Response payloadserviceResponse(int id,String name) {
		
		Payload p=new Payload();
		RestAssured.baseURI="http://localhost:3030/";
		Response res=given().log().all().header("Content-Type","application/json").
		body(p.CreateServicePayload(name)).when().
		post("products").then().assertThat().statusCode(201).extract().response();
		
		return res;
		
	}

}
