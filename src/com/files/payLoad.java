package com.files;

public class payLoad {
	
	public static String AddPlace()
	{
	  return("{\r\n" + 
	  		"  \"location\": {\r\n" + 
	  		"    \"lat\": -28.383494,\r\n" + 
	  		"    \"lng\": 23.427362\r\n" + 
	  		"  },\r\n" + 
	  		"  \"accuracy\": 50,\r\n" + 
	  		"  \"name\": \"Singaram house\",\r\n" + 
	  		"  \"phone_number\": \"(+91) 9944467500\",\r\n" + 
	  		"  \"address\": \"f3, , subasri flats\",\r\n" + 
	  		"  \"types\": [\r\n" + 
	  		"    \"home sweethome\",\r\n" + 
	  		"    \"home\"\r\n" + 
	  		"  ],\r\n" + 
	  		"  \"website\": \"http://srinis.com\",\r\n" + 
	  		"  \"language\": \"French-IN\"\r\n" + 
	  		"}\r\n" + 
	  		"");
	}

	
	public static String addBook(String isbn ,String aisle)
	{
		String payload= "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Story book\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"Mohan\"\r\n" + 
				"}\r\n" + 
				"";
		return payload;
	}
	
	public static  String CoursePrice()
	{
		return "{\r\n" + 
				"\r\n" + 
				"\"dashboard\": {\r\n" + 
				"\r\n" + 
				"\"purchaseAmount\": 910,\r\n" + 
				"\r\n" + 
				"\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"\"courses\": [\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Selenium Python\",\r\n" + 
				"\r\n" + 
				"\"price\": 50,\r\n" + 
				"\r\n" + 
				"\"copies\": 6\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Cypress\",\r\n" + 
				"\r\n" + 
				"\"price\": 40,\r\n" + 
				"\r\n" + 
				"\"copies\": 4\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"RPA\",\r\n" + 
				"\r\n" + 
				"\"price\": 45,\r\n" + 
				"\r\n" + 
				"\"copies\": 10\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"]\r\n" + 
				"\r\n" + 
				"}";
	}
}
