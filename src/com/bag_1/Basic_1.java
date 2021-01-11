package com.bag_1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import com.files.ReusableMethods;
import com.files.payLoad;
public class Basic_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Add place API Validation
		//....
		//Base URL
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payLoad.AddPlace()).when().post("/maps/api/place/add/json")
		  .then().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String place_id=js.getString("place_id");
		
		System.out.println("Extracted place id"+ place_id);
		
		
		
		//Goal 2 update the address 
		String new_address="f4, , subasri flats mangala";
				
				given().log().all().queryParam("key", "qaclick123").header("contentType","application/json").body("{\r\n" + 
				"\"place_id\":\""+place_id+"\",\r\n" + 
				"\"address\": \""+new_address+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").
		when().put("maps/api/place/update/json") 
		.then().assertThat().log().all().statusCode(200).body("msg",equalTo( "Address successfully updated"));		
		
				
		//Goal 3 
				//Way 1 
				
				given().queryParam("key","qaclick123").queryParam("place_id", place_id).when().get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200).body("address", equalTo("f4, , subasri flats mangala"));
		
				
				//Way2 
				
			String getplaceResponse=	given().queryParam("key","qaclick123").queryParam("place_id", place_id).when().get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
				
           //JsonPath jp = new JsonPath(getplaceResponse);
			JsonPath jp=ReusableMethods.rawToJson(getplaceResponse);
           String updatedAddress = jp.getString("address");
           System.out.println("Updated address------------------"+updatedAddress);
           Assert.assertEquals(updatedAddress,new_address );
           
   
   
	}

}
