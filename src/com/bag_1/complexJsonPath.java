package com.bag_1;

import org.testng.Assert;

import com.files.payLoad;

import io.restassured.path.json.JsonPath;



public class complexJsonPath {
	
	public static void main(String args[])
	{
		 
	JsonPath jp = new JsonPath(payLoad.CoursePrice());
	int course_count=jp.getInt("courses.size()");
	System.out.println("Course count "+course_count);
	int purchase_amount=jp.getInt("dashboard.purchaseAmount");
	System.out.println("Purcahse Amount "+purchase_amount);
	String First_course=jp.getString("courses[0].title");
	System.out.println("First course title "+First_course);

	int sum=0;
	for (int i =0;i<course_count;i++)
	{
		String Courses_available=jp.getString("courses["+i+"].title");
		int Courses_prices=jp.getInt("courses["+i+"].price");
		int Courses_copies=jp.getInt("courses["+i+"].copies");
		int book_amount = Courses_copies * Courses_prices;
	    sum = sum +book_amount;
		System.out.println("Course available "+Courses_available+"------------->"+Courses_prices);
		System.out.println("Course total price "+sum);
		
	}
	
	System.out.println("Course total price "+sum);
	int RPA_Copies=jp.getInt("courses[2].copies");
	System.out.println("NO of RPA Copes sold  "+RPA_Copies);
	
	Assert.assertEquals(sum, purchase_amount);
	
	
	
	}

}
