package com.bestbuyapiplayground.model;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CreateNewProductSteps {
	@Step("Create new product with given information name:{0},type:{1},price:{2},shipping:{3},upc:{4},description:{5},manufacturer:{6},model:{7},url:{8},image:{9}")
    public ValidatableResponse createANewUser(
    		String name, String type,Integer price,int shipping,String upc,String description,
			String manufacturer
			,String model,String url,String image)
    {
        CreateProduct p = new CreateProduct();
       p.setName(name);
       p.setType(type);
       p.setPrice(price);
       p.setShipping(shipping);
       p.setUpc(upc);
       p.setDescription(description);
       p.setManufacturer(manufacturer);
       p.setModel(model);
       p.setUrl(url);
       p.setImage(image);
 
       return SerenityRest.given().header("Content-Type","application/json")
                .when()
                .body(p)
                .post("products")
                .then().log().all(true);
    }
}


