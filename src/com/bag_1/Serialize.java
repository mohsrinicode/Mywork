package com.bag_1;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import com.pojo.AddPlace;
import com.pojo.location;
public class Serialize {
	
	
	
	public static void main(String args[])
	
	
	
	{
		
		
		
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		AddPlace ap= new AddPlace();
		location lp = new location();
		
		ap.setAccuracy(60);
		ap.setAddress("f5, , subasri flats new");
		ap.setLanguage("Tamil");
		ap.setName("Singaram house sweet home");
		ap.setWebsite("http://srinis.com");
		ap.setPhone_number("999777773");
		List<String> myList=new ArrayList<String>();
		myList.add("home");
		myList.add("Sweet home");
		ap.setTypes(myList);
		lp.setLat(11111);
		lp.setLng(123345);
		ap.setLocation(lp);
		
		
Response rep=given().queryParam("key", "qaclick123").body(ap)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response(); 
	

String responseString = rep.asString();
System.out.println("Hello"+ responseString);
		
	}
	
	

}
