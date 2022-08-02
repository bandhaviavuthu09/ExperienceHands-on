package com.bestbuyapiplayground.junit.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.bestbuyapiplayground.cucumber.serenityresusable.CreateBestBuyProducts;
import com.bestbuyapiplayground.cucumber.serenityresusable.CreateBestBuyServices;
import com.bestbuyapiplayground.junit.baseURIinit.BaseURI;
import com.bestbuyapiplayground.model.CreateNewProductSteps;
import com.bestbuyapiplayground.model.CreateNewServiceSteps;
import com.bestbuyapiplayground.utils.ReusableRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@UseTestDataFrom("TestData/CreateServiceMulti.csv")
@RunWith(SerenityParameterizedRunner.class)
public class BestbuyapiplaygroundMultipleServicesTest extends BaseURI {

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
			
			
			@Test
			public void createmultipleServices() throws JsonMappingException, JsonProcessingException
			{
				res= cbs.createbestbuyapiServic(name)
				.when().post("services").then().spec(rr.createServiceResSpec()).extract().response();
				assertEquals(res.getStatusCode(), 201);
					
		}
			
			
		}
		



