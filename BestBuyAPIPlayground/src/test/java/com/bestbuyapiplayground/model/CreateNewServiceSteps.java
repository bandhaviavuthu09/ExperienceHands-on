package com.bestbuyapiplayground.model;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CreateNewServiceSteps {
	@Step("Create new product with given information name:{0}")
    public ValidatableResponse createNewService(
    		String name)
    {
        CreateService p = new CreateService();
       p.setName(name);
       
 
       return SerenityRest.given().header("Content-Type","application/json")
                .when()
                .body(p)
                .post("services")
                .then().log().all(true);
    }
}


