package resources;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import static io.restassured.RestAssured.given;

import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.Json;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import pojo.CreateProduct;
import serviceAPI.ServiceResponse;

public class CreateProductDynamicJson {
	
	List<CreateProduct> carray=new ArrayList<CreateProduct>();
	int count;
	String productName;
	String productId;
	
	@Test(enabled=true,dataProvider="ProductDetails")
	public void createProduct(String name, String type,Double price,Double shipping,String upc,String description,
			String manufacturer
			,String model,String url,String image) throws JsonMappingException, JsonProcessingException
	{

		ServiceResponse sr=new ServiceResponse();		
		Response serviceRes=sr.payloadResponse(name, type, price, shipping, upc, description, manufacturer, model, url, image);
		productName=name;
		String resString=serviceRes.asString();
		JsonPath js=new JsonPath(resString);		
		productId=js.getString("id");		
		System.out.println("product id"+productId);				
		System.out.println("Created Product Name "+productName);		
		assertEquals(serviceRes.getStatusCode(),201);		
		System.out.println(resString);
		ObjectMapper om=new ObjectMapper();	
	
		CreateProduct cpe=om.readValue(resString, CreateProduct.class);		
		System.out.println("cpe"+cpe.getName());	
		carray.add(cpe);
		count=carray.size();		
		System.out.println("Size of the array"+count);	
		arraydetails();
		
	}
	
	public void arraydetails()
	{
		System.out.println("Size of the arrayin the function"+count);
			
		for(CreateProduct it:carray)
		{
			if(it.getName().equalsIgnoreCase(productName))
				
			{
				System.out.println("name matched");
				
				System.out.println(" ID of Matched product name"+productId);
				assertEquals(it.getName(), productName);
				break;
			}
			
		}
		
		
		
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


