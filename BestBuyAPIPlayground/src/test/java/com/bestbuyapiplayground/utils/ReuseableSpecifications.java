package com.bestbuyapiplayground.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;


class ReuseableSpecifications {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	public void createProduct(String name, String type,Integer price,int shipping,String upc,String description,
			String manufacturer
			,String model,String url,String image) throws JsonMappingException, JsonProcessingException
	{
		Payload p=new Payload();
		RestAssured.baseURI="http://localhost:3030/";
		
	
		RequestSpecification req=new RequestSpecBuilder().setBaseUri(RestAssured.baseURI).
				setContentType(ContentType.JSON).build();
		
		resspec=new ResponseSpecBuilder().expectStatusCode(201).
				expectContentType(ContentType.JSON).build();
		
			res=given().spec(req).
				body(p.CreateproductPayLoad(name, type, price, shipping, upc, description, manufacturer, 
						model, url, image));
		
		response=res.when().post("products").then().spec(resspec).extract().response();
}
	
	public void createService(int id,String name) throws JsonMappingException, JsonProcessingException
	{
		Payload p=new Payload();
		RestAssured.baseURI="http://localhost:3030/";		
	
		RequestSpecification req=new RequestSpecBuilder().setBaseUri(RestAssured.baseURI).
				setContentType(ContentType.JSON).build();
		
		resspec=new ResponseSpecBuilder().expectStatusCode(201).
				expectContentType(ContentType.JSON).build();
		
		res=given().spec(req).
				body(p.CreateServicePayload(name));
		
		response=res.when().post("products").then().spec(resspec).extract().response();
}
}
