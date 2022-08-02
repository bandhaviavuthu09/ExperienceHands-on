package resources;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.CreateProduct;

public class CreateProductSpec{
	
	List<CreateProduct> carray=new ArrayList<CreateProduct>();
	int count;
	String productName;
	String productId;
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	@Test(enabled=true,dataProvider="ProductDetails")
	public void createProduct(String name, String type,Double price,Double shipping,String upc,String description,
			String manufacturer
			,String model,String url,String image) throws JsonMappingException, JsonProcessingException
	{
		Payload p=new Payload();
		RestAssured.baseURI="http://localhost:3030/";
		
	
		RequestSpecification req=new RequestSpecBuilder().setBaseUri(RestAssured.baseURI).
				setContentType(ContentType.JSON).build();
		
		resspec=new ResponseSpecBuilder().expectStatusCode(201).
				expectContentType(ContentType.JSON).build();
		
		res=given().spec(req).
				body(p.CreateproductPayLoad(name, type, price, shipping, upc, description, manufacturer, 
						model, url, image));
		
		response=res.when().post("products").then().spec(resspec).extract().response();
				
				
		productName=name;
		String resString=response.asString();
		JsonPath js=new JsonPath(resString);		
		productId=js.getString("id");		
//		System.out.println("product id"+productId);				
//		System.out.println("Created Product Name "+productName);//		
		assertEquals(response.getStatusCode(),201);		
		System.out.println("response as string and printing in console"+resString);	
		
	}
	
//	data provider method	
			@DataProvider(name="ProductDetails")
			public Object[][] getproductdata()
			{
				return new Object[][]
						{
					{"product1","type1",0.0,10.0,"upc1","desc1","manufacture1","model1","url1","image1"},
					{"product2","type2",2.0,20.0,"upc2","desc2","manufacture3","model2","url2","image2"},
				{"product3","type3",3.0,30.0,"upc3","desc3","manufacture3","model3","url3","image3"}
					
					};
				
			}
	
	
	}




