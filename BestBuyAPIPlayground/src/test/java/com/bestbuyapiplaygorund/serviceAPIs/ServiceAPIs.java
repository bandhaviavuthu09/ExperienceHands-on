package com.bestbuyapiplaygorund.serviceAPIs;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ServiceAPIs {	
	
		
		String serviceId;
		public String addService() {
			RestAssured.baseURI="http://localhost:3030/";
			String response=given().log().all().header("Content-Type","application/json").
			body("{\r\n"
					+ "    \"name\": \"hj\"\r\n"
					+ "}").
			when().post("services").then().assertThat().statusCode(201)
			.extract().response().asString();
			
			System.out.println("Response is "+response);
			JsonPath js=new JsonPath(response);
			serviceId=js.getString("id");
			System.out.println("Created Service ID "+serviceId);
			return serviceId;
		}
		
		public String updateService(String id,String Name) {
//			RestAssured.baseURI="http://localhost:3030/";
			String updatedResponse=given().log().all().queryParam("id",id).
					header("Content-Type","application/json")
					.body("{\r\n"
							+ "    \"name\": \""+Name+"\"\r\n"
							+ "}").
					when().patch("services")
					.then().assertThat().log().all().statusCode(200).extract().response().asString();
					
					System.out.println("Response is "+updatedResponse);
					JsonPath js1=new JsonPath(updatedResponse);
					
					String updatedServiceId=js1.getString("id");
					String updatedServiceName=js1.getString("name");
					System.out.println("Updated Service ID"+updatedServiceId);
					System.out.println("Updated Service name "+updatedServiceName);
					
					return updatedResponse;
					
					
		}
		
		public String getOneService(String serviceId)
		{
//			RestAssured.baseURI="http://localhost:3030/";
			String serviceResponse=	given().log().all()
					.queryParam("id",serviceId).header("Content-Type","application/json")
					.body(" {\r\n"
							+ "    \"name\": \"string\"\r\n"
							+ "  }")
					.when().get("services/"+serviceId+"")
					.then().assertThat().log().all().statusCode(200).extract().response().asString();
			
				JsonPath js2=new JsonPath(serviceResponse);
				String getServiceName= js2.getString("name");
				return getServiceName;
			
		}
		
		public Response getAllService()
		{
			RestAssured.baseURI="http://localhost:3030/";
			Response serviceResponse=given().log().all().body("{\r\n"
					+ "    \"name\": \"string\"\r\n"
					+ "  }")
					.when().get("services")
					.then().assertThat().log().all().statusCode(200).extract().response();
			
				int obtainedSc=serviceResponse.getStatusCode();
				
				return serviceResponse;
				
			
		}

	}



