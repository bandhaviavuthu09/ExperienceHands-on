package resources;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pojo.CreateProduct;

public class Payload {
	
	
	public CreateProduct CreateproductPayLoad(String name, String type,Double price,Double shipping,String upc,String description,
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
	
//	@DataProvider(name="ProductDetails")
//	public Object[][] getproductdata()
//	{
//		return new Object[][]
//				{
//			{"product1","type1",0.0,10.0,"upc1","desc1","manufacture1","model1","url1","image1"},
//			{"product2","type2",2.0,20.0,"upc2","desc2","manufacture3","model2","url2","image2"},
//		{"product3","type3",3.0,30.0,"upc3","desc3","manufacture3","model3","url3","image3"}
//			
//			};
//		
//	}
	 
	 
			
		

}
