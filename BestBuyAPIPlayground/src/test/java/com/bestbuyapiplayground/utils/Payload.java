package com.bestbuyapiplayground.utils;
import com.bestbuyapiplayground.model.*;

import java.util.ArrayList;
import java.util.List;

//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;



public class Payload {
	
	
	public CreateProduct CreateproductPayLoad(String name, String type,Integer price,int shipping,String upc,String description,
			String manufacturer
			,String model,String url,String image)
	{
		CreateProduct cp=new CreateProduct();
		cp.setName(name);
		cp.setType(type);
		cp.setPrice(price);
		cp.setShipping(shipping);
		cp.setUpc(upc);
		cp.setManufacturer(manufacturer);
		cp.setDescription(description);
		cp.setModel(model);
		cp.setUrl(url);
		cp.setImage(image);
				
		return cp;
		
	}
	
	public CreateService CreateServicePayload(String name)
	{
		CreateService cs=new CreateService();
		cs.setName(name);

		return cs;
	}
			
		

}
