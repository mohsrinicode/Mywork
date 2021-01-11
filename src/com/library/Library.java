package com.library;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.files.ReusableMethods;
import com.files.payLoad;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Library {
	
	@Test(dataProvider="BookData")
	public void Add_book(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-Type","Application/json").body(payLoad.addBook(isbn,aisle)).when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js =ReusableMethods.rawToJson(response);
		String book_id=js.getString("ID");
		System.out.println("Book id"+book_id);
		
		//Delete book
		
		
		
	}
	
	
	
	

	
	@DataProvider(name="BookData")
	public Object[][] getData()
	{
		//Array is collection of element
		//multi dimentinal array = collection of array
	return	new Object[][] {{"plm","mlp01"},{"ijn","0uh"},{"vgy","9uhg"}};
	}
}
