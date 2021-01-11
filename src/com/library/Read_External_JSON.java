package com.library;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.files.ReusableMethods;
import com.files.payLoad;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Read_External_JSON {
	

	@Test
	public void Add_book() throws IOException
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-Type","Application/json").body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Yekshika R\\Documents\\book.json")))).when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js =ReusableMethods.rawToJson(response);
		String book_id=js.getString("ID");
		System.out.println("Book id"+book_id);
		
		//Delete book
		
		
		
	}

}
