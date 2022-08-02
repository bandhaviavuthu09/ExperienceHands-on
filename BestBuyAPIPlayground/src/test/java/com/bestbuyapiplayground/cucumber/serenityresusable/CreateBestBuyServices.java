package com.bestbuyapiplayground.cucumber.serenityresusable;

import static io.restassured.RestAssured.given;
import net.thucydides.core.annotations.Step;


import com.bestbuyapiplayground.utils.Payload;
import com.bestbuyapiplayground.utils.ReusableRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateBestBuyServices extends ReusableRequest{

	
		RequestSpecification resSpecificationProduct;
		ResponseSpecification resspec;
		Response response;
//		RequestSpecification req;
		ReusableRequest req=new ReusableRequest();
		Payload p=new Payload();
		@Step
		public RequestSpecification createbestbuyapiServic(String name) throws JsonMappingException, JsonProcessingException
		{
		resSpecificationProduct=given().spec(req.createServiceReqSpec())
					.body(p.CreateServicePayload(name));
			
			return resSpecificationProduct;
		}
		
	}

	

