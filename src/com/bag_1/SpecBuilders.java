package com.bag_1;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.pojo.AddPlace;
import com.pojo.location;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

RestAssured.baseURI="https://rahulshettyacademy.com";
		
		AddPlace ap= new AddPlace();
		location lp = new location();
		
		ap.setAccuracy(60);
		ap.setAddress("f51, , subasri flats new");
		ap.setLanguage("Tamil");
		ap.setName("Singaram ho0use sweet home");
		ap.setWebsite("http://srinis.com");
		ap.setPhone_number("99977777k3");
		List<String> myList=new ArrayList<String>();
		myList.add("home");
		myList.add("Sweet home");
		ap.setTypes(myList);
		lp.setLat(11111);
		lp.setLng(123345);
		ap.setLocation(lp);
	
		
	RequestSpecification reqSpec=	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
	
	
	ResponseSpecification resSpec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
	RequestSpecification reqe=given().spec(reqSpec).body(ap);
   
		
	Response rep=reqe.when().post("/maps/api/place/add/json")
		.then().spec(resSpec).extract().response(); 
	

String responseString = rep.asString();
System.out.println("Hello"+ responseString);
		
	}

}
