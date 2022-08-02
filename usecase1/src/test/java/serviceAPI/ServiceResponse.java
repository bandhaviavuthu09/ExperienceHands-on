package serviceAPI;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import resources.Payload;

public class ServiceResponse {
	
	public Response payloadResponse(String name, String type,Double price,Double shipping,String upc,String description,
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

}
