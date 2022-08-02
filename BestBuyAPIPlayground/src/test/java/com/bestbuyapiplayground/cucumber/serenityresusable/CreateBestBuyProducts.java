package com.bestbuyapiplayground.cucumber.serenityresusable;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import com.bestbuyapiplayground.utils.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class CreateBestBuyProducts extends ReusableRequest {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
//	RequestSpecification req;
	ReusableRequest req=new ReusableRequest();
	Payload p=new Payload();
	
	@Step
	public RequestSpecification createbestbuyapiproducts(String name, String type,Integer price,int shipping,String upc,String description,
			String manufacturer
			,String model,String url,String image) throws JsonMappingException, JsonProcessingException{
		
		res=SerenityRest.given().spec(req.createProductreqspec())
				.body(p.CreateproductPayLoad(name, type, price, shipping, upc, description, manufacturer, 
						model, url, image));
		
		return res;
	}

}
