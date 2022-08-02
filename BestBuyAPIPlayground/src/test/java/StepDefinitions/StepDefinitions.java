/*package StepDefinitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import com.bestbuyapiplayground.junit.products.BestbuyapiplaygroundCreateMultipleProducts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import junit.framework.Assert;
import net.serenitybdd.rest.SerenityRest;

public class StepDefinitions {
//	BestbuyapiplaygroundCreateMultipleProducts mp;
	Response res;
	@Given("url")
	public void url() 
		{
			RestAssured.baseURI = "http://localhost:3030";
		}
	
	@When("http request for list of services")
	public void http_request_for_list_of_services() {
		Response res=SerenityRest.given().log().all().
				when().get("services").then().
				assertThat().log().all().statusCode(200).extract().response();
	}

	@Then("http response for list of services")
	public void http_response_for_list_of_services() {
//	   		assertEquals(res.getStatusCode(),200);
		System.out.println("assert");

	}
	
	@When("http request for creation of service")
	public void http_request_for_creation_of_service() throws JsonMappingException, JsonProcessingException {
		
		res=SerenityRest.given().log().all().header("Content-Type","application/json").
		body("{\r\n"
				+ "    \"name\": \"hj\"\r\n"
				+ "}").
		when().post("services").then().assertThat().statusCode(201)
		.extract().response();
		
	}

	@Then("http response for creation of service")
	public void http_response_for_creation_of_service() {
		Assert.assertEquals(res.getStatusCode(), 201);
	}
	
	@When("http request for list of products")
	public void http_request_for_list_of_products() {
		res=SerenityRest.given().log().all().
				when().get("products").then().
				assertThat().log().all().statusCode(200).extract().response();
	}

	@Then("http response for list of products")
	public void http_response_for_list_of_products() {
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@When("http request for creation of product")
	public void http_request_for_creation_of_product() throws JsonMappingException, JsonProcessingException
	{
		res=SerenityRest.given().log().all().header("Content-Type","application/json").
				body("{\r\n"
						+ "    \"name\": \"service\"\r\n"
						+ "}").
				when().post("services").then().assertThat().statusCode(201)
				.extract().response();
	
	}

	@Then("http response for creation of product")
	public void http_response_for_creation_of_product()
	{
		Assert.assertEquals(res.getStatusCode(), 201);
	
	   
	}
	
/* @Given("I provide the new product information name value type value price < price> shipping < shipping> upc value description value manufacturer value model value url value image value")
	public void i_provide_the_new_product_information_name_value_type_value_price_price_shipping_shipping_upc_value_description_value_manufacturer_value_model_value_url_value_image_value() throws JsonMappingException, JsonProcessingException {
	    mp.createmultipleProduct();
	}

	@When("I send request for the new product creation")
	public void i_send_request_for_the_new_product_creation() {
	  
	}

	@Then("a new product is created within Best Buy API Playground")
	public void a_new_product_is_created_within_Best_Buy_API_Playground() {
	 
//		Assert.assertEquals(res.getStatusCode(), 201);
	}

}*/
