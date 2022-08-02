package com.bestbuyapiplayground.junit.services;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bestbuyapiplayground.cucumber.stepdefinitions.StepDefinition;

@RunWith(SerenityRunner.class)
public class Debug {
	
	@Steps
	StepDefinition s;
	
	
	@BeforeClass
	public static void setUp()
	{
		RestAssured.baseURI="http://localhost:3030/";
	}

	@Test
	@Title("get all services")
	public void test() {
		s.get_all_services();
		s.http_request();
		s.http_response();
		
		System.out.println("executed");
	}
	
	@Title("Passing")
	@Test()
	public void passStatuscode() {
		
		Response response = SerenityRest.given().when().get("services").then().
				assertThat().log().all().statusCode(200).extract().response();
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		response.then().statusCode(200);
		assertEquals(response.getStatusCode(),200);
		System.out.println("test case passed with ststus code");
		
	}
	
	@Title("Failing")
	@Test()
	public void failStatuscode() {
		
		Response response = SerenityRest.given().when().get("services").then().
				assertThat().log().all().statusCode(200).extract().response();
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		response.then().statusCode(200);
		
		assertEquals(response.getStatusCode(),201);
	}
	
	@Pending
	@Test
	public void pending() {
		
	System.out.println("pending");
	}
	
	@Ignore
	@Test
	public void ignoring() {
		
	System.out.println("Ignoring");
	}
	
	@Title("Errors")
	@Test
	public void errors() throws ArithmeticException {
		
		int c=10/0;
		System.out.println("Errors"+c);
	}
	
	@Title("Compromised")
	@Test
	public void compromised() {
		
		
		System.out.println("FIle Not found exception");
	}


}
