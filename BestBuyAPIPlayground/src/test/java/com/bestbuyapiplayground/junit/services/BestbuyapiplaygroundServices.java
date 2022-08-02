package com.bestbuyapiplayground.junit.services;



import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.bestbuyapiplayground.cucumber.serenityresusable.*;
import com.bestbuyapiplayground.junit.baseURIinit.BaseURI;
import com.bestbuyapiplayground.model.CreateNewServiceSteps;
import com.bestbuyapiplayground.model.CreateService;
import com.bestbuyapiplayground.utils.ReusableRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.junit.annotations.UseTestDataFrom;

@UseTestDataFrom("TestData/MOCK_DATA_ss.csv")
@RunWith(SerenityParameterizedRunner.class)
public class BestbuyapiplaygroundServices extends BaseURI {
	Response res;
	ReusableRequest rr=new ReusableRequest();
	
	@Steps
	CreateNewServiceSteps createNewServiceSteps;
	
	public String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	CreateBestBuyServices cbs = new CreateBestBuyServices();
	
	/*@WithTags(
			{
			@WithTag(name="bestbuyapiplaygroundfeature:SERVICE"),
			@WithTag(name="bestbuyapiplaygroundfeature:SMOKE")
			}
			)*/
	@Test
	public void playGroundService() throws JsonMappingException, JsonProcessingException {
		

		res= cbs.createbestbuyapiServic(name)
		.when().post("services").then().spec(rr.createServiceResSpec()).extract().response();
		assertEquals(res.getStatusCode(), 201);
				
	}

}
