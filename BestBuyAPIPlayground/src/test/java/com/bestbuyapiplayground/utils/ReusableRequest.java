package com.bestbuyapiplayground.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReusableRequest {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	ResponseSpecification resspecService;
	
	public RequestSpecification createProductreqspec() throws JsonMappingException, JsonProcessingException
	{

		RestAssured.baseURI="http://localhost:3030/";
		
	
		RequestSpecification reqspecproduct=new RequestSpecBuilder().setBaseUri(RestAssured.baseURI).
				setContentType(ContentType.JSON).build();
		
//		resspec=new ResponseSpecBuilder().expectStatusCode(201).
//				expectContentType(ContentType.JSON).build();
		
		return reqspecproduct;
		

}
	
	public ResponseSpecification createProductresspec()
	{
		resspec=new ResponseSpecBuilder().expectStatusCode(201).
				expectContentType(ContentType.JSON).build();
		return resspec;
		
	}
	
	public RequestSpecification createServiceReqSpec() throws JsonMappingException, JsonProcessingException
	{

		RestAssured.baseURI="http://localhost:3030/";
		
	
		RequestSpecification reqspecService=new RequestSpecBuilder().setBaseUri(RestAssured.baseURI).
				setContentType(ContentType.JSON).build();
		return reqspecService;		

}
	
	public ResponseSpecification createServiceResSpec()
	{
		resspecService=new ResponseSpecBuilder().expectStatusCode(201).
				expectContentType(ContentType.JSON).build();
		return resspecService;
		
	}

}
