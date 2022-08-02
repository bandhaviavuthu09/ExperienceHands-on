package com.bestbuyapiplayground.junit.products;

import com.bestbuyapiplayground.junit.baseURIinit.BaseURI;
import com.bestbuyapiplayground.model.CreateNewProductSteps;
import com.bestbuyapiplayground.model.CreateProduct;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import static org.junit.Assert.*;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.bestbuyapiplayground.cucumber.serenityresusable.*;
import com.bestbuyapiplayground.utils.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;

//@Concurrent(threads = "4x")
@UseTestDataFrom("TestData/MOCK_DATA_sp.csv")
@RunWith(SerenityParameterizedRunner.class)
public class BestbuyapiplaygroundProducts extends BaseURI {
	
	Response res;
	ReusableRequest rr=new ReusableRequest();
	
	@Steps
	CreateNewProductSteps createNewProductSteps;
	
	public String name;
	public String type;
	public Integer price;
	public int shipping;
	public String upc;
	public String description;
	public String manufacturer;
	public String model;
	public String url;
	public String image;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	CreateBestBuyProducts cbp = new CreateBestBuyProducts();
	
	@Test
	public void playGroundProduct() throws JsonMappingException, JsonProcessingException
	{
		res= cbp.createbestbuyapiproducts(name, type, price, shipping, upc, description, manufacturer, model, url, image)
		.when().post("products").then().spec(rr.createProductresspec()).extract().response();
		assertEquals(res.getStatusCode(), 201);
			
}
	
	
}